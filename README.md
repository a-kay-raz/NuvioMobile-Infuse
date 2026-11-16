<div align="center">

  <img src="https://nuvio.tv/assets/nuvio-app-logo-wordmark.webp" alt="Nuvio Enhanced" width="320" />

  <h1>NuvioMobile-Enhanced+</h1> 

  <p>
    An advanced, feature-packed fork of <a href="https://github.com/NuvioMedia/NuvioMobile">Nuvio Mobile</a> that keeps pace with upstream while introducing a pure <b>CloudStream 3 (CS3)</b> & <b>Stremio</b> engine, out-of-the-box tracking integrations, hardware volume boost, and deep platform polish.
    <br /><br />
    Bring your own sources. NuvioMobile-Enhanced+ transforms them into a unified streaming library with rich artwork, ratings, synchronized subtitles, and your progress saved across all devices.
  </p>

  <p>
    <a href="https://github.com/a-kay-raz/NuvioMobile-Infuse/releases/latest">
      <img src="https://img.shields.io/github/v/release/a-kay-raz/NuvioMobile-Infuse?color=blue&label=Latest%20Release&style=for-the-badge" alt="Latest Release" />
    </a>
    <img src="https://img.shields.io/badge/Platform-Android%20%7C%20iOS-green?style=for-the-badge" alt="Platform" />
    <img src="https://img.shields.io/badge/License-GPL--3.0-orange?style=for-the-badge" alt="License" />
  </p>

</div>

> [!IMPORTANT]
> **Unofficial Fork:** This build is independently maintained and is not officially affiliated with or endorsed by the upstream Nuvio team. Please report any issues or feature requests directly to **this** repository.

---

## 📥 Download & Install

### Android
Download the latest pre-compiled APK directly from the releases page:
- 📲 **[Download Latest Android APK](https://github.com/a-kay-raz/NuvioMobile-Infuse/releases/latest)** — `androidApp-full-arm64-v8a-release.apk` (arm64, v0.6.5)

### iOS (AltStore / SideStore / LiveContainer)
No IPA is published from this repository — its only workflow builds the Android APK (see below). The iOS app code is still in the tree, so an IPA can be built from source if needed.

---

## ✨ What Nuvio Enhanced Adds

Everything listed below has been built and refined on top of upstream Nuvio Mobile, plus the custom work ported from techforfriend/Nuvio-enhanced-2:

### 🔌 Next-Gen Extensions & Providers Engine

| Feature | Description | Where |
|---|---|---|
| **Pure CloudStream 3 (CS3) Architecture** | Full native integration with CloudStream 3 repositories and plugins. Clean, stable, and lightweight memory footprint. | Settings → Extensions → CloudStream |
| **Repository Master Toggles** | Turn entire extension repositories on or off with a single master toggle, or manage individual plugins granularly. | Settings → Extensions → Repositories |
| **Stremio Addon Ecosystem** | Native support for Stremio community and official addons for catalog discovery and multi-source streaming. | Settings → Extensions → Stremio Addons |
| **Home Screen Extension Selector** | Switch between all active extensions or choose a specific extension to instantly display dedicated catalog shelves. | Home Screen header dropdown |
| **Ordered Catalog Shelves** | Catalogs load concurrently with strict priority ordering: Stremio addons first, followed by CloudStream plugins. | Home Screen |

### Home

| **Hero trailer autoplay** — trailers play in the hero carousel instead of static artwork. The carousel stops auto-advancing while a trailer plays, so it only moves when you swipe. | Settings → Layout → Home Layout → **Hero Trailer Playback** | Off |
| **Trailer start with sound** — start the hero trailer unmuted instead of muted. You can still mute it with the speaker button. Appears once trailer playback is on. | Settings → Layout → Home Layout → **Start with sound** | Off |
| **Trailer start delay** — how long the artwork holds before the trailer starts, `Instant` to 10 s. Appears once trailer playback is on. | Settings → Layout → Home Layout → **Trailer Start Delay** | Instant |
| **Hero style** — `Full-bleed` (artwork spans the screen) or `Card` (rounded, inset). | Settings → Layout → Home Layout → **Hero Style** | Full-bleed |
| **Dynamic background** — tints the home screen with a gradient pulled from the featured artwork's colours. | Settings → Layout → Home → **Dynamic background color** | Off |
| **Catalog accent underline** — accent rule under each catalog row heading. | Settings → Layout → Home → **Catalog accent underline** | Off |
| **Smart hero framing** — when a wide backdrop is cropped to fit the hero, the visible part is chosen to keep the subject in frame instead of always cutting to the centre. | — | Always on |
| **Accent gradient on more surfaces** — the theme's accent gradient also colours settings and Profile Insight icons, Taste DNA bars and chips, the catalog accent underline, primary buttons, and the tinted iOS tab bar in every tab bar mode. | Settings → Layout → **Theme** | Follows the selected theme |

### Appearance

| Feature | Where | Default |
|---|---|---|
| **App background** — set a photo from your gallery or any image URL (JPG, PNG, GIF or WebP) as the background behind every screen. | Settings → Appearance → **Background** | Default |
| **Glass UI** *(experimental)* — cards, sheets, dialogs and headers become frosted glass over the app background, with `Dark`, `Balanced` and `Vivid` styles. | Settings → Appearance → **Glass UI** | Off |
| **More posters in landscape** — Discover and collection folders show 6 posters per row in landscape on phones and 7 on tablets. | — | Always on |

### Player

| Feature | Where | Default |
|---|---|---|
| **Tap-to-seek on the timeline** — tap anywhere on the progress bar to jump there. | — | Always on |
| **Volume Boost** — volume can be boosted past 100% | Swipe up all the way past 100% | Always on |
| **Stream Quality Chooser** — add quality indicator and ability to choose quality on HLS stream whenever available, in both the legacy and the new control layout | Player screen overlay | Best quality supported by hardware |
| **Info Button** — add playback info button to show currently playing video and audio information, in both the legacy and the new control layout | Player screen overlay | — |
| **Picture in Picture button** — enter PiP straight from the player overlay, in both the legacy and the new control layout. | Player screen overlay | — |
| **Gesture readouts** — swiping shows the seek target and delta, and the volume/brightness percentage, in the new control layout as well. | — | Always on |
| **Swipe to Seek toggle** — an option to turn it off to prevent accidental seeking while keeping the up/down brightness and volume swipes. | Settings → Playback → **Swipe to Seek** (under Touch Gestures) | On |
| **Hardware keyboard shortcuts** — <kbd>Space</kbd> play/pause, <kbd>←</kbd> / <kbd>→</kbd> seek, <kbd>↑</kbd> / <kbd>↓</kbd> volume, <kbd>Esc</kbd> leave the player. Inert while a panel is open or the controls are locked. | — | Always on |
| **Adjustable subtitle transparency** | Settings → Playback → Subtitle Rendering → **Background Color** | — |
| **Subtitle shadow** — a soft shadow behind subtitle text, with adjustable strength, to keep it readable on bright scenes. | Settings → Playback → Subtitle Rendering → **Shadow** | Off |
| **Outline blur** — softens only the subtitle outline while the text stays sharp. | Settings → Playback → Subtitle Rendering → **Outline blur** | Off |
| **Subtitle style per device** — subtitle size, colours, outline and position are kept per device, so a phone and a tablet on the same profile can look different. | — | Always on |
| **Custom subtitle fonts** — import a `.ttf` or `.otf` file and use it for subtitles. Fonts stay on the device; subtitles in non-Latin scripts keep a font that supports them. | Settings → Playback → Subtitle Rendering → **Font** → **Import Font** | Default |
| **Hebrew subtitle punctuation fix** *(iOS)* — external Hebrew subtitles authored for left-to-right renderers get their punctuation moved back to the end of the sentence. Correctly authored files are left untouched. | — | Always on |
| **Sync subtitles by ear** — tap **Heard** when you hear a line and **Saw** when its subtitle appears, in either order, and the offset is set for you. | Player → Subtitles panel → **Sync by ear** | — |
| **Buffered range on the legacy seek bar** — the legacy control layout's timeline shows how far ahead the stream is buffered, like the new layout does. | — | Always on |
| **Seek bar thumbnails** — a preview frame floats above the seek bar while you drag it, so you can see where you will land. Frames are grabbed from the stream itself (stream headers and extension-less HLS included) only around scrubbing: the connection opens shortly after the controls appear and is released after a short idle. | Settings → Playback → **Seek Bar Thumbnails** | On |
| **Player buttons** — choose and order the player buttons. In the new layout, pick which buttons stay on the bar and which sit behind the arrow. In the legacy layout, reorder or hide the top and bottom bar buttons; hidden buttons are not shown at all. | Settings → Playback → **Player buttons** (new layout) / **Top bar buttons** and **Bottom bar buttons** (legacy layout) | All buttons in the usual order |
| **Keeps playing behind Notification Center** *(iOS)* — pulling down Notification Center no longer pauses the video: audio keeps going and the picture picks up right where it is when you come back. If you stay away for more than 10 seconds, playback pauses as before. | — | Always on |
| **Movie recommendations** — in the last four minutes of a movie, a small card suggests More Like This titles you haven't watched, from your chosen More Like This source (TMDB, Trakt or SIMKL, falling back to TMDB). Dismissing it snoozes it for a minute. | Settings → Playback → **Movie Recommendations** | On |
| **Night mode** — a player button that evens out loud and quiet scenes for listening at a low volume, on every engine including iOS. | Settings → Playback → Audio → **Night Mode Button** | Button shown, night mode off |
| **Anime4K** *(Android)* — a 2x upscaler and a line sharpener for anime, on ExoPlayer and libmpv. Only applied to anime. | Settings → Playback → Video → **Anime 2x Upscaler** / **Anime Line Sharpener** | Off |
| **Plain controls** — hide the glass backgrounds behind player buttons and time pills, and hide the skip back/forward buttons. | Settings → Playback → Player interface → **Glass Backgrounds on Controls** / **Show Skip Buttons** | On |
| **Title logo in the player** — show the title artwork instead of the title text in the player controls. | Settings → Playback → Player interface → **Show title logo** | Off |
| **Skip Intro timing** — show the Skip Intro button earlier or later than the intro timestamp. | Settings → Playback → Skip segments → **Skip Intro Timing** | On time |
| **Download speed while loading** — the loading screen shows how fast the stream is downloading. | — | Always on |
| **Mini player** *(Android)* — keep watching in a small floating window while you browse. Tap it to return to full screen. With it on, the player's back button still ends playback; use the **PiP** button in the player header (or the system back gesture) to minimize. | Settings → Playback → **Mini Player** | Off |
| **Private viewing** — play without saving watch progress, Continue Watching or watched status, and without syncing playback to connected trackers. | Settings → Playback → **Private Viewing** | Off |

### Live TV

Upstream Nuvio has no Live TV. This fork adds the whole feature.

| Feature | Where | Default |
|---|---|---|
| **M3U playlists** | Settings → Integrations → Live TV → **Playlists** | — |
| **Xtream** — connect with a server URL, username and password. | Settings → Integrations → Live TV → **Providers** → Xtream | Not configured |
| **Stalker Portal** — connect with a portal URL and MAC address; login details optional. | Settings → Integrations → Live TV → **Providers** → Stalker Portal | Not configured |
| **TV guide (EPG)** — now/next programmes in the channel list and the player, plus a full guide per channel. XMLTV guides linked in playlists and from Xtream/Stalker are found automatically; you can also add your own `.xml` or `.xml.gz` URLs. | Settings → Integrations → Live TV → **TV Guide (EPG)** | Auto-detect on |
| **Quality chooser** — pick a quality on HLS channels that offer several; Auto stays the default. | Player screen overlay | Auto |
| **Category search** — Live TV search also matches channel categories. | Live TV → search | Always on |
| **Show Live TV in navigation** — the tab appears once at least one source is configured. | Settings → Integrations → Live TV → **Show Live TV in navigation** | On |

### Profiles

| Feature | Where | Default |
|---|---|---|
| **Profile Insights** — activity, library and taste breakdowns for the active profile, in Overview and Taste sections. | Settings → **Profile** | Always available |
| **Custom profile background** — point a profile at any `http(s)` image URL. | Edit Profile → **Choose Profile Background** → Custom → **Custom background URL** | None |
| **Biometric unlock** — unlock the PIN-locked primary profile with fingerprint or Face ID at launch and when switching profiles. The PIN stays available as a fallback. Biometric data never leaves the device; adding or removing a fingerprint or face turns it off until you re-enable it with your PIN. | Edit Profile (primary profile, PIN lock on) → **Biometric unlock** | Off |

### Details & discovery

| Feature | Where | Default |
|---|---|---|
| **More Like This → View All** — the recommendation rail's header opens the full list as a paged grid that keeps loading as you scroll, instead of stopping at one page. | — | Always on when the rail has more to show |
| **Episode navigator** — a sticky bar above the episode list of every season to search episodes by title, plot or number, jump straight to an episode number, and sort (first to last, last to first, highest rated, newest aired, unwatched first). | Details page → episode list | Always on for series |
| **Progress on episode cards** — partially watched episodes show a progress bar on their card. | — | Always on |
| **Original-language titles** — show titles, title logos, posters and backdrops in the title's original language, falling back to your TMDB language when unavailable. | Settings → Content & Discovery → TMDB Enrichment → **Original language** | Off |
| **Budget and revenue** — added to the details block for movies. | Shown with Settings → Layout → Detail Page → **Details** | — |
| **Icon action row** — play/resume spans the full width and the other actions (download, start from the beginning, random episode, external player, watched, library) sit as icons underneath it, instead of hiding behind the 3-dots menu. Turn it off to get the old row back. | Settings → Layout → Detail Page → **Icon action row** | On |
| **Download button** — adds a download button under Play that opens the stream list in download mode. | Settings → Downloads → **Show download button** | On |
| **Trailer start with sound** — start the details-page trailer unmuted. Appears once trailer playback is on. | Settings → Layout → Detail Page → **Start with sound** | Off |
| **In-app ratings** — rate a movie, show, season or episode from 1 to 10 on the details page. The rating syncs to Trakt, SIMKL, MDBList, and/or AniList. | Details page → star row under the actions → **Rate** | — |
| **Library icon on saved items** — the library action shows when a title is already saved. | — | Always on |
| **Desktop hero on tablets** — tablets use the wide desktop details hero with a reworked action layout. | — | Always on on tablets |

### Streams

| Feature | Where | Default |
|---|---|---|
| **Pinned sources** — pin an addon or a scraper source so its results always sort to the top of the stream list. Pins are kept per profile. | Stream list → long-press a stream or its source header → **Pin to top** | None pinned |
| **Search bar** — a filter field above the stream list that narrows the results as you type, matching every term against the stream name, description, source, addon, filename and badges — so `1080 hevc multi` works. | Settings → Layout → Streams → **Search bar** | Off |

### Library

| Feature | Where | Default |
|---|---|---|
| **Library Calendar** — show release date of ongoing series in the library. | Library screen → **calendar icon toggle** | — |
| **WeTrakr Library** — browse your WeTrakr lists as a Library source once WeTrakr is connected. | Library screen → source picker → **WeTrakr** | — |
| **AniList Library** — browse your AniList anime lists as a Library source once AniList is connected. | Library screen → source picker → **AniList** | — |
| **PublicMetaDB Library** — browse your PublicMetaDB lists as a Library source once PublicMetaDB is connected. | Library screen → source picker → **PublicMetaDB** | — |

### Downloads

| Feature | Where | Default |
|---|---|---|
| **Wi-Fi-only downloads** — downloads wait for Wi-Fi unless you allow mobile data. The switch sits at the top of the Downloads screen, not in Settings. | Downloads screen → **Allow mobile data** | Off (Wi-Fi only) |
| **Custom download location** — pick any folder to save downloads to (a folder you grant via Storage Access Framework on Android, or via the Files app on iOS) instead of the app's private storage. | Downloads screen → **gear icon** → **Download Location** | Internal storage |
| **Background downloads (iOS)** — a download keeps transferring after you leave the app, instead of stalling the moment it's backgrounded. Doesn't survive a full force-quit. | — | Always on |

### Tracking

| Feature | Where | Default |
|---|---|---|
| **AniList** — connect your AniList account to sync anime watch progress, watched episodes, list status (Watching, Planning, Completed, Paused, Dropped, Rewatching) and scores. AniList can also be the source for Continue Watching and the Library. Titles are matched to AniList through IMDb, MAL, Kitsu and AniDB IDs. Connected per profile. | Settings → Tracking → **AniList** → **Connect AniList** | Not connected |
| **WeTrakr** — connect your WeTrakr account to sync lists, watch history, ratings, scrobbles and Continue Watching. WeTrakr can also be the source for the Library (Planning, Watching, Waiting, Watched, Paused, Dropped). | Settings → Tracking → **WeTrakr** → **Connect WeTrakr** | Not connected |
| **PublicMetaDB** — connect with your own PublicMetaDB API key to sync scrobbles, ratings, personal lists and watched history. PublicMetaDB can also be the source for the Library. | Settings → Tracking → **PublicMetaDB** | Not connected |
| **Sign in with a code** — device-code sign-in for **Trakt** and **SIMKL**, for when the browser redirect will not come back, especially for installation within LiveContainer. Shows a code to enter on any other device. | Settings → Tracking → provider card → **Connect with code** | — |

### Navigation & settings

| Feature | Where | Default |
|---|---|---|
| **Floating nav bar on iPad and tablets** — the jelly floating pill, with inline labels on tablets. | Settings → Layout → navigation bar style | — |
| **Blurred bottom sheets** *(Android)* — bottom sheets blur the screen behind them, as on iOS. | — | Always on |
| **Nav bar at the top** — move the floating nav bar to the top of the screen. | Settings → Layout → navigation bar → **Position** | Bottom |
| **DNS over HTTPS** — pick an encrypted DNS provider for all of Nuvio's connections (addons, metadata, images, sync, trackers and the ExoPlayer engine). The rest of the device keeps its own DNS. libmpv and web sign-in pages still use the system DNS. | Settings → Advanced → **DNS** | System default |
| **Discord Rich Presence** — show what you're watching on your Discord profile, on Android and iOS. | Settings → Integrations → **Discord** | Off |

### iOS look and feel

| Feature | Where | Default |
|---|---|---|
| **Morphed Liquid Glass tab bar** — shrinks to a compact pill, with native drag-across-tabs and the system glass highlight (requires an **iPhone on iOS 26 or newer**). | Settings → Layout → **Liquid Glass tab bar** | Morphed |
| **Skia graphics engine** — rebuild graphics engine for animated artwork rendering with shared codecs and bounded memory. Fixed crash on large animated collection, support animated avatar and badge | — | — |
| **Bundle CJK Font** — fixed Chinese subtitle rendering | — | — |
| **Subtitles in Picture in Picture** — text subtitles keep showing in Picture in Picture and the mini player. | — | Always on |
| **Dolby Vision in Picture in Picture** — Dolby Vision Profile 5 videos keep their colours in Picture in Picture instead of turning purple and green. | — | Always on |

### Performance

- **Faster startup** *(Android)* — saved data is loaded in the background while the splash screen is up.
- **Instant home** — the last home screen is saved per profile and shown on the next launch while fresh rows load.
- **Lighter Live TV** — channels load only when you open Live TV, sources download in parallel, and the guide is cached for up to 6 hours.
- **Smoother artwork colours** — dynamic background and details-page colours appear without a dark first frame and blend straight from one hero to the next.
- **Faster details** — movie and show details open sooner.
- **Smoother scrolling** — home, shelves and grids scroll with fewer dropped frames.
- **Lower memory on iPhone** — long sessions and 4K HDR / Dolby Vision playback use less memory, so iOS is less likely to close the app.
- **Libass rendering off the main thread** *(Android, ExoPlayer)* — ASS/SSA subtitles render on their own thread for less stutter with heavy styled subtitles.

---

### 🎯 Out-of-the-Box Tracking Accounts

All major tracking platforms are pre-configured with verified credentials so you can link your account instantly without "Missing credentials" errors:

| Tracker | Authentication & Sync Capabilities | Verification Link |
|---|---|---|
| **Trakt.tv** | Full watch progress, continuous watching sync, scrobbling, and personal lists. Supports both Quick Device Code and Browser OAuth. | `https://auth.trakt.tv/activate` |
| **SIMKL** | Complete watch history and watchlist synchronization for Anime, TV Series, and Movies via fast PIN authorization. | `https://simkl.com/pin` |
| **MDBList** | Direct Device Code authorization to sync your custom MDBList collections, personal lists, and watch progress. | `https://mdblist.com/oauth/device/` |
| **AniList** | Native anime tracking, episode progress, list statuses (Watching, Planning, Completed, etc.), and score syncing. | Settings → Tracking → AniList |
| **WeTrakr** | Deep synchronization for continue watching, watch history, lists, and ratings. | Settings → Tracking → WeTrakr |
| **IntroDB Skipping** | Automated intro and outro skipping for supported anime and television series. | Automated during playback |

---

### 🎬 Ultimate Video Player & Audio

| Feature | Description | Where | Default |
|---|---|---|---|
| **Digital Volume Boost (Up to 200%)** | Hardware-accelerated Loudness Enhancer for ExoPlayer and digital boost for MPV with a distinct amber indicator. | Swipe up past 100% on right side | Always on |
| **Fast Seekbar Thumbnails** | Scrubbing preview frames decoded with high performance using a native Rust decoder. | Settings → Playback → **Seek Bar Thumbnails** | On |
| **Tap-to-Seek & Scrubbing** | Tap anywhere on the progress bar to jump directly, with live buffered range indication. | Player screen overlay | Always on |
| **Swipe to Seek Toggle** | Prevent accidental timeline scrubbing during touch gestures while preserving volume and brightness controls. | Settings → Playback → **Swipe to Seek** | On |
| **Stream Quality Selector** | Dynamic HLS stream quality picker with resolution badges on both legacy and modern layouts. | Player screen overlay | Best available |
| **Playback Info Inspector** | Real-time technical readout showing video resolution, audio codec, bitrate, and container info. | Player screen overlay → **Info** | — |
| **Subtitle Sync by Ear** | Tap "Heard" when spoken and "Saw" when shown to automatically calculate and apply the subtitle offset. | Subtitles panel → **Sync by ear** | — |
| **Picture-in-Picture & Mini Player** | Smooth PiP window switching or in-app floating mini player for multitasking. | Player header / Settings → Playback | On |
| **Private Viewing Mode** | Play any title without recording watch progress or scrobbling to connected trackers. | Settings → Playback → **Private Viewing** | Off |
| **Custom Playback Buffers** | Configure min, max, start, and stall buffer limits to prevent buffering on slower connections. | Settings → Playback → **Custom Playback Buffers** | Optimized |

---

### 📺 Live TV (IPTV)

Upstream Nuvio lacks Live TV support. Nuvio Enhanced integrates an entire IPTV suite:

| Feature | Where | Status |
|---|---|---|
| **M3U / M3U8 Playlists** | Settings → Integrations → Live TV → **Playlists** | Fully supported |
| **Xtream Codes API** | Settings → Integrations → Live TV → **Providers** → Xtream | Server, user & password |
| **Stalker Portal** | Settings → Integrations → Live TV → **Providers** → Stalker Portal | Portal URL & MAC |
| **TV Guide (EPG)** | Settings → Integrations → Live TV → **TV Guide (EPG)** | Auto-detected & custom XMLTV |
| **Navigation Tab** | Automatically appears in navigation when at least one playlist or provider is configured. | Dynamic |

---

### 🎨 Personalization & Visual Polish

- **Custom HSV Theme Picker:** Full custom color picker with Saturation/Value palette and Hue slider to style the entire app to your exact preference.
- **Hero Trailer Autoplay:** Stream high-definition trailers right in the hero carousel with customizable delay, sound defaults, and aspect-ratio letterbox zoom.
- **Dynamic Artwork Backgrounds:** Atmospheric gradient blending matching the active movie or show artwork.
- **Biometric Security:** Unlock PIN-locked profiles with fingerprint or Face ID for local privacy.
- **Episode Navigator:** Sticky series search bar to filter by episode title, plot, season, or rating.
- **In-App Ratings (1–10 Stars):** Rate media directly on detail pages and sync scores back to your connected trackers.

---

## ✨ What NuvioMobile-Enhanced+ Adds on Top

These are the custom changes in this repository, beyond the sections above:

### 📖 Nuvio Read & Rating Map
- **Nuvio Read toggle:** Show or hide the Nuvio Read overview card from Settings → Nuvio Enhanced.
- **Rating Map arrow in Nuvio Read:** Tap the arrow in Nuvio Read to open the Rating Map, so ratings are easy to view. The standalone Rating Map section stays hidden while Nuvio Read is on.

### 🎮 Player Buttons Layout
- **Customisable bottom-left pill (default player):** Settings → Playback → Player, shown only when Legacy layout is OFF. 20 buttons (including Watch Party, PiP, Shuffle, Orientation and Cast) can be placed on the bar or behind the arrow, with Reset to Default. Buttons hidden via the Nuvio Enhanced hide toggles stay hidden in both groups, but keep their saved position so they return when the toggle is turned back on.
- **Volume above 100% in red:** The boosted-volume indicator shows in red instead of orange, in both the default side bar and the legacy volume pill.
- **Lock icon shows its state:** A closed lock when locked and an open lock when unlocked, in the default top toolbar, the legacy top header and the centre locked overlay.
- **No duplicate Watch Party:** The legacy bottom-bar Watch Party option was removed; only the top PlayerHeader Watch Party remains.

### 🛠️ Nuvio Enhanced Diagnostics
- **Enhanced Diagnostics section:** Restored in Nuvio Enhanced settings, including Copy current diagnostics and Copy last crash report (backed by a global crash handler). The Sentry option was removed, since it gave no benefit in GitHub-built APKs (blank DSN).

### ⬆️ Upstream Additions Included From Luqman's Enhanced Branch
This fork is built on Luqman's enhanced branch, so it also includes his newer work that was merged in with this fork:
- **Player Chapters:** Matroska chapter loading, a chapters panel and chapter navigation in the player.
- **PublicMetaDb tracking:** PublicMetaDB as a tracking brand, library source and watch-progress source, alongside Trakt, SIMKL, MDBList, AniList and WeTrakr.

---

## 🛠️ Build from Source

### Android Build (GitHub Actions, as used by this repository)
This repository's only workflow is `build-apk.yml` (manual dispatch), which builds the release APK and publishes it to the v0.6.5 release. To build locally instead, use Android Studio, JDK 17, and Cargo (for native seekbar Rust components):
```bash
# Add Rust Android targets (one-time setup):
rustup target add aarch64-linux-android armv7-linux-androideabi i686-linux-android x86_64-linux-android
cargo install cargo-ndk --locked

# Assemble Release APK:
./gradlew :androidApp:assembleFullRelease
```

### iOS Build
Requires macOS, Xcode, and CocoaPods:
```bash
env NUVIO_IOS_DISTRIBUTION=full xcodebuild \
  -project iosApp/iosApp.xcodeproj \
  -scheme iosApp \
  -configuration Release \
  -sdk iphoneos \
  -derivedDataPath build/ios-derived-full \
  CODE_SIGNING_ALLOWED=NO \
  build
```

---

## Credits

Nuvio is built by [NuvioMedia](https://github.com/NuvioMedia) — all credit for the app itself belongs to them and its
contributors. This repository only adds to their work. If you enjoy Nuvio, [support the upstream project](https://nuvio.tv/support).

This fork is based on [Luqman](https://github.com/luqmanfadlli)'s enhanced branch of NuvioMobile-Enhanced, with the custom work ported from [techforfriend/Nuvio-enhanced-2](https://github.com/techforfriend/Nuvio-enhanced-2).

## License

[GNU General Public License v3.0](./LICENSE) — same as upstream.
