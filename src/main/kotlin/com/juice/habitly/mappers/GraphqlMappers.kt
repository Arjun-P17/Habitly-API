package com.juice.habitly.mappers

import com.juice.habitly.model.ExerciseType
import com.juice.habitly.model.MuscleGroup
import com.juice.habitly.model.entity.ExerciseEntity
import com.juice.habitly.model.entity.WorkoutEntity
import com.juice.habitly.model.entity.WorkoutEventEntity
import com.juice.habitly.model.entity.WorkoutExerciseEntity
import com.netflix.dgs.codegen.generated.types.Exercise as ExerciseGraphQL
import com.netflix.dgs.codegen.generated.types.Workout as WorkoutGraphQL
import com.netflix.dgs.codegen.generated.types.WorkoutEvent as WorkoutEventGraphQL
import com.netflix.dgs.codegen.generated.types.WorkoutExercise as WorkoutExerciseGraphQL
import com.netflix.dgs.codegen.generated.types.ExerciseType as ExerciseTypeGraphQL
import com.netflix.dgs.codegen.generated.types.MuscleGroup as MuscleGroupGraphQL


fun WorkoutEventEntity.toGraphQL() = WorkoutEventGraphQL(
    id = this.id,
    start = this.start,
    duration = this.duration,
    workout = this.workout.toGraphQL()
)

fun WorkoutEntity.toGraphQL() = WorkoutGraphQL(
    id = this.id,
    name = this.name,
    description = this.description,
    exercises = this.exercises.map { it.toGraphQL() }
)

fun WorkoutExerciseEntity.toGraphQL() = WorkoutExerciseGraphQL(
    id = this.id,
    workoutId = this.workoutId,
    exercise = this.exercise.toGraphQL(),
    reps = this.reps,
    sets = this.sets,
    weight = this.weight,
    distance = this.distance
)

fun ExerciseEntity.toGraphQL() = ExerciseGraphQL(
    id = this.id,
    name = this.name,
    description = this.description,
    muscleGroup = this.muscleGroup.toGraphQL(),
    type = this.type.toGraphQL()
)

fun ExerciseType.toGraphQL(): ExerciseTypeGraphQL {
    return when (this) {
        ExerciseType.STRENGTH -> ExerciseTypeGraphQL.STRENGTH
        ExerciseType.CARDIO -> ExerciseTypeGraphQL.CARDIO
        ExerciseType.STRETCH -> ExerciseTypeGraphQL.STRETCH
    }
}

fun MuscleGroup.toGraphQL(): MuscleGroupGraphQL {
    return when (this) {
        MuscleGroup.CHEST -> MuscleGroupGraphQL.CHEST
        MuscleGroup.SHOULDERS -> MuscleGroupGraphQL.SHOULDERS
        MuscleGroup.TRAPEZIUS -> MuscleGroupGraphQL.TRAPEZIUS
        MuscleGroup.DELTOIDS -> MuscleGroupGraphQL.DELTOIDS
        MuscleGroup.LATS -> MuscleGroupGraphQL.LATS
        MuscleGroup.BICEPS -> MuscleGroupGraphQL.BICEPS
        MuscleGroup.TRICEPS -> MuscleGroupGraphQL.TRICEPS
        MuscleGroup.FOREARMS -> MuscleGroupGraphQL.FOREARMS
        MuscleGroup.HAMSTRINGS -> MuscleGroupGraphQL.HAMSTRINGS
        MuscleGroup.QUADRICEPS -> MuscleGroupGraphQL.QUADRICEPS
        MuscleGroup.CALVES -> MuscleGroupGraphQL.CALVES
        MuscleGroup.GLUTES -> MuscleGroupGraphQL.GLUTES
        MuscleGroup.ABS -> MuscleGroupGraphQL.ABS
    }
}
