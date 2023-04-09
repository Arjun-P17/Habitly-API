package com.juice.habitly.model.entity

import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "workout")
data class WorkoutEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String?,
    @OneToMany
    @JoinColumn(name = "workout_exercise_id")
    val exercises: List<WorkoutExerciseEntity>
)
