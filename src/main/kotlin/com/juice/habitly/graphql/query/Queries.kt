package com.juice.habitly.graphql.query

import com.juice.habitly.mappers.toGraphQL
import com.juice.habitly.model.entity.ExerciseEntity
import com.juice.habitly.model.entity.WorkoutEntity
import com.juice.habitly.model.entity.WorkoutEventEntity
import com.juice.habitly.model.entity.WorkoutExerciseEntity
import com.juice.habitly.repository.WorkoutEventRepository
import com.juice.habitly.service.ExerciseService
import com.juice.habitly.service.WorkoutExerciseService
import com.juice.habitly.service.WorkoutService
import com.netflix.dgs.codegen.generated.types.*
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsQuery
import org.springframework.data.repository.findByIdOrNull
import java.util.*

@DgsComponent
class Queries(
    private val workoutEventRepository: WorkoutEventRepository,
    private val workoutService: WorkoutService,
    private val workoutExerciseService: WorkoutExerciseService,
    private val exerciseService: ExerciseService,
) {

    // Ignores input parameters for now
    @DgsQuery
    fun workoutHistory(input: PageInfoInput): WorkoutHistoryResponse {
        return WorkoutHistoryResponse(
            workoutHistory = workoutEventRepository.findAll().map {
                it.toGraphQL()
            }
        )
    }

    @DgsQuery
    fun workoutEvent(id: UUID): WorkoutEventEntity? {
        return workoutEventRepository.findByIdOrNull(id)
    }


    @DgsQuery
    fun workouts(input: PageInfoInput): WorkoutsResponse {
        val workouts = workoutService.findAll()
        return WorkoutsResponse(
            workouts = workouts.map {
                it.toGraphQL()
            }
        )
    }

    @DgsQuery
    fun workout(id: UUID): WorkoutEntity? {
        return workoutService.findByIdOrNull(id)
    }


    @DgsQuery
    fun workoutExercises(input: PageInfoInput): WorkoutExercisesResponse {
        val workoutExercises = workoutExerciseService.findAll()
        return WorkoutExercisesResponse(
            workoutExercises = workoutExercises.map {
                it.toGraphQL()
            }
        )
    }

    @DgsQuery
    fun workoutExercise(id: UUID): WorkoutExerciseEntity? {
        return workoutExerciseService.findByIdOrNull(id)
    }


    @DgsQuery
    fun exercises(input: PageInfoInput): ExercisesResponse {
        val exercises = exerciseService.findAll()
        return ExercisesResponse(
            exercises = exercises.map {
                it.toGraphQL()
            }
        )
    }

    @DgsQuery
    fun exercise(id: UUID): ExerciseEntity? {
        return exerciseService.findByIdOrNull(id)
    }
}
