package com.nuvio.app.features.whatsnew

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.NewReleases
import androidx.compose.material.icons.rounded.OpenInNew
import androidx.compose.material.icons.rounded.Refresh
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.nuvio.app.core.build.AppVersionConfig
import com.nuvio.app.core.ui.NuvioLoadingIndicator
import com.nuvio.app.core.ui.NuvioScreen
import com.nuvio.app.core.ui.NuvioScreenHeader
import com.nuvio.app.core.ui.NuvioSurfaceCard
import com.nuvio.app.core.ui.NuvioTokens
import com.nuvio.app.core.ui.nuvio
import nuvio.composeapp.generated.resources.Res
import nuvio.composeapp.generated.resources.compose_settings_page_whats_new
import nuvio.composeapp.generated.resources.whats_new_commits_load_failed
import nuvio.composeapp.generated.resources.whats_new_commits_no_commits
import nuvio.composeapp.generated.resources.whats_new_commits_subtitle
import nuvio.composeapp.generated.resources.whats_new_open_github
import nuvio.composeapp.generated.resources.whats_new_refresh
import nuvio.composeapp.generated.resources.whats_new_release_format
import nuvio.composeapp.generated.resources.whats_new_retry
import org.jetbrains.compose.resources.stringResource

/**
 * What's New, showing only the latest commits on the Infuse enhanced
 * branch. No channel picker, no Stable/Beta, no update-available or
 * up-to-date status, no release notes and no GitHub release changelog
 * are shown here: tapping a commit opens it on GitHub, where the full
 * commit detail lives.
 */
@Composable
fun WhatsNewSettingsScreen(onBack: () -> Unit) {
    var state by remember { mutableStateOf<LoadState>(LoadState.Loading) }
    var refreshKey by rememberSaveable { mutableIntStateOf(0) }
    var isRefreshing by remember { mutableStateOf(false) }

    LaunchedEffect(refreshKey) {
        state = LoadState.Loading
        isRefreshing = true
        try {
            val result = WhatsNewCommitsRepository.load()
            state = result.fold(
                onSuccess = LoadState::Content,
                onFailure = { LoadState.Error },
            )
        } finally {
            isRefreshing = false
        }
    }

    NuvioScreen {
        stickyHeader {
            NuvioScreenHeader(
                title = stringResource(Res.string.compose_settings_page_whats_new),
                onBack = onBack,
                actions = {
                    if (isRefreshing) {
                        Box(
                            modifier = Modifier.size(48.dp),
                            contentAlignment = Alignment.Center,
                        ) {
                            CircularProgressIndicator(
                                modifier = Modifier.size(NuvioTokens.Icon.md),
                                strokeWidth = 2.dp,
                                color = MaterialTheme.nuvio.colors.textPrimary,
                            )
                        }
                    } else {
                        IconButton(onClick = { refreshKey++ }) {
                            Icon(
                                imageVector = Icons.Rounded.Refresh,
                                contentDescription = stringResource(Res.string.whats_new_refresh),
                                tint = MaterialTheme.nuvio.colors.textPrimary,
                            )
                        }
                    }
                },
            )
        }

        item {
            NuvioSurfaceCard {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(NuvioTokens.Space.s6),
                ) {
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.spacedBy(NuvioTokens.Space.s8),
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.NewReleases,
                            contentDescription = null,
                            modifier = Modifier.size(NuvioTokens.Icon.md),
                            tint = MaterialTheme.nuvio.colors.accent,
                        )
                        Text(
                            text = stringResource(
                                Res.string.whats_new_release_format,
                                AppVersionConfig.VERSION_NAME,
                            ),
                            modifier = Modifier.weight(1f),
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.nuvio.colors.textPrimary,
                            maxLines = 1,
                            overflow = TextOverflow.Ellipsis,
                        )
                    }
                    Text(
                        text = stringResource(Res.string.whats_new_commits_subtitle),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.nuvio.colors.textSecondary,
                    )
                }
            }
        }

        when (val value = state) {
            LoadState.Loading -> item {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 48.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    NuvioLoadingIndicator()
                }
            }

            LoadState.Error -> item {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(NuvioTokens.Space.s6),
                ) {
                    Text(
                        text = stringResource(Res.string.whats_new_commits_load_failed),
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.nuvio.colors.textPrimary,
                    )
                    TextButton(onClick = { refreshKey++ }) {
                        Text(stringResource(Res.string.whats_new_retry))
                    }
                }
            }

            is LoadState.Content -> {
                if (value.content.commits.isEmpty()) {
                    item {
                        Text(
                            text = stringResource(Res.string.whats_new_commits_no_commits),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.nuvio.colors.textPrimary,
                        )
                    }
                } else {
                    value.content.commits.forEach { commit ->
                        item(key = commit.sha) {
                            CommitCard(commit = commit)
                        }
                    }
                }
            }
        }

        item(key = "whats-new-bottom-spacer") {
            Spacer(modifier = Modifier.size(80.dp))
        }
    }
}

private sealed interface LoadState {
    data object Loading : LoadState
    data object Error : LoadState
    data class Content(val content: WhatsNewCommitsContent) : LoadState
}

@Composable
private fun CommitCard(commit: InfuseCommit) {
    val uriHandler = LocalUriHandler.current
    NuvioSurfaceCard {
        Column(
            modifier = Modifier.fillMaxWidth(),
            verticalArrangement = Arrangement.spacedBy(NuvioTokens.Space.s2),
        ) {
            Text(
                text = commit.shortSha,
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.nuvio.colors.textSecondary,
            )
            Text(
                text = commit.title,
                style = MaterialTheme.typography.bodyLarge,
                fontWeight = FontWeight.SemiBold,
                color = MaterialTheme.nuvio.colors.textPrimary,
            )
            Text(
                text = listOfNotNull(
                    commit.authorLogin?.let { "@$it" } ?: commit.authorName,
                    commit.date?.take(10)?.takeIf { it.isNotBlank() },
                ).joinToString(" • "),
                style = MaterialTheme.typography.labelSmall,
                color = MaterialTheme.nuvio.colors.textMuted,
            )
            commit.htmlUrl?.let { url ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    TextButton(
                        colors = ButtonDefaults.textButtonColors(
                            contentColor = MaterialTheme.nuvio.colors.textSecondary,
                        ),
                        onClick = { uriHandler.openUri(url) },
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.OpenInNew,
                            contentDescription = null,
                            modifier = Modifier.size(NuvioTokens.Icon.sm),
                        )
                        Spacer(modifier = Modifier.size(NuvioTokens.Space.s4))
                        Text(stringResource(Res.string.whats_new_open_github))
                    }
                }
            }
        }
    }
}
