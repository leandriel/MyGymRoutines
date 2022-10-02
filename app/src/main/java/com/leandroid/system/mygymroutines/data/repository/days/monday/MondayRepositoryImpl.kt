package com.leandroid.system.mygymroutines.data.repository.days.monday

import com.leandroid.system.mygymroutines.R
import com.leandroid.system.mygymroutines.data.utils.Response
import com.leandroid.system.mygymroutines.model.ExerciseModel
import com.leandroid.system.mygymroutines.model.RoutineModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//class MondayRepositoryImpl(private val service: MondayService) : MondayRepository {
class MondayRepositoryImpl : MondayRepository {
    override fun getMondayRoutine(): Flow<Response<MutableList<RoutineModel>>> {
        return flow {
             emit(Response.Loading)
             //val response = service.getMondatRoutine()
            //emit(Response.Success(response))
            val routines = mutableListOf<RoutineModel>(
                RoutineModel(
                    "1",
                    "3",
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
            emit(Response.Success(routines))
            //emit(Response.Error(Throwable("Hubo un error")))
        }
    }
}