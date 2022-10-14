package com.leandroid.system.mygymroutines.data.repository.days.monday

import com.leandroid.system.mygymroutines.R
import com.leandroid.system.mygymroutines.data.utils.Response
import com.leandroid.system.mygymroutines.model.ExerciseModel
import com.leandroid.system.mygymroutines.model.RoutineModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MondayRepository {
//    fun getMondayRoutine(): Flow <Response<MutableList<RoutineModel>>>
    suspend fun getMondayRoutines(): List<RoutineModel>{
        return withContext(Dispatchers.IO){
            getMondayRoutinesGroup()
        }
    }

    private fun getMondayRoutinesGroup(): MutableList<RoutineModel>{
        val routines = mutableListOf<RoutineModel>()
            routines.add(
                RoutineModel(
                    "1",
                    3,
                    15,
                    R.drawable.pecho_plano,
                    ExerciseModel(
                        "1",
                        mutableListOf(
                            "Pecho plano"
                        )
                    )
                )
            )


        return routines
    }


}