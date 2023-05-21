package ru.runx.lempact.dto.yt


/**
 * Details about the content of a channel
 */
data class ChannelContentDetails(
    /**
     * The value may be `null`.
     */
    val relatedPlaylists: RelatedPlaylists? = null
) {
    /**
     * Model definition for ChannelContentDetailsRelatedPlaylists.
     */
    data class RelatedPlaylists(
        /**
         * The ID of the playlist that contains the channel"s favorite videos. Use the
         * playlistItems.insert and playlistItems.delete to add or remove items from that list.
         * The value may be `null`.
         */
        val favorites: String? = null,
        /**
         * The ID of the playlist that contains the channel"s liked videos. Use the playlistItems.insert
         * and playlistItems.delete to add or remove items from that list.
         * The value may be `null`.
         */
        val likes: String? = null,
        /**
         * The ID of the playlist that contains the channel"s uploaded videos. Use the videos.insert
         * method to upload new videos and the videos.delete method to delete previously uploaded videos.
         * The value may be `null`.
         */
        val uploads: String? = null,
        /**
         * The ID of the playlist that contains the channel"s watch history. Use the playlistItems.insert
         * and playlistItems.delete to add or remove items from that list.
         * The value may be `null`.
         */
        val watchHistory: String? = null,
        /**
         * The ID of the playlist that contains the channel"s watch later playlist. Use the
         * playlistItems.insert and playlistItems.delete to add or remove items from that list.
         * The value may be `null`.
         */
        val watchLater: String? = null
    )
}
