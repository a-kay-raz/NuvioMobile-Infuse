package com.nuvio.app.features.cloudstream

internal actual object CloudStreamPlatformRuntime {
    actual val supportsAndroidDex: Boolean = false

    actual fun initialize(context: Any?) = Unit
    actual suspend fun provider(plugin: CloudStreamPluginItem, apiClassName: String?): CloudStreamProvider? = null
    actual suspend fun syncDynamicRepositories(plugin: CloudStreamPluginItem) = Unit
    actual suspend fun registerNativeRepository(url: String, name: String, iconUrl: String?) = Unit
    actual suspend fun removeNativeRepository(url: String) = Unit
    actual fun unload(pluginId: String) = Unit
    actual fun clear() = Unit

    actual suspend fun getCs3PluginApis(plugin: CloudStreamPluginItem): List<Cs3PluginApi>? = null
    actual suspend fun openCs3PluginNativeSettings(plugin: CloudStreamPluginItem): Boolean = false
}
