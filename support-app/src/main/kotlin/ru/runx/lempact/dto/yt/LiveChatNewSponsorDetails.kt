package ru.runx.lempact.dto.yt

/**
 * Model definition for LiveChatNewSponsorDetails
 */
data class LiveChatNewSponsorDetails(
    /**
     * If the viewer just had upgraded from a lower level. For viewers that were not members at the
     * time of purchase, this field is false.
     * The value may be `null`.
     */
    val isUpgrade: Boolean? = null,
    /**
     * The name of the Level that the viewer just had joined. The Level names are defined by the
     * YouTube channel offering the Membership. In some situations this field isn't filled.
     * The value may be `null`.
     */
    val memberLevelName: String? = null
)
