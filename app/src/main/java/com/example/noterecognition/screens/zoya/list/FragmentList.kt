package com.example.noterecognition.screens.zoya.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.databinding.ZFragmentListBinding
import com.example.noterecognition.navigator

class FragmentList : BaseFragment(R.layout.z_fragment_list) {

    private lateinit var binding: ZFragmentListBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelList>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = ZFragmentListBinding.bind(view)

        binding.btnNext.setOnClickListener {
            val direction =
                FragmentListDirections.actionFragmentListToFragmentProject()
            navigator().navigateTo(direction)
        }
        binding.btnBack.setOnClickListener { navigator().navigateUp() }

    }

}