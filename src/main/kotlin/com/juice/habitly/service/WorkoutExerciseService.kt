package com.juice.habitly.service

import com.juice.habitly.model.entity.WorkoutExerciseEntity
import com.juice.habitly.repository.ExerciseRepository
import com.juice.habitly.repository.WorkoutExerciseRepository
import com.netflix.dgs.codegen.generated.types.WorkoutExerciseInput
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*

@Service
class WorkoutExerciseService(
    private val workoutExerciseRepository: WorkoutExerciseRepository,
    private val exerciseRepository: ExerciseRepository
) {

    fun existsById(id: UUID) : Boolean {
        return workoutExerciseRepository.existsById(id)
    }

    fun findAll() : List<WorkoutExerciseEntity> {
        return workoutExerciseRepository.findAll()
    }

    fun findByIdOrNull(id: UUID) : WorkoutExerciseEntity? {
        return workoutExerciseRepository.findByIdOrNull(id)
    }

    fun deleteById(id: UUID) {
        workoutExerciseRepository.deleteById(id)
    }

    fun upsertWorkoutExercise(input: WorkoutExerciseInput) : WorkoutExerciseEntity {
        return workoutExerciseRepository.save(input.toEntity())
    }

    private fun WorkoutExerciseInput.toEntity(): WorkoutExerciseEntity {
        return WorkoutExerciseEntity(
            id = this.id ?: UUID.randomUUID(),
            workoutId = this.workoutId,
            exercise = this.exerciseId.let {
                exerciseRepository.findByIdOrNull(it)
            } ?: throw IllegalArgumentException("Exercise not found"),
            sets = this.sets,
            reps = this.reps,
            weight = this.weight,
            distance = this.distance,
        )
    }
}
