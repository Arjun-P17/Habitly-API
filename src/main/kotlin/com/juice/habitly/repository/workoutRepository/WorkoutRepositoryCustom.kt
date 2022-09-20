package com.juice.habitly.repository.workoutRepository

import com.juice.habitly.entity.Workout
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkoutRepositoryCustom {
    fun update(workout: Workout): Workout
}

