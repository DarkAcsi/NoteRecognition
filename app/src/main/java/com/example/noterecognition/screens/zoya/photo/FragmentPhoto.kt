package com.example.noterecognition.screens.zoya.photo

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.databinding.ZFragmentPhotoBinding
import com.example.noterecognition.navigator
import com.example.noterecognition.screens.zoya.list.FragmentListDirections

class FragmentPhoto : BaseFragment(R.layout.z_fragment_photo) {

    private lateinit var binding: ZFragmentPhotoBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelPhoto>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ZFragmentPhotoBinding.bind(view)

        binding.btnBack.setOnClickListener { navigator().navigateUp() }
        binding.btnNext.setOnClickListener { toView() }

    }

    private fun toView() {
        val direction =
            FragmentPhotoDirections.actionFragmentPhotoToFragmentView()
        navigator().navigateTo(direction)
    }

}