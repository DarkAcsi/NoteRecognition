package com.example.noterecognition.screens.nataly.run

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.databinding.NFragmentRunBinding

class FragmentRun : BaseFragment(R.layout.n_fragment_run) {

    private lateinit var binding: NFragmentRunBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelRun>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NFragmentRunBinding.bind(view)

    }

}