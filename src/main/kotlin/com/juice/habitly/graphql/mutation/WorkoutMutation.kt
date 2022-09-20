package com.juice.habitly.graphql.mutation

import com.juice.habitly.entity.Exercise
import com.juice.habitly.entity.Workout
import com.juice.habitly.repository.workoutRepository.WorkoutRepository
import com.netflix.dgs.codegen.generated.types.addWorkoutInput
import com.netflix.dgs.codegen.generated.types.updateWorkoutInput
import com.netflix.graphql.dgs.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired


@DgsComponent
class WorkoutMutation() {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var workoutRepository: WorkoutRepository

    @DgsMutation
    fun addWorkout(input: addWorkoutInput): Workout {
        logger.info("Adding new workout ${input.name}")

        return workoutRepository.save(Workout(
            name = input.name,
            type = input.type,
            duration = input.duration,
            exercises = input.exercises.map {
                Exercise(
                    name = it.name,
                    sets = it.sets,
                    reps = it.reps
                )

            }
        ))
    }

    @DgsMutation
    fun removeWorkout(workoutId: String): Boolean {
        logger.info("Deleting workout $workoutId")

        workoutRepository.deleteById(workoutId)

        if (workoutRepository.existsById(workoutId)) return false
        return true
    }

    @DgsMutation
    fun updateWorkout(input: updateWorkoutInput): Boolean {
        logger.info("Updating workout ${input.name}")

        return workoutRepository.findById(input.id).map {
            workoutRepository.update(Workout(
                id = input.id,
                name = input.name ?: it.name,
                type = input.type ?: it.type,
                duration = input.duration ?: it.duration,
                exercises = (input.exercises ?: it.exercises) as List<Exercise>
            ))
        }.isPresent
    }
}