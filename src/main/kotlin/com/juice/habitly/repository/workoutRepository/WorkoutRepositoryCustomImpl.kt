package com.juice.habitly.repository.workoutRepository

import com.juice.habitly.entity.Workout
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.mongodb.core.MongoTemplate


class WorkoutRepositoryCustomImpl(): WorkoutRepositoryCustom {

    @Autowired
    private lateinit var mongoTemplate: MongoTemplate

    // Update uses the save method but this class is an example on how to extend MongoRepository
    @Override
    override fun update(workout: Workout): Workout {
        return mongoTemplate.save(workout)
    }
}