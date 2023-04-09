package com.juice.habitly.service

import com.juice.habitly.mappers.toEntity
import com.juice.habitly.model.entity.WorkoutEntity
import com.juice.habitly.repository.ExerciseRepository
import com.juice.habitly.repository.WorkoutRepository
import com.juice.habitly.repository.findByIdOrNull
import com.netflix.dgs.codegen.generated.types.WorkoutInput
import org.springframework.stereotype.Service
import java.util.*

@Service
class WorkoutService(
    private val workoutRepository: WorkoutRepository,
    private val exerciseRepository: ExerciseRepository,
) {

    fun upsertWorkout(input: WorkoutInput) {
        workoutRepository.save(input.toEntity())
    }

    private fun WorkoutInput.toEntity() : WorkoutEntity {
        return WorkoutEntity(
            id = this.id ?: UUID.randomUUID(),
            name = this.name,
            description = this.description,
            type = this.type.toEntity(),
            duration = this.duration,
            exercises = this.exercises?.mapNotNull {
                exerciseRepository.findByIdOrNull(it)
            } ?: emptyList()
        )
    }
}
