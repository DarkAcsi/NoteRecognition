package com.example.noterecognition.screens.nataly.optionRun

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.databinding.NFragmentOptionRunBinding

class FragmentOptionRun : BaseFragment(R.layout.n_fragment_option_run) {

    private lateinit var binding: NFragmentOptionRunBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelOptionRun>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NFragmentOptionRunBinding.bind(view)

    }

}