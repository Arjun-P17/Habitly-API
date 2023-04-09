package com.juice.habitly.graphql.mutation

import com.juice.habitly.repository.WorkoutRepository
import com.juice.habitly.service.WorkoutService
import com.netflix.graphql.dgs.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import java.util.*


@DgsComponent
class WorkoutMutation(
    @Autowired private val workoutService: WorkoutService,
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @DgsMutation
    fun removeWorkout(workoutId: UUID): Boolean {
        logger.info("Deleting workout $workoutId")

        workoutService.deleteById(workoutId)

        if (workoutService.existsById(workoutId)) return false
        return true
    }
}
