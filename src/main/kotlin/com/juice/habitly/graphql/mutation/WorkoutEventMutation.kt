package com.juice.habitly.graphql.mutation

import com.juice.habitly.entity.WorkoutEvent
import com.juice.habitly.entity.toDgsWorkoutEvent
import com.juice.habitly.repository.WorkoutEventRepository
import com.juice.habitly.repository.workoutRepository.WorkoutRepository
import com.netflix.dgs.codegen.generated.types.WorkoutEvent as DgsWorkoutEvent
import com.netflix.dgs.codegen.generated.types.addWorkoutEventInput
import com.netflix.dgs.codegen.generated.types.updateWorkoutEventInput
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired

@DgsComponent
class WorkoutEventMutation {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var workoutEventRepository: WorkoutEventRepository

    @Autowired
    private lateinit var workoutRepository: WorkoutRepository

    @DgsMutation
    fun addWorkoutEvent(input: addWorkoutEventInput): DgsWorkoutEvent {
        return workoutRepository.findById(input.workoutId).map {
            workoutEventRepository.save(WorkoutEvent(
                workout = it,
                start = input.start,
                end = input.end
            ) ).toDgsWorkoutEvent()
        }.orElse(null)

    }

    @DgsMutation
    fun removeWorkoutEvent(workoutEventId: String): Boolean {
        logger.info("Deleting workoutEvent $workoutEventId")

        workoutEventRepository.deleteById(workoutEventId)

        if (workoutEventRepository.existsById(workoutEventId)) return false
        return true
    }

    @DgsMutation
    fun updateWorkoutEvent(input: updateWorkoutEventInput): DgsWorkoutEvent {
        return workoutEventRepository.findById(input.id).map {
            val workout = input.workoutId?.let { it -> workoutRepository.findById(it).get() }

            workoutEventRepository.save(WorkoutEvent(
                id = input.id,
                start = input.start ?: it.start,
                end = input.end ?: it.end,
                workout = workout ?: it.workout
            )).toDgsWorkoutEvent()
        }.orElse(null)
    }
}