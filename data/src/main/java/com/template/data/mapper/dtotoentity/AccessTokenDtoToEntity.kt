package com.template.data.mapper.dtotoentity

import com.template.data.datasource.remote.dto.AccessTokenDto
import com.template.data.datasource.remote.dto.TweetDto
import com.template.domain.entity.response.auth.AccessTokenEntity
import com.template.domain.entity.response.tweet.TweetEntity

fun AccessTokenDto.AccessToken.map() = AccessTokenEntity.AccessToken(
    token_type = token_type,
    access_token = access_token,

)

