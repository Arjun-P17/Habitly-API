package com.juice.habitly.graphql.query

import com.juice.habitly.entity.Workout
import com.juice.habitly.repository.workoutRepository.WorkoutRepository
import com.netflix.dgs.codegen.generated.types.PageInfo
import com.netflix.dgs.codegen.generated.types.PageInfoInput
import com.netflix.dgs.codegen.generated.types.WorkoutsResponse
import com.netflix.dgs.codegen.generated.types.Workout as DgsWorkout
import com.netflix.dgs.codegen.generated.types.Exercise as DgsExercise
import com.netflix.graphql.dgs.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull


@DgsComponent
class WorkoutQuery {

    @Autowired
    private lateinit var workoutRepository: WorkoutRepository

    @DgsQuery
    fun workouts(): WorkoutsResponse {
        val workouts = workoutRepository.findAll()
        return WorkoutsResponse(
            workouts = workouts.map {
                DgsWorkout(
                    id = it.id,
                    duration = it.duration as Int,
                    name = it.name,
                    type = it.type,
                    exercises = it.exercises.map { exercise ->
                        DgsExercise(
                            name = exercise.name,
                            sets = exercise.sets,
                            reps = exercise.reps
                        )
                    },
                )
            }
        )
    }

    @DgsQuery
    fun workout(id: String): Workout? {
        return workoutRepository.findByIdOrNull(id)
    }
}