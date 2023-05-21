package ru.runx.lempact.dto.yt

/**
 * Geographical coordinates of a point, in WGS84.
 */
data class GeoPoint(
    /**
     * Altitude above the reference ellipsoid, in meters.
     * The value may be `null`.
     */
    val altitude: Double? = null,
    /**
     * Latitude in degrees.
     * The value may be `null`.
     */
    val latitude: Double? = null,
    /**
     * Longitude in degrees.
     * The value may be `null`.
     */
    val longitude: Double? = null
)
