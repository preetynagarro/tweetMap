package com.template.core.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.template.core.arc.SingleLiveEvent

/****
 * Tool bar Property ViewModel

 *****/
class ToolbarPropertyViewModel : ViewModel() {
    var showBack = MutableLiveData<Boolean>(true)
    var showClose = MutableLiveData<Boolean>(false)
    var toolbarTitle = MutableLiveData<String>()
    val closeButtonAction: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val backButtonAction: SingleLiveEvent<Boolean> = SingleLiveEvent()
}
