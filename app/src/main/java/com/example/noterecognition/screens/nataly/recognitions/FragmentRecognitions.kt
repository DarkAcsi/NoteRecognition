package com.example.noterecognition.screens.nataly.recognitions

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.databinding.NFragmentRecognitionsBinding
import com.example.noterecognition.navigator

class FragmentRecognitions : BaseFragment(R.layout.n_fragment_recognitions) {

    private lateinit var binding: NFragmentRecognitionsBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelRecognitions>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NFragmentRecognitionsBinding.bind(view)

        binding.btnBack.setOnClickListener { navigator().navigateUp() }

    }

}