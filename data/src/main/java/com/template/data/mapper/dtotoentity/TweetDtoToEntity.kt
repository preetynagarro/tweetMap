package com.template.data.mapper.dtotoentity

import com.template.data.datasource.remote.dto.TweetDto
import com.template.domain.entity.response.tweet.TweetEntity

fun TweetDto.TweetData.map() = TweetEntity.TweetData(
    id = id,
    lang = lang,
    text = text
)

fun TweetDto.Includes.map() = TweetEntity.Includes(
    tweets = tweets?.map()
)

fun TweetDto.MultipleTweetPayload.map()  = TweetEntity.MultipleTweetPayload(
    data = data?.map(),
    includes = includes?.map()

)
fun List<TweetDto.TweetData>.map(): List<TweetEntity.TweetData> {
    val list: ArrayList<TweetEntity.TweetData> = arrayListOf()
    forEach { tweet ->
        list.add(tweet.map())
    }
    return list
}

