package com.juice.habitly.service

import com.juice.habitly.model.entity.ExerciseEntity
import com.juice.habitly.repository.ExerciseRepository
import com.netflix.dgs.codegen.generated.types.ExerciseInput
import org.springframework.stereotype.Service
import java.util.*

@Service
class ExerciseService(
    private val exerciseRepository: ExerciseRepository
) {

    fun upsertExercise(exercise: ExerciseInput) {
        exerciseRepository.save(exercise.toEntity())
    }

    private fun ExerciseInput.toEntity(): ExerciseEntity {
        return ExerciseEntity(
            id = this.id ?: UUID.randomUUID(),
            name = this.name,
            description = this.description,
            sets = this.sets,
            reps = this.reps,
        )
    }
}
