package com.leandroid.system.mygymroutines.ui.days.monday

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
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
    private val viewModel: MondayViewModel by viewModel()
    private lateinit var mondayAdapter : MondayAdapter
    private lateinit var binding: FragmentMondayBinding
    private lateinit var _binding: ItemRoutineBinding
    private lateinit var routine : RoutineModel
   //init viewmodel with koin
    // user binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViewModel() // -> observable -> call routines
        initRecycler() // -> init adapter
        setUpObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMondayBinding.inflate(inflater, container, false).also {
            binding = it
        }.root
    }

    private fun setUpViewModel(){
        with(viewModel) {
            getMondayRoutines()
            routines.observe(requireActivity()) { state ->
                handleUiMondayRoutines(state)


            }
        }
    }

    private fun setUpObserver() {
        with(viewModel) {
            getMondayRoutines()

            routines.observe(requireActivity()) { state ->
                handleUiMondayRoutines(state)
            }

//            data.observe(requireActivity()) { state ->
//                handleUiData(state)
//            }
        }
    }

    private fun initRecycler(){
        mondayAdapter = MondayAdapter()
        val linearLayoutManager = getLinearLayoutManager()
        with(binding.rvMonday) {
            layoutManager = linearLayoutManager
            adapter = mondayAdapter
        }
    }

    private fun getLinearLayoutManager() = LinearLayoutManager(requireContext())


    private fun handleUiMondayRoutines(uiState: DataState<MutableList<RoutineModel>>) {
        when (uiState) {
            is DataState.Success<MutableList<RoutineModel>> -> {
                if (uiState.data.isNotEmpty()) {
                    mondayAdapter = MondayAdapter()
                    mondayAdapter.setMondayRoutine(uiState.data)
                    binding.tvEmptyMonday.visibility = View.GONE
                } else
                    binding.tvEmptyMonday.visibility = View.VISIBLE

                binding.tvErrorMonday.visibility = View.GONE
                handlerProgressBarVisibility(false)
//                handlerMainContainerVisibility(true)
            }
            is DataState.Error -> {
                binding.tvErrorMonday.visibility = View.VISIBLE
                handlerProgressBarVisibility(false)
//                handlerMainContainerVisibility(true)
                showToast(
                    requireContext(),
                    uiState.throwable.message ?: getString(R.string.known_error))
            }
            is DataState.Loading -> {
                handlerProgressBarVisibility(true)
//                handlerMainContainerVisibility(false)
            }
            is DataState.Idle -> Unit
        }
    }

    private fun handlerProgressBarVisibility(show: Boolean) {
        binding.pbLoading.visibility = if (show) View.VISIBLE else View.GONE
    }

    private fun handlerMainContainerVisibility(show: Boolean) {
        binding.flMainContainer.visibility = if (show) View.VISIBLE else View.GONE
    }

}