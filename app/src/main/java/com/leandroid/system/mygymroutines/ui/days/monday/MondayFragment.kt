package com.leandroid.system.mygymroutines.ui.days.monday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import com.leandroid.system.mygymroutines.R
import com.leandroid.system.mygymroutines.databinding.FragmentMondayBinding
import com.leandroid.system.mygymroutines.databinding.ItemRoutineBinding
import com.leandroid.system.mygymroutines.model.RoutineModel
import com.leandroid.system.mygymroutines.ui.utils.ComponentUtils.showToast
import com.leandroid.system.mygymroutines.ui.utils.DataState


import org.koin.androidx.viewmodel.ext.android.viewModel

class MondayFragment : Fragment() {
    private val viewModel: MondayViewModel by viewModels()
    private lateinit var mondayAdapter : MondayAdapter
    private lateinit var binding: FragmentMondayBinding
    private lateinit var _binding: ItemRoutineBinding
    private fun getLinearLayoutManager() = LinearLayoutManager(requireActivity())
    private lateinit var routine : RoutineModel
   //init viewmodel with koin
    // user binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initRecycler()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMondayBinding.inflate(inflater, container, false).also {
            binding = it
        }.root


    }
    private fun initRecycler(){
        val recycler = binding.rvMonday
        recycler.layoutManager = getLinearLayoutManager()

        val adapter = MondayAdapter()
        recycler.adapter = adapter

        viewModel.mondayList.observe(requireActivity()) {
                mondaylist->
            adapter.submitList(mondaylist)
        }
    }


}