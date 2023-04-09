package com.juice.habitly.service

import com.juice.habitly.model.entity.WorkoutEntity
import com.juice.habitly.repository.WorkoutExerciseRepository
import com.juice.habitly.repository.WorkoutRepository
import com.netflix.dgs.codegen.generated.types.WorkoutInput
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class WorkoutService(
    private val workoutRepository: WorkoutRepository,
    private val workoutExerciseRepository: WorkoutExerciseRepository,
) {

    fun existsById(id: UUID) : Boolean {
        return workoutRepository.existsById(id)
    }

    fun findAll() : List<WorkoutEntity> {
        return workoutRepository.findAll()
    }

    fun deleteById(id: UUID) {
        workoutRepository.deleteById(id)
    }

    fun findByIdOrNull(id: UUID) : WorkoutEntity? {
        return workoutRepository.findByIdOrNull(id)
    }

    fun upsertWorkout(input: WorkoutInput) : WorkoutEntity {
        return workoutRepository.save(input.toEntity())
    }

    // Should be creating the WorkoutExercise here as well, i think
    private fun WorkoutInput.toEntity() : WorkoutEntity {
        return WorkoutEntity(
            id = this.id ?: UUID.randomUUID(),
            name = this.name,
            description = this.description,
            exercises = this.exercises?.mapNotNull {
                workoutExerciseRepository.findByIdOrNull(it)
            } ?: emptyList()
        )
    }
}
