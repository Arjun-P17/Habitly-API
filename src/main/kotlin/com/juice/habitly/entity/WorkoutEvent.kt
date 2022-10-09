package com.juice.habitly.entity

import com.netflix.dgs.codegen.generated.types.WorkoutEvent as DgsWorkoutEvent
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.lang.Long
import java.util.*

@Document(collection = "WorkoutEvent")
data class WorkoutEvent(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val start: Number,
    val end: Number,
    val workout: Workout
)

fun WorkoutEvent.toDgsWorkoutEvent(): DgsWorkoutEvent {
    return DgsWorkoutEvent(
        id = this.id,
        start = this.start as Long,
        end = this.end as Long,
        workout = this.workout.toDgsWorkout()
    )
}