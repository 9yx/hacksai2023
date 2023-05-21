package ru.runx.lempact.dto.yt

/**
 * The conversionPings object encapsulates information about conversion pings that need to be respected by the channel.
 */
data class ChannelConversionPings(
    /**
     * Pings that the app shall fire (authenticated by biscotti cookie). Each ping has a context, in
     * which the app must fire the ping, and a url identifying the ping.
     * The value may be `null`.
     */
    val pings: List<ChannelConversionPing>? = null
)
