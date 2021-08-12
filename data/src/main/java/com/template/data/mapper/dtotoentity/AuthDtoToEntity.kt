package com.template.data.mapper.dtotoentity

import com.google.gson.annotations.SerializedName
import com.template.data.datasource.remote.dto.AuthDto
import com.template.domain.entity.response.auth.AuthEntity

fun AuthDto.TweetData.map() = AuthEntity.TweetData(
    id = id,
    lang = lang,
    text = text
)

fun AuthDto.Includes.map() = AuthEntity.Includes(
    tweets = tweets?.map()
//    places = places?.map()
)

fun AuthDto.MultipleTweetPayload.map()  = AuthEntity.MultipleTweetPayload(
    data = data?.map(),
    includes = includes?.map()

)
fun List<AuthDto.TweetData>.map(): List<AuthEntity.TweetData> {
    val list: ArrayList<AuthEntity.TweetData> = arrayListOf()
    forEach { tweet ->
        list.add(tweet.map())
    }
    return list
}
/*
fun List<AuthDto.Place>.map(): List<AuthEntity.Place> {
    val list: ArrayList<AuthEntity.Place> = arrayListOf()
    forEach { place ->
        list.add(place.map())
    }
    return list
} */
