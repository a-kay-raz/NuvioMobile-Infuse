package com.nuvio.app.features.plugins

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.nuvio.app.core.ui.DialogButton
import com.nuvio.app.core.ui.DialogButtonStyle
import com.nuvio.app.core.ui.DialogButtons
import com.nuvio.app.core.ui.DialogSurface
import com.nuvio.app.features.cloudstream.CloudStreamPluginItem
import com.nuvio.app.features.cloudstream.CloudStreamRepository
import com.nuvio.app.features.cloudstream.Cs3PluginApi

/**
 * Generic host-built Plugin Settings dialog (the "Nuvio UI" gear-button
 * mode). It renders only what a loaded .cs3 plugin generically exposes
 * through the runtime: its registered MainAPIs, as a Providers list with
 * per-provider toggles. Toggles apply immediately and are persisted per
 * plugin + MainAPI class in the generic CS3 state payload (not in any
 * plugin-owned keys), and the runtime only serves content from enabled
 * MainAPIs. Plugins that register no MainAPIs never reach this dialog —
 * the caller shows "This plugin has no settings." instead.
 */
@Composable
internal fun Cs3PluginSettingsDialog(
    plugin: CloudStreamPluginItem,
    apis: List<Cs3PluginApi>,
    copy: CloudStreamSettingsCopy,
    onDismiss: () -> Unit,
) {
    var disabled by remember(apis, plugin.metadata.id.value) {
        mutableStateOf(plugin.disabledApiClassNames.toSet())
    }
    DialogSurface(
        onDismissRequest = onDismiss,
        title = copy.pluginSettingsTitle(plugin.metadata.name),
    ) {
        Text(
            text = copy.pluginProvidersDescription,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Text(
            text = copy.pluginProvidersEnabled(apis.size - disabled.size, apis.size),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .heightIn(max = 420.dp)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            apis.forEach { api ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Column(
                        modifier = Modifier.weight(1f),
                        verticalArrangement = Arrangement.spacedBy(2.dp),
                    ) {
                        Text(
                            text = api.displayName,
                            style = MaterialTheme.typography.bodyLarge,
                        )
                        Text(
                            text = api.className,
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.onSurfaceVariant,
                        )
                    }
                    Switch(
                        checked = api.className !in disabled,
                        onCheckedChange = { checked ->
                            disabled = if (checked) disabled - api.className else disabled + api.className
                            CloudStreamRepository.setPluginApiEnabled(
                                plugin.metadata.id.value,
                                api.className,
                                checked,
                            )
                        },
                    )
                }
            }
        }
        DialogButtons {
            DialogButton(
                text = copy.dialogDone,
                onClick = onDismiss,
                style = DialogButtonStyle.Primary,
            )
        }
    }
}
