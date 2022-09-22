package com.juice.habitly.entity

import com.netflix.dgs.codegen.generated.types.Exercise
import com.netflix.dgs.codegen.generated.types.WorkoutType
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "Workout")
data class Workout(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val name: String,
    val type: WorkoutType,
    val duration: Number,
    val exercises: List<Exercise>
)
