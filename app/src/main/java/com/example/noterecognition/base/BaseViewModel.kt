package com.example.noterecognition.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

typealias LiveResult<T> = LiveData<AppResult<T>>
typealias MutableLiveResult<T> = MutableLiveData<AppResult<T>>
typealias MediatorLiveResult<T> = MediatorLiveData<AppResult<T>>

abstract class BaseViewModel : ViewModel()