package ru.runx.lempact.dto.yt

/**
 * Pings that the app shall fire (authenticated by biscotti cookie). Each ping has a context,
 * in which the app must fire the ping, and a url identifying the ping.
 */
data class ChannelConversionPing(
    /**
     * Defines the context of the ping.
     * The value may be `null`.
     */
    val context: String? = null,

    /**
     * The url (without the schema) that the player shall send the ping to. It's at caller's
     * descretion to decide which schema to use (http vs https) Example of a returned url:
     * //googleads.g.doubleclick.net/pagead/
     * viewthroughconversion/962985656/?data=path%3DtHe_path%3Btype%3D
     * cview%3Butuid%3DGISQtTNGYqaYl4sKxoVvKA=default The caller must append biscotti authentication
     * (ms param in case of mobile, for example) to this ping.
     * The value may be `null`.
     */
    val conversionUrl: String? = null
)
