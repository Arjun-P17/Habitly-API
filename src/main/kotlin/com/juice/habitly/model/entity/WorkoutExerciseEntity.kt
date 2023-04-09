package com.juice.habitly.model.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "workout_exercise")
data class WorkoutExerciseEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val workoutId: UUID,
    @ManyToOne
    @JoinColumn(name = "exercise_id")
    val exercise: ExerciseEntity,

    val reps: Int? = null,
    val sets: Int? = null,
    val weight: Int? = null,
    val distance: Int? = null,
)