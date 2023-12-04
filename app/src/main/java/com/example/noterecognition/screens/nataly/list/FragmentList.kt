package com.example.noterecognition.screens.nataly.list

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.noterecognition.R
import com.example.noterecognition.base.BaseFragment
import com.example.noterecognition.base.BaseViewModel
import com.example.noterecognition.database.classes.CProject
import com.example.noterecognition.databinding.NFragmentListBinding
import com.example.noterecognition.navigator

class FragmentList : BaseFragment(R.layout.n_fragment_list) {

    private lateinit var binding: NFragmentListBinding

    override val viewModel: BaseViewModel by viewModels<ViewModelList>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = NFragmentListBinding.bind(view)

        with(binding) {
            tbListBasic.ivAccount.setOnClickListener { }
            tbListBasic.ivSetting.setOnClickListener { }
            ivAddProject.setOnClickListener { toProject() }

            tbListModify.ivCancel.setOnClickListener { changeModeList() }
            tbListModify.ivCheckAll.setOnClickListener { checkItemsList() }
            ivDeleteProject.setOnClickListener { deleteProjects() }
        }

    }

    private fun deleteProjects() {}

    private fun changeModeList() {}

    private fun checkItemsList() {}

    private fun toProject() {
        val direction =
            FragmentListDirections.actionFragmentListToFragmentProject()
        navigator().navigateTo(direction)
    }

}