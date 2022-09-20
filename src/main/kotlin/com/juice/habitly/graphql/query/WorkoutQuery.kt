package com.juice.habitly.graphql.query

import com.juice.habitly.entity.Workout
import com.juice.habitly.repository.workoutRepository.WorkoutRepository
import com.netflix.graphql.dgs.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull


@DgsComponent
class WorkoutQuery {

    @Autowired
    private lateinit var workoutRepository: WorkoutRepository

    @DgsQuery
    fun workouts(): List<Workout?>? {
        return workoutRepository.findAll()
    }

    @DgsQuery
    fun workout(id: String): Workout? {
        return workoutRepository.findByIdOrNull(id)
    }
}