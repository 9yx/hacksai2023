package ru.runx.lempact.dto.yt

/**
 * Paging details for lists of resources, including total number of items available and number of resources returned in a single page.
 */
data class PageInfo(
    /**
     * The number of results included in the API response. The value may be null
     */
    val resultsPerPage: Int? = null,
    /**
     * The total number of results in the result set. The value may be null.
     */
    val totalResults: Int? = null
)
