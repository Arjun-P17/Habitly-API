package com.juice.habitly.repository

import com.juice.habitly.entity.WorkoutEvent
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface WorkoutEventRepository: MongoRepository<WorkoutEvent,String>