package com.juice.habitly.service

import com.juice.habitly.model.entity.WorkoutEventEntity
import com.juice.habitly.repository.WorkoutEventRepository
import com.juice.habitly.repository.WorkoutRepository
import com.netflix.dgs.codegen.generated.types.WorkoutEventInput
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class WorkoutEventService(
    private val workoutEventRepository: WorkoutEventRepository,
    private val workoutRepository: WorkoutRepository,
) {

    fun existsById(id: UUID) : Boolean {
        return workoutEventRepository.existsById(id)
    }

    fun findAll() : List<WorkoutEventEntity> {
        return workoutEventRepository.findAll()
    }

    fun findByIdOrNull(id: UUID) : WorkoutEventEntity? {
        return workoutEventRepository.findByIdOrNull(id)
    }

    fun deleteById(id: UUID) {
        workoutEventRepository.deleteById(id)
    }


    fun upsertWorkoutEvent(input: WorkoutEventInput) : WorkoutEventEntity {
        return workoutEventRepository.save(input.toEntity())
    }

    private fun WorkoutEventInput.toEntity(): WorkoutEventEntity {
        return WorkoutEventEntity(
            id = this.id ?: UUID.randomUUID(),
            start = this.start,
            duration = this.duration,
            workout = this.workoutId.let {
                workoutRepository.findByIdOrNull(it)
            } ?: throw IllegalArgumentException("Workout not found"),
        )
    }
}