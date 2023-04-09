package com.juice.habitly.mappers

import com.juice.habitly.model.ExerciseType
import com.juice.habitly.model.MuscleGroup
import com.netflix.dgs.codegen.generated.types.ExerciseType as ExerciseTypeGraphQL
import com.netflix.dgs.codegen.generated.types.MuscleGroup as MuscleGroupGraphQL

fun ExerciseTypeGraphQL.toEntity(): ExerciseType {
    return when (this) {
        ExerciseTypeGraphQL.STRENGTH -> ExerciseType.STRENGTH
        ExerciseTypeGraphQL.CARDIO -> ExerciseType.CARDIO
        ExerciseTypeGraphQL.STRETCH -> ExerciseType.STRETCH
    }
}

fun MuscleGroupGraphQL.toEntity(): MuscleGroup {
    return when (this) {
        MuscleGroupGraphQL.CHEST -> MuscleGroup.CHEST
        MuscleGroupGraphQL.SHOULDERS -> MuscleGroup.SHOULDERS
        MuscleGroupGraphQL.TRAPEZIUS -> MuscleGroup.TRAPEZIUS
        MuscleGroupGraphQL.DELTOIDS -> MuscleGroup.DELTOIDS
        MuscleGroupGraphQL.LATS -> MuscleGroup.LATS
        MuscleGroupGraphQL.BICEPS -> MuscleGroup.BICEPS
        MuscleGroupGraphQL.TRICEPS -> MuscleGroup.TRICEPS
        MuscleGroupGraphQL.FOREARMS -> MuscleGroup.FOREARMS
        MuscleGroupGraphQL.HAMSTRINGS -> MuscleGroup.HAMSTRINGS
        MuscleGroupGraphQL.QUADRICEPS -> MuscleGroup.QUADRICEPS
        MuscleGroupGraphQL.CALVES -> MuscleGroup.CALVES
        MuscleGroupGraphQL.GLUTES -> MuscleGroup.GLUTES
        MuscleGroupGraphQL.ABS -> MuscleGroup.ABS
    }
}