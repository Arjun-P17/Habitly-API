package com.juice.habitly.mappers

import com.juice.habitly.model.WorkoutType
import com.netflix.dgs.codegen.generated.types.WorkoutType as WorkoutTypeGraphQL

fun WorkoutTypeGraphQL.toEntity(): WorkoutType {
    return when (this) {
        WorkoutTypeGraphQL.WEIGHTS -> WorkoutType.WEIGHTS
        WorkoutTypeGraphQL.CARDIO -> WorkoutType.CARDIO
        WorkoutTypeGraphQL.STRETCH -> WorkoutType.STRETCH
    }
}
