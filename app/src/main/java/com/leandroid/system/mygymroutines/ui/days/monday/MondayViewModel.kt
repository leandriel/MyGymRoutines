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

class MondayViewModel : ViewModel() {
    private val _mondayList = MutableLiveData<List<RoutineModel>>()
    val mondayList : LiveData<List<RoutineModel>>
        get() = _mondayList


    private val mondayRepository = MondayRepository()


    init {
        getMondayRoutines()
    }

    private fun getMondayRoutines() {
        viewModelScope.launch{
            _mondayList.value = mondayRepository.getMondayRoutines()
        }
    }
}