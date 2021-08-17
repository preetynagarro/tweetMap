package com.template.tweet_list.view.fragment.tweetList

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.template.core.viewmodel.base.BaseViewModel
import com.template.domain.common.ResultState
import com.template.domain.entity.response.tweet.TweetEntity
import com.template.domain.usecases.tweet.TweetUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TweetViewModel constructor(
    private val tweetUseCase: TweetUseCase
) : BaseViewModel() {
    private val data = MutableLiveData(false)
    val tweetList = MutableLiveData<TweetEntity.MultipleTweetPayload>()
    val searchTextData = ObservableField<String>()


    fun searchTweet() {
        if (!searchTextData.get().toString().isNullOrEmpty())
            loadTweet(searchTextData.get().toString())
    }

    private fun loadTweet(searchText: String) {
        showLoading(true)
        viewModelScope.launch {
            tweetUseCase.filteredTweet(searchText)
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

}