package com.leandroid.system.mygymroutines.ui.days.monday

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leandroid.system.mygymroutines.R
import com.leandroid.system.mygymroutines.databinding.ItemRoutineBinding
import com.leandroid.system.mygymroutines.model.RoutineModel
import kotlin.contracts.contract

class MondayAdapter : ListAdapter<RoutineModel, MondayAdapter.MondayViewHolder>(DiffCallBack) {

    companion object DiffCallBack : DiffUtil.ItemCallback<RoutineModel>(){
        override fun areItemsTheSame(oldItem: RoutineModel, newItem: RoutineModel): Boolean{
            return oldItem === newItem
        }
        override fun areContentsTheSame(oldItem: RoutineModel, newItem: RoutineModel): Boolean{
            return oldItem.id == newItem.id
        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MondayViewHolder {
        val binding = ItemRoutineBinding
            .inflate(LayoutInflater.from(parent.context))
        return MondayViewHolder(binding)
    }

    override fun onBindViewHolder(
        mondayViewHolder: MondayViewHolder,
        position: Int
    ) {
        val routine = getItem(position)
        mondayViewHolder.bind(routine)
    }

    inner class MondayViewHolder(private val binding: ItemRoutineBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(routine: RoutineModel) {
            with(binding) {
                tvRepetition.text = routine.repetitions.toString()
                tvSeries.text = routine.series.toString()
                tvExerciseTitle.text = routine.exercises.toString()
                Glide.with(Fragment())
                    .load(R.drawable.pecho_plano)
                    .into(ivExercise)
            }
        }
    }


}