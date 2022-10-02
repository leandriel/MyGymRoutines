package com.leandroid.system.mygymroutines.ui.days.monday

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.leandroid.system.mygymroutines.data.repository.days.monday.MondayRepository
import com.leandroid.system.mygymroutines.data.utils.Response
import com.leandroid.system.mygymroutines.model.RoutineModel
import com.leandroid.system.mygymroutines.ui.utils.DataState
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MondayViewModel (private val repository : MondayRepository): ViewModel() {
    //livedata
    // coroutine
    private val _routines: MutableLiveData<DataState<MutableList<RoutineModel>>> =
        MutableLiveData(DataState.Idle)
    val routines: LiveData<DataState<MutableList<RoutineModel>>> = _routines

    fun getMondayRoutines() {
        viewModelScope.launch {
            repository.getMondayRoutine().onEach {
                when (it) {
                    is Response.NotInitialized, Response.Loading -> {
                        _routines.value = DataState.Loading(loading = true)
                    }
                    is Response.Success -> {
                        _routines.value = DataState.Success(it.data)
                    }
                    is Response.Error -> {
                        _routines.value = DataState.Loading(loading = false)
                        _routines.value = DataState.Error(it.exception)
                    }
                }
            }.launchIn(this)
        }
    }
}