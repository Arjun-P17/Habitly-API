package com.juice.habitly.model.entity

import com.juice.habitly.model.WorkoutType
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "workout")
data class WorkoutEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String?,
    @Enumerated(EnumType.STRING)
    val type: WorkoutType,
    val duration: Long,
    @ManyToMany
    @JoinTable(
        name = "workout_exercise",
        joinColumns = [JoinColumn(name = "workout_id")],
        inverseJoinColumns = [JoinColumn(name = "exercise_id")]
    )
    val exercises: List<ExerciseEntity>
)
