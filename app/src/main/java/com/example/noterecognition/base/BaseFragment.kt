package com.example.noterecognition.base

import androidx.fragment.app.Fragment

abstract class BaseFragment(layoutId: Int) : Fragment(layoutId) {

    abstract val viewModel: BaseViewModel

}