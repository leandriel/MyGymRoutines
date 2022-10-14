package com.leandroid.system.mygymroutines.model

import android.media.Image

data class RoutineModel(
    val id: String,
    val series: Int,
    val repetitions: Int,
    val imageExercise: Int,
    val exercises: ExerciseModel
) {
}