package com.leandroid.system.mygymroutines.data.repository.days.monday

import com.leandroid.system.mygymroutines.data.utils.Response
import com.leandroid.system.mygymroutines.model.RoutineModel
import kotlinx.coroutines.flow.Flow

interface MondayRepository {
    fun getMondayRoutine(): Flow <Response<MutableList<RoutineModel>>>
}