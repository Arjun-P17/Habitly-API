package com.juice.habitly.model.entity

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "exercise")
data class ExerciseEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val name: String,
    val description: String?,
    val reps: Int,
    val sets: Int
)
