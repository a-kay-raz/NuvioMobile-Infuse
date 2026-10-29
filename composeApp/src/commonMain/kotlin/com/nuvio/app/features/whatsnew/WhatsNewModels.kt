package com.nuvio.app.features.whatsnew

/**
 * One commit from the Infuse repository's enhanced branch.
 *
 * Only the commit's identity, title, author and date are shown in the app.
 * The full commit detail lives on GitHub and is opened in the browser when
 * the user taps a commit; it is never rendered as an in-app changelog.
 */
internal data class InfuseCommit(
    val sha: String,
    val shortSha: String,
    val title: String,
    val authorName: String,
    val authorLogin: String?,
    /** ISO-8601 date as returned by the GitHub API, e.g. 2026-10-29T01:52:16Z. */
    val date: String?,
    val htmlUrl: String?,
)

internal data class WhatsNewCommitsContent(
    val commits: List<InfuseCommit>,
    val fetchedAtMillis: Long,
)
