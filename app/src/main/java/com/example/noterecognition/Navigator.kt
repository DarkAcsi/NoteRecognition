package com.example.noterecognition

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavDirections

interface Navigator {

    fun navigateUp()

    fun navigateTo(direction: NavDirections)

    fun navigateTo(destination: Int, args: Bundle? = null)

    fun toast(message: String)

}

fun Fragment.navigator() = requireActivity() as Navigator