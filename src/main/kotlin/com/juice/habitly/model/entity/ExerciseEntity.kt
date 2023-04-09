package com.juice.habitly.model.entity

import com.juice.habitly.model.ExerciseType
import com.juice.habitly.model.MuscleGroup
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "exercise")
data class ExerciseEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String?,
    @Enumerated(EnumType.STRING)
    val muscleGroup: MuscleGroup,
    @Enumerated(EnumType.STRING)
    val type: ExerciseType
)
