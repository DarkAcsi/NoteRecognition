package com.example.noterecognition.screens.fourCourse

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.databinding.FragmentFourCourseBinding
import com.example.noterecognition.navigator

class FragmentFourCourse : BaseFragment(R.layout._fragment_four_course) {

    private lateinit var binding: FragmentFourCourseBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelFourCourse>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFourCourseBinding.bind(view)

        binding.btnBack.setOnClickListener { navigator().navigateUp() }

    }

}