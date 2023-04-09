package com.juice.habitly.service

import com.juice.habitly.mappers.toEntity
import com.juice.habitly.model.entity.ExerciseEntity
import com.juice.habitly.repository.ExerciseRepository
import com.netflix.dgs.codegen.generated.types.ExerciseInput
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class ExerciseService(private val exerciseRepository: ExerciseRepository) {

    fun existsById(id: UUID) : Boolean {
        return exerciseRepository.existsById(id)
    }

    fun findAll() : List<ExerciseEntity> {
        return exerciseRepository.findAll()
    }

    fun findByIdOrNull(id: UUID) : ExerciseEntity? {
        return exerciseRepository.findByIdOrNull(id)
    }

    fun deleteById(id: UUID) {
        exerciseRepository.deleteById(id)
    }

    fun upsertExercise(input: ExerciseInput) : ExerciseEntity {
        return exerciseRepository.save(input.toEntity())
    }

    private fun ExerciseInput.toEntity(): ExerciseEntity {
        return ExerciseEntity(
            id = this.id ?: UUID.randomUUID(),
            name = this.name,
            description = this.description,
            muscleGroup = this.muscleGroup.toEntity(),
            type = this.type.toEntity(),
        )
    }
}
