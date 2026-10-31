package com.nuvio.app.features.settings

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.NewReleases
import androidx.compose.material.icons.rounded.Policy
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.nuvio.app.core.build.AppVersionConfig
import nuvio.composeapp.generated.resources.Res
import nuvio.composeapp.generated.resources.compose_settings_page_whats_new
import nuvio.composeapp.generated.resources.whats_new_root_description
import nuvio.composeapp.generated.resources.about_licenses_attributions_subtitle
import nuvio.composeapp.generated.resources.compose_about_version_format
import nuvio.composeapp.generated.resources.compose_settings_page_licenses_attributions
import nuvio.composeapp.generated.resources.compose_settings_page_privacy_policy
import nuvio.composeapp.generated.resources.compose_settings_root_about_section
import nuvio.composeapp.generated.resources.compose_settings_root_privacy_policy_description
import org.jetbrains.compose.resources.stringResource

private const val PRIVACY_POLICY_URL = "https://nuvio.tv/privacy-policy"

internal fun LazyListScope.aboutSettingsContent(
    isTablet: Boolean,
    onSupportersContributorsClick: () -> Unit,
    onLicensesAttributionsClick: () -> Unit,
    showSupportersContributorsPage: Boolean,
    onWhatsNewClick: (() -> Unit)? = null,
) {
    item {
        val uriHandler = LocalUriHandler.current
        SettingsSection(
            title = stringResource(Res.string.compose_settings_root_about_section),
            isTablet = isTablet,
        ) {
            SettingsGroup(isTablet = isTablet) {
                // Infuse: Contributors/Supporters row intentionally hidden, even
                // when showSupportersContributorsPage is true upstream.
                if (onWhatsNewClick != null) {
                    SettingsNavigationRow(
                        title = stringResource(Res.string.compose_settings_page_whats_new),
                        description = stringResource(Res.string.whats_new_root_description),
                        icon = Icons.Rounded.NewReleases,
                        isTablet = isTablet,
                        onClick = onWhatsNewClick,
                    )
                    SettingsGroupDivider(isTablet = isTablet)
                }
                SettingsNavigationRow(
                    title = stringResource(Res.string.compose_settings_page_privacy_policy),
                    description = stringResource(Res.string.compose_settings_root_privacy_policy_description),
                    icon = Icons.Rounded.Policy,
                    isTablet = isTablet,
                    onClick = { uriHandler.openUri(PRIVACY_POLICY_URL) },
                )
                SettingsGroupDivider(isTablet = isTablet)
                SettingsNavigationRow(
                    title = stringResource(Res.string.compose_settings_page_licenses_attributions),
                    description = stringResource(Res.string.about_licenses_attributions_subtitle),
                    icon = SettingsPage.LicensesAttributions.icon,
                    isTablet = isTablet,
                    onClick = onLicensesAttributionsClick,
                )
            }
        }
    }
    settingsFooterContent(isTablet)
}

internal fun LazyListScope.settingsFooterContent(isTablet: Boolean) {
    item {
        androidx.compose.foundation.layout.Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp, vertical = if (isTablet) 20.dp else 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                text = "NUVIO Enhanced",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.titleMedium.copy(
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                ),
                color = MaterialTheme.colorScheme.primary,
                textAlign = TextAlign.Center,
            )
            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier.height(2.dp),
            )
            Text(
                text = "BY A-Kay Raz",
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                ),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
            androidx.compose.foundation.layout.Spacer(
                modifier = Modifier.height(4.dp),
            )
            Text(
                text = stringResource(
                    Res.string.compose_about_version_format,
                    AppVersionConfig.VERSION_NAME,
                    AppVersionConfig.VERSION_CODE,
                ),
                modifier = Modifier.fillMaxWidth(),
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                textAlign = TextAlign.Center,
            )
        }
    }
}
