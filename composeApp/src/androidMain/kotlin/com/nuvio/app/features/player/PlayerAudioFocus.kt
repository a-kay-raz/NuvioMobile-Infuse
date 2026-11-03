package com.nuvio.app.features.player

import android.content.Context
import android.media.AudioManager
import androidx.annotation.OptIn
import androidx.media3.common.AudioAttributes
import androidx.media3.common.C
import androidx.media3.common.audio.AudioFocusRequestCompat
import androidx.media3.common.audio.AudioManagerCompat
import androidx.media3.common.util.UnstableApi

internal val playbackAudioAttributes: AudioAttributes = AudioAttributes.Builder()
    .setUsage(C.USAGE_MEDIA)
    .setContentType(C.AUDIO_CONTENT_TYPE_MOVIE)
    .build()

@OptIn(UnstableApi::class)
internal class PlayerAudioFocus(
    context: Context,
    onLoss: () -> Unit,
    // Previously loss paused playback with no resume path, so a transient
    // loss (notification/call) left Libmpv paused forever until manual play.
    onGain: () -> Unit = {},
) {
    private val audioManager = AudioManagerCompat.getAudioManager(context)
    private val request = AudioFocusRequestCompat.Builder(AudioManagerCompat.AUDIOFOCUS_GAIN)
        .setAudioAttributes(playbackAudioAttributes)
        .setOnAudioFocusChangeListener { focusChange ->
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS || focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                onLoss()
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                onGain()
            }
        }
        .build()

    fun request() {
        AudioManagerCompat.requestAudioFocus(audioManager, request)
    }

    fun abandon() {
        AudioManagerCompat.abandonAudioFocusRequest(audioManager, request)
    }
}
