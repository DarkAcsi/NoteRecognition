package com.example.noterecognition.screens.nataly.view

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.databinding.NFragmentViewBinding
import com.example.noterecognition.navigator

class FragmentView : BaseFragment(R.layout.n_fragment_view) {

    private lateinit var binding: NFragmentViewBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelView>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NFragmentViewBinding.bind(view)

        binding.btnBack.setOnClickListener { navigator().navigateUp() }

    }

}