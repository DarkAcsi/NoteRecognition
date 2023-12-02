package com.example.noterecognition.screens.zoya.project

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.databinding.ZFragmentProjectBinding
import com.example.noterecognition.navigator

class FragmentProject : BaseFragment(R.layout.z_fragment_project) {

    private lateinit var binding: ZFragmentProjectBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelProject>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ZFragmentProjectBinding.bind(view)

        binding.btnBack.setOnClickListener { navigator().navigateUp() }
        binding.btnNext.setOnClickListener { toFourCourse() }
        binding.btnNext2.setOnClickListener { toRecognitions() }
        binding.btnNext3.setOnClickListener { toView() }
        binding.btnNext4.setOnClickListener { toPhoto() }
        binding.btnNext5.setOnClickListener { toOptionRun() }

    }

    private fun toFourCourse() {
        val direction =
            FragmentProjectDirections.actionFragmentProjectToFragmentFourCourse()
        navigator().navigateTo(direction)
    }

    private fun toRecognitions() {
        val direction =
            FragmentProjectDirections.actionFragmentProjectToFragmentRecognitions()
        navigator().navigateTo(direction)
    }

    private fun toView() {
        val direction =
            FragmentProjectDirections.actionFragmentProjectToFragmentView()
        navigator().navigateTo(direction)
    }

    private fun toPhoto() {
        val direction =
            FragmentProjectDirections.actionFragmentProjectToFragmentPhoto()
        navigator().navigateTo(direction)
    }

    private fun toOptionRun() {
        val direction =
            FragmentProjectDirections.actionFragmentProjectToFragmentOptionRun()
        navigator().navigateTo(direction)
    }

}