package com.juice.habitly.graphql.mutation


import com.juice.habitly.repository.WorkoutEventRepository
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@DgsComponent
class WorkoutEventMutation(
    @Autowired private val workoutEventRepository: WorkoutEventRepository
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @DgsMutation
    fun removeWorkoutEvent(workoutEventId: UUID): Boolean {
        logger.info("Deleting workoutEvent $workoutEventId")

        workoutEventRepository.deleteById(workoutEventId)

        if (workoutEventRepository.existsById(workoutEventId)) return false
        return true
    }
}
