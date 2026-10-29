package com.nuvio.app.features.whatsnew

import com.nuvio.app.features.addons.httpRequestRaw
import kotlinx.coroutines.CancellationException
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlin.time.Clock

private const val COMMITS_URL =
    "https://api.github.com/repos/a-kay-raz/NuvioMobile-Infuse/commits?sha=enhanced&per_page=30"

@Serializable
private data class GitHubCommitAuthorDto(
    val name: String? = null,
    val date: String? = null,
)

@Serializable
private data class GitHubCommitDetailDto(
    val message: String? = null,
    val author: GitHubCommitAuthorDto? = null,
)

@Serializable
private data class GitHubCommitUserDto(
    val login: String? = null,
)

@Serializable
private data class GitHubCommitDto(
    val sha: String? = null,
    val html_url: String? = null,
    val commit: GitHubCommitDetailDto? = null,
    val author: GitHubCommitUserDto? = null,
)

/**
 * Loads the latest commits on the Infuse enhanced branch from GitHub.
 *
 * This deliberately does NOT read any GitHub release, release body or
 * changelog: release notes stay on GitHub only. Only commit titles,
 * authors and dates are shown in the app.
 */
internal object WhatsNewCommitsRepository {
    private val json = Json {
        ignoreUnknownKeys = true
        isLenient = true
    }

    suspend fun load(): Result<WhatsNewCommitsContent> {
        return try {
            val response = httpRequestRaw(
                method = "GET",
                url = COMMITS_URL,
                headers = mapOf(
                    "Accept" to "application/vnd.github+json",
                    "User-Agent" to "NuvioMobile-Infuse",
                ),
                body = "",
            )
            check(response.status in 200..299) {
                "GitHub commits request failed: " + response.status
            }
            val commits = json.decodeFromString<List<GitHubCommitDto>>(response.body)
                .mapNotNull { dto ->
                    val sha = dto.sha?.takeIf { it.isNotBlank() } ?: return@mapNotNull null
                    val message = dto.commit?.message?.takeIf { it.isNotBlank() } ?: sha
                    val title = message.substringBefore("\n").trim().ifBlank { sha }
                    val authorName = dto.commit?.author?.name?.takeIf { it.isNotBlank() }
                        ?: dto.author?.login?.takeIf { it.isNotBlank() }
                        ?: "Unknown"
                    InfuseCommit(
                        sha = sha,
                        shortSha = sha.take(7),
                        title = title,
                        authorName = authorName,
                        authorLogin = dto.author?.login,
                        date = dto.commit?.author?.date,
                        htmlUrl = dto.html_url,
                    )
                }
            Result.success(
                WhatsNewCommitsContent(
                    commits = commits,
                    fetchedAtMillis = Clock.System.now().toEpochMilliseconds(),
                ),
            )
        } catch (error: CancellationException) {
            throw error
        } catch (error: Throwable) {
            Result.failure(error)
        }
    }
}
