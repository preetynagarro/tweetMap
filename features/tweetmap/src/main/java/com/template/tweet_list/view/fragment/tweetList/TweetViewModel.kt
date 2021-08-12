package com.template.tweet_list.view.fragment.tweetList

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.template.core.viewmodel.base.BaseViewModel
import com.template.domain.common.ResultState
import com.template.domain.entity.response.auth.TweetEntity
import com.template.domain.usecases.auth.TweetUseCase
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class TweetViewModel constructor(
    private val tweetUseCase: TweetUseCase
) : BaseViewModel() {
    val data = MutableLiveData(false)
    val tweetList = MutableLiveData<TweetEntity.MultipleTweetPayload>()

     fun searchTweet() {
        loadTweet()
    }

    private fun loadTweet() {
        showLoading(true)
        viewModelScope.launch {
            tweetUseCase.filteredTweet()
                .collect { state ->
                    when (state) {
                        is ResultState.Success -> {
                            tweetList.value =  state.data
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

/*
    private fun readTweetStream(_streamChannel : ByteChannel) {
        var concatString: String = ""

        do {
            val byteBufferSize = 1024
            val byteBuffer = ByteArray(byteBufferSize)
            val currentRead = _streamChannel!!.readAvailable(byteBuffer, 0, byteBufferSize)
            val s = String(byteBuffer)
            val delimitedTweets = s.split("\r\n").toMutableList()

            if (concatString.isNotBlank()) {
                concatString += delimitedTweets[0]
                delimitedTweets[0] = concatString
                concatString = ""
            }

            if (!delimitedTweets[delimitedTweets.lastIndex].endsWith("}]}")) {
                concatString = delimitedTweets[delimitedTweets.lastIndex]
                delimitedTweets.removeAt(delimitedTweets.lastIndex)
            }

            parseStreamResponseString(delimitedTweets).forEach { tweet ->
                emit(Response.Success(tweet))
            }
        } while (currentRead >= 0)


    }
*/

    /**
     * Parses a given list of json strings and deserializes them
     */
/*
    private fun parseStreamResponseString(response: List<String>): List<SingleTweetPayload> {

        val tweets: MutableList<SingleTweetPayload> = mutableListOf()
        val format = Json { ignoreUnknownKeys = true }
        response.forEach { tweetData ->
            if (tweetData.isNotEmpty()) {
                try {
                    val convertedPayload: SingleTweetPayload? =
                        format.decodeFromString<SingleTweetPayload>(tweetData)
                    convertedPayload?.let { tweetObject ->
                        tweets.add(tweetObject)
                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
        }

        return tweets
    }
*/
}