package ru.skillbranch.sbdelivery.utils.livedata

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Created by Anna Shabaeva on 19.06.2020
 */

val <T>MutableLiveData<T>.asLiveData : LiveData<T> get() = this