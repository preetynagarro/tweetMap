package com.template.tweet_list.view.fragment.tweetList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.template.core.common.Constants
import com.template.core.viewmodel.base.BaseViewModel
import com.template.domain.common.AppSession
import com.template.domain.common.ResultState
import com.template.domain.entity.request.AccessTokenRequest
import com.template.domain.entity.response.auth.AccessTokenEntity
import com.template.domain.entity.response.tweet.TweetEntity
import com.template.domain.usecases.tweet.TweetUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TweetViewModel constructor(
    private val tweetUseCase: TweetUseCase
) : BaseViewModel() {
    val data = MutableLiveData(false)
    val tweetList = MutableLiveData<TweetEntity.MultipleTweetPayload>()
    val accessToken = MutableLiveData<AccessTokenEntity.AccessToken>()


    fun searchTweet() {
        when {
            AppSession.getAccessToken() != null -> loadTweet()
            else -> getAccessToken()
        }
    }

    private fun loadTweet() {
        showLoading(true)
        viewModelScope.launch {
            tweetUseCase.filteredTweet()
                .collect { state ->
                    when (state) {
                        is ResultState.Success -> {
                            tweetList.value = state.data
                            data.value = true
                            showLoading(false)

                        }

                        is ResultState.Error -> {
                            setError(error = state.error)
                            showLoading(false)
                        }
                    }

                }

        }
    }

    fun getAccessToken() {
        showLoading(true)
        viewModelScope.launch {
            tweetUseCase.accessToken(AccessTokenRequest.tokenRequest(Constants.GRANT_TYPE))
                .collect { state ->
                    when (state) {
                        is ResultState.Success -> {
                            accessToken.value = state.data
                            data.value = true
                            showLoading(false)

                        }

                        is ResultState.Error -> {
                            setError(error = state.error)
                            showLoading(false)
                        }
                    }

                }

        }
    }
}