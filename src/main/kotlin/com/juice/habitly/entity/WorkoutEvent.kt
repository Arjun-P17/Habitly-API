package com.juice.habitly.entity

import com.netflix.dgs.codegen.generated.types.WorkoutType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "WorkoutEvent")
data class WorkoutEvent(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val start: Number,
    val end: Number,
    val workout: Workout
)