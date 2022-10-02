package com.leandroid.system.mygymroutines.ui.days.monday

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.graphics.drawable.toDrawable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.leandroid.system.mygymroutines.R
import com.leandroid.system.mygymroutines.databinding.ItemRoutineBinding
import com.leandroid.system.mygymroutines.model.RoutineModel

class MondayAdapter(): RecyclerView.Adapter<MondayAdapter.MondayViewHolder>(){

    private var mondayRoutine: MutableList<RoutineModel> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MondayViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return MondayViewHolder(layoutInflater.inflate(R.layout.item_routine, parent, false))
    }

    override fun onBindViewHolder(holderMondayRoutine: MondayViewHolder, position: Int) {
        val item = mondayRoutine[position]
        holderMondayRoutine.bind(item)
    }

    fun getItemByPosition(position: Int) = mondayRoutine[position]

    override fun getItemCount(): Int = mondayRoutine.size

    fun setMondayRoutine(mondayRoutine: MutableList<RoutineModel>) {
        this.mondayRoutine = mondayRoutine
        notifyDataSetChanged()
    }

    inner class MondayViewHolder(
        view: View
    ) :
        RecyclerView.ViewHolder(view) {
        private val binding = ItemRoutineBinding.bind(view)
        fun bind(routine: RoutineModel) {
            with(binding) {
                tvExerciseTitle.text = routine.exercises.toString()
                tvSeries.text = routine.series.toString()
                tvRepetition.text = routine.repetitions.toString()
                Glide.with(Fragment())
                    .load(R.drawable.pecho_plano)
                    .into(ivExercise)
            }
        }
    }
}