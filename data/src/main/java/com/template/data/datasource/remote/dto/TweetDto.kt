package com.template.data.datasource.remote.dto

import com.google.gson.annotations.SerializedName

/****
 * Keep all the AUTH related DTOs here

 *****/
sealed class TweetDto {

    data class MultipleTweetPayload(
        @SerializedName("data") val data: List<TweetData>? = null,
        @SerializedName("includes") val includes: Includes? = null,
        @SerializedName("meta") val meta: Meta? = null
    ) : TweetDto()

    data class TweetData(
        /**
         * Specifies the type of attachments (if any) present in this Tweet.
         */
        @SerializedName("attachments") val attachments: Attachments? = null,
        /**
         * The unique identifier of the User who posted this Tweet.
         */
        @SerializedName("author_id") val author_id: String? = null,

        @SerializedName("created_at")  val created_at: String? = null,

        /**
         * The unique identifier of the requested Tweet.
         */
        @SerializedName("id")  val id: String,
        /**
         * If the represented Tweet is a reply, this field will contain the original Tweet’s author ID.
         * This will not necessarily always be the user directly mentioned in the Tweet.
         */
        @SerializedName("in_reply_to_user_id") val in_reply_to_user_id: String? = null,
        /**
         * Language of the Tweet, if detected by Twitter. Returned as a BCP47 language tag.
         */
        @SerializedName("lang")  val lang: String? = null,
        /**
         * This field only surfaces when a Tweet contains a link. The meaning of the field doesn’t pertain to the Tweet
         * content itself, but instead it is an indicator that the URL contained in the Tweet may contain content or media
         * identified as sensitive content.
         */
        @SerializedName("possibly_sensitive")  val possibly_sensitive: Boolean? = null,
        /**
         * Public engagement metrics for the Tweet at the time of the request.
         */
        @SerializedName("public_metrics")  val public_metrics: PublicMetrics? = null,
        /**
         * A list of Tweets this Tweet refers to. For example, if the parent Tweet is a Retweet, a Retweet with comment
         * (also known as Quoted Tweet) or a Reply, it will include the related Tweet referenced to by its parent.
         */
        @SerializedName("referenced_tweets")  val referenced_tweets: List<ReferencedTweet>? = null,
        /**
         * The name of the app the user Tweeted from.
         */
        @SerializedName("source") val source: String? = null,
        /**
         * The actual UTF-8 text of the Tweet. See twitter-text for details on what characters are currently considered valid.
         */
        @SerializedName("text")  val text: String,
        /**
         * Contains details about the location tagged by the user in this Tweet, if they specified one.
         */
        @SerializedName("geo")  val geo: Geo? = null,

        ) : TweetDto()

    data class Includes(
        @SerializedName("tweets") val tweets: List<TweetData>? = null,
        @SerializedName("users") val users:List<User>? = null,
        @SerializedName("places") val places: List<Place>? = null,
        @SerializedName("media") val media: List<Media>? = null,
        @SerializedName("polls") val polls: List<Poll>? = null
    ) : TweetDto()

    data class Meta(
        @SerializedName("sent") val sent: String? = null,
        @SerializedName("summary") val summary: Summary? = null,
        @SerializedName("newest_id") val newest_id: Long? = null,
        @SerializedName("oldest_id") val oldest_id: Long? = null,
        @SerializedName("result_count") val result_count: Int? = null,
        @SerializedName("next_token") val next_token: String? = null
    ) : TweetDto()

    data class Summary(
        @SerializedName("created") val created: Int? = null,
        @SerializedName("invalid")val invalid: Int? = null,
        @SerializedName("not_created") val not_created: Int? = null,
        @SerializedName("valid") val valid: Int? = null
    ) : TweetDto()

    data class User(
        /**
         * The UTC datetime that the user account was created on Twitter.
         */
        @SerializedName("created_at") val created_at: String? = null,
        /**
         * The text of this user's profile description (also known as bio), if the user provided one.
         */
        @SerializedName("description") val description: String? = null,

        /**
         * The unique identifier of this user.
         */
        @SerializedName("id") val id: String,
        /**
         * The location specified in the user's profile, if the user provided one. As this is a freeform value,
         * it may not indicate a valid location, but it may be fuzzily evaluated when performing searches with location queries.
         */
        @SerializedName("location") val location: String? = null,
        /**
         * The name of the user, as they’ve defined it on their profile. Not necessarily a person’s name. Typically capped
         * at 50 characters, but subject to change.
         */
        @SerializedName("name")  val name: String,
        /**
         * Unique identifier of this user's pinned Tweet.
         */
        @SerializedName("pinned_tweet_id") val pinned_tweet_id: String? = null,
        /**
         * The URL to the profile image for this user, as shown on the user's profile.
         */
        @SerializedName("profile_image_url") val profile_image_url: String? = null,
        /**
         * Indicates if this user has chosen to protect their Tweets (in other words, if this user's Tweets are private).
         */
        @SerializedName("protected") val protected: Boolean? = null,
        /**
         * The URL specified in the user's profile, if present.
         */
        @SerializedName("url")val url: String? = null,
        /**
         * The Twitter screen name, handle, or alias that this user identifies themselves with. Usernames are unique but
         * subject to change. Typically a maximum of 15 characters long, but some historical accounts may exist with longer names.
         */
        @SerializedName("username")   val username: String,
        /**
         * Indicates if this user is a verified Twitter User.
         */
        @SerializedName("verified") val verified: Boolean? = null,
        /**
         * Contains details about activity for this user.
         */
        @SerializedName("public_metrics") val public_metrics: PublicMetrics? = null
    ) : TweetDto()

    data class Place(
        /**
         * The full-length name of the country this place belongs to.
         */
        @SerializedName("country")  val country: String? = null,
        /**
         * The ISO Alpha-2 country code this place belongs to.
         */
        @SerializedName("country_code")val country_code: String? = null,
        /**
         * A longer-form detailed place name.
         */
        @SerializedName("full_name") val full_name: String,
        /**
         * Contains place details in GeoJSON format.
         */
        @SerializedName("geo") val geo: PlaceGeoData? = null,
        /**
         * The unique identifier of the expanded place, if this is a point of interest tagged in the Tweet.
         */
        @SerializedName("id") val id: String,
        /**
         * The short name of this place.
         */
        @SerializedName("name") val name: String? = null,
        /**
         * Specified the particular type of information represented by this place information, such as a city name, or a point of interest.
         */
        @SerializedName("place_type") val place_type: String? = null
    ) : TweetDto()

    data class Media(
        /**
         * Available when type is video. Duration in milliseconds of the video.
         */
        @SerializedName("duration_ms") val duration_ms: Int? = null,
        /**
         * Height of this content in pixels.
         */
        @SerializedName("height") val height: Int? = null,
        /**
         * Unique identifier of the expanded media content.
         */
        @SerializedName("media_key") val media_key: String,
        /**
         * URL to the static placeholder preview of this content.
         */
        @SerializedName("preview_image_url") val preview_image_url: String? = null,
        /**
         * Public engagement metrics for the media content at the time of the request.
         */
        @SerializedName("public_metrics") val public_metrics: PublicMetrics? = null,
        /**
         * Type of content (animated_gif, photo, video).
         */
        @SerializedName("type") val type: String,
        /**
         * Width of this content in pixels.
         */
        @SerializedName("width") val width: Int? = null,
        /**
         * Url of a photo image uploaded
         */
        @SerializedName("url") val url: String? = null,

        ) : TweetDto()

    data class Poll(
        /**
         * Specifies the total duration of this poll.
         */
        @SerializedName("duration_minutes")val duration_minutes: Int? = null,
        /**
         * Specifies the end date and time for this poll.
         */
        @SerializedName("end_datetime") val end_datetime: String? = null,
        /**
         * Unique identifier of the expanded poll.
         */
        @SerializedName("id")  val id: String,
        /**
         * Contains objects describing each choice in the referenced poll.
         */
        @SerializedName("options")val options: List<Option>,
        /**
         * Indicates if this poll is still active and can receive votes, or if the voting is now closed.
         */
        @SerializedName("voting_status")  val voting_status: String? = null
    ) : TweetDto()

    data class PlaceGeoData(
        @SerializedName("bbox") val bbox: List<Double>? = null,
        @SerializedName("type")val type: String? = null
    ) : TweetDto()

    data class Option(
        @SerializedName("label") val label: String? = null,
        @SerializedName("position") val position: Int? = null,
        @SerializedName("votes") val votes: Int? = null
    ) : TweetDto()

    data class Geo(
        @SerializedName("coordinates") val coordinates: Coordinates? = null,
        @SerializedName("place_id") val place_id: String?
    ) : TweetDto()

    data class Coordinates(
        @SerializedName("coordinates")val coordinates: List<Double>? = null,
        @SerializedName("type") val type: String? = null
    ) : TweetDto()

    data class Attachments(
        @SerializedName("media_keys") val media_keys: List<String>? = null,
        @SerializedName("poll_ids") val poll_ids: List<String>? = null
    ) : TweetDto()

    data class PublicMetrics(
        @SerializedName("like_count") val like_count: Int? = null,
        @SerializedName("quote_count") val quote_count: Int? = null,
        @SerializedName("reply_count") val reply_count: Int? = null,
        @SerializedName("retweet_count") val retweet_count: Int? = null
    ) : TweetDto()

    data class ReferencedTweet(
        @SerializedName("id") val id: String,
        @SerializedName("type")  val type: String? = null
    ) : TweetDto()


   
}