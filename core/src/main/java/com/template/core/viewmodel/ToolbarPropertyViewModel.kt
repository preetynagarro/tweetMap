package com.template.core.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.template.core.arc.SingleLiveEvent

/****
 * Tool bar Property ViewModel

 *****/
class ToolbarPropertyViewModel : ViewModel() {

    val closeButtonAction: SingleLiveEvent<Boolean> = SingleLiveEvent()
    val backButtonAction: SingleLiveEvent<Boolean> = SingleLiveEvent()
}
