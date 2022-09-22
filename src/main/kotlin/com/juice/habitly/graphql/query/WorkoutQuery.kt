package com.juice.habitly.graphql.query

import com.juice.habitly.entity.Workout
import com.juice.habitly.entity.toDgsWorkout
import com.juice.habitly.repository.workoutRepository.WorkoutRepository
import com.netflix.dgs.codegen.generated.types.WorkoutsResponse
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
                it.toDgsWorkout()
            }
        )
    }

    @DgsQuery
    fun workout(id: String): Workout? {
        return workoutRepository.findByIdOrNull(id)
    }
}