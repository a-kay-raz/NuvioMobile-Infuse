package com.nuvio.app.features.cloudstream

internal interface CloudStreamProvider {
    val id: String
    suspend fun getMainPage(page: Int): List<Pair<String, List<CloudStreamSearchItem>>>
    suspend fun search(query: String): List<CloudStreamSearchItem>
    suspend fun loadByExternalId(externalId: String): CloudStreamLoadItem? = null
    suspend fun load(data: String): CloudStreamLoadItem
    suspend fun loadLinks(data: String): List<CloudStreamPlaybackSource>
}

internal expect object CloudStreamPlatformRuntime {
    val supportsAndroidDex: Boolean

    fun initialize(context: Any?)

    /**
     * Builds the provider serving a plugin's catalogs. When [apiClassName] is
     * given, only that MainAPI serves content (the Home selector's per-API
     * pick); a name that matches no enabled API falls back to all enabled
     * APIs, so a stale selection never blanks the Home screen.
     */
    suspend fun provider(plugin: CloudStreamPluginItem, apiClassName: String? = null): CloudStreamProvider?
    fun unload(pluginId: String)
    suspend fun registerNativeRepository(url: String, name: String, iconUrl: String?)
    suspend fun removeNativeRepository(url: String)
    fun clear()

    /**
     * Lists the MainAPIs a loaded .cs3 plugin registers (stable class name +
     * display name). Returns null when the plugin is not installed/runnable
     * or could not be loaded; an empty list when it registers no MainAPIs.
     * This is the generic data behind the host-built Plugin Settings dialog.
     */
    suspend fun getCs3PluginApis(plugin: CloudStreamPluginItem): List<Cs3PluginApi>?

    /**
     * Opens a .cs3 plugin's own native settings UI through its `openSettings`
     * entry point. Returns true when the plugin exposed an entry point and it
     * was invoked without throwing; false when the plugin has no entry point,
     * is not installed/runnable, or invoking it failed. The plugin's own UI
     * (for example a platform AlertDialog) needs an Activity window token, so
     * this runs on the main thread with the host activity the runtime was
     * initialized with.
     */
    suspend fun openCs3PluginNativeSettings(plugin: CloudStreamPluginItem): Boolean
}
