package com.juice.habitly.model.entity

import java.time.Instant
import java.util.UUID
import javax.persistence.*

@Entity
@Table(name = "workout_event")
data class WorkoutEventEntity(
    @Id
    val id: UUID = UUID.randomUUID(),
    val start: Instant,
    val duration: Long,
    @ManyToOne
    @JoinColumn(name = "workout_id")
    val workout: WorkoutEntity
)
