package com.juice.habitly.graphql.mutation

import com.juice.habitly.repository.WorkoutRepository
import com.netflix.graphql.dgs.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired


@DgsComponent
class WorkoutMutation(
    @Autowired private val workoutRepository: WorkoutRepository,
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @DgsMutation
    fun removeWorkout(workoutId: String): Boolean {
        logger.info("Deleting workout $workoutId")

        workoutRepository.deleteById(workoutId)

        if (workoutRepository.existsById(workoutId)) return false
        return true
    }
}