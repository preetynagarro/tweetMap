package com.template.domain.entity.response.auth

/****
 * Keep all the authentication use case related entities over here.
 * Entity model contains only the fields needed for UI

 *****/
sealed class AuthEntity {

    data class MultipleTweetPayload(
        val data: List<TweetData>? = null,
        val includes: Includes? = null
    ) : AuthEntity()

    data class TweetData(

        val id: String,
        val lang: String? = null,
        val text: String,
        val geo: Geo? = null,

        ) : AuthEntity()

    data class Includes(
        val tweets: List<TweetData>? = null,
        val places: List<Place>? = null,
    ) : AuthEntity()

    data class Place(
        val country: String? = null,
        val country_code: String? = null,
        val full_name: String,
        val geo: PlaceGeoData? = null,
        val id: String,
        val name: String? = null,
        val place_type: String? = null
    ) : AuthEntity()

    data class PlaceGeoData(
        val bbox: List<Double>? = null,
        val type: String? = null
    ) : AuthEntity()


    data class Geo(
        val coordinates: Coordinates? = null,
        val place_id: String?
    ) : AuthEntity()

    data class Coordinates(
        val coordinates: List<Double>? = null,
        val type: String? = null
    ) : AuthEntity()


}