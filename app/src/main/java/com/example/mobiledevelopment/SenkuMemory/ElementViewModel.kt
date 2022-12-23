package com.example.mobiledevelopment.SenkuMemory

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ElementViewModel: ViewModel() {

    val myLiveModel = MutableLiveData<ElementList>()

    init {
        myLiveModel.value = ElementList()
    }
}