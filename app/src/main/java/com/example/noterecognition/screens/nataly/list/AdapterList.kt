package com.example.noterecognition.screens.nataly.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.noterecognition.R
import com.example.noterecognition.database.classes.CProject
import com.example.noterecognition.databinding.ItemProjectContainerBinding


interface ActionListenerList {

    // basic mode
    fun onListOpen(project: CProject)

    fun onListSelectingMode(project: CProject) // long click

    fun onListDownload(project: CProject)

    // modify mode
    fun onListMove(fromPosition: Int, toPosition: Int)

    fun onListCheck(project: CProject)

}

class AdapterList(private val actionListener: ActionListenerList) :
    RecyclerView.Adapter<AdapterList.ViewHolderList>(),
    View.OnClickListener, View.OnLongClickListener {

    init {
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return list[position].hashCode().toLong()
    }

    fun onItemMove(fromPosition: Int, toPosition: Int) {
        actionListener.onListMove(fromPosition, toPosition)
    }

    private var basicMode: Boolean = true

    var list: List<CProject> = emptyList()
        set(newValue) {
            val diffCallback = DiffCallbackList(field, newValue)
            val diffResult = DiffUtil.calculateDiff(diffCallback)
            field = newValue
            diffResult.dispatchUpdatesTo(this)
        }


    override fun getItemCount(): Int = list.size

    class ViewHolderList(
        val binding: ItemProjectContainerBinding
    ) : RecyclerView.ViewHolder(binding.root)

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderList {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemProjectContainerBinding.inflate(inflater, parent, false)

        binding.clProjectBasic.root.setOnLongClickListener(this)
        binding.clProjectBasic.tvNameProjectBasic.setOnLongClickListener(this)
        binding.clProjectBasic.root.setOnClickListener(this)
        binding.clProjectBasic.tvNameProjectBasic.setOnClickListener(this)
        binding.clProjectBasic.ivDownloadProject.setOnClickListener(this)

        binding.clProjectModify.root.setOnClickListener(this)
        binding.clProjectModify.tvNameProjectModify.setOnClickListener(this)
        binding.clProjectModify.ivCheckProject.setOnClickListener(this)

        return ViewHolderList(binding)
    }

    override fun onBindViewHolder(holder: ViewHolderList, position: Int) {
        val project = list[position]
        with(holder.binding) {
            when (basicMode) {
                true -> {
                    clProjectBasic.root.tag = project
                    clProjectBasic.tvNameProjectBasic.tag = project
                    clProjectBasic.ivDownloadProject.tag = project
                    clProjectBasic.tvNameProjectBasic.text = project.name
                }
                false -> {
                    clProjectModify.root.tag = project
                    clProjectModify.tvNameProjectModify.tag = project
                    clProjectModify.ivCheckProject.tag = project
                    clProjectModify.ivMoveProject.tag = project
                    clProjectModify.tvNameProjectModify.text = project.name
                    clProjectModify.ivCheckProject.setImageResource(when(project.checked) {
                        true -> R.drawable.checkbox_on
                        false -> R.drawable.checkbox_off
                    })
                }
            }
            itemVisibility(holder)
        }
    }

    private fun itemVisibility(holder: ViewHolderList) {
        with(holder.binding) {
            clProjectBasic.root.visibility = View.GONE
            clProjectModify.root.visibility = View.GONE
            when (basicMode) {
                true -> clProjectBasic.root.visibility = View.VISIBLE
                false -> clProjectModify.root.visibility = View.VISIBLE
            }
        }
    }

    override fun onClick(v: View?) {
        val project = v?.tag as CProject
        when(v.id){
            R.id.clProjectBasic, R.id.tvNameProjectBasic -> {
                actionListener.onListOpen(project)
            }
            R.id.ivDownloadProject -> {
                actionListener.onListDownload(project)
            }
            R.id.clProjectModify, R.id.tvNameProjectModify, R.id.ivCheckProject -> {
                actionListener.onListCheck(project)
            }
        }
    }

    override fun onLongClick(v: View?): Boolean {
        val project = v?.tag as CProject
        actionListener.onListSelectingMode(project)
        return false
    }
}

class ItemTouchList(private val adapter: AdapterList) : ItemTouchHelper.Callback() {
    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags = ItemTouchHelper.START or ItemTouchHelper.END
        val swipeFlags = 0
        return makeMovementFlags(dragFlags, swipeFlags)
    }

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        adapter.onItemMove(viewHolder.adapterPosition, target.adapterPosition)
        return true
    }

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {}

}

private class DiffCallbackList(
    private val oldList: List<CProject>,
    private val newList: List<CProject>
) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].id == newList[newItemPosition].id
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }
}