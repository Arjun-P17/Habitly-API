package com.juice.habitly.graphql.mutation

import com.juice.habitly.service.WorkoutExerciseService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.util.*

@DgsComponent
class WorkoutExerciseMutation(
    private val workoutExerciseService: WorkoutExerciseService,
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @DgsMutation
    fun removeWorkoutExercise(workoutExerciseId: UUID): Boolean {
        logger.info("Deleting workoutExercise $workoutExerciseId")

        workoutExerciseService.deleteById(workoutExerciseId)

        if (workoutExerciseService.existsById(workoutExerciseId)) return false
        return true
    }
}
