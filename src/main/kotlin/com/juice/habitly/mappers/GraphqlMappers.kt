package com.juice.habitly.mappers

import com.juice.habitly.model.WorkoutType
import com.juice.habitly.model.entity.ExerciseEntity
import com.juice.habitly.model.entity.WorkoutEntity
import com.juice.habitly.model.entity.WorkoutEventEntity
import com.netflix.dgs.codegen.generated.types.Exercise as ExerciseGraphQL
import com.netflix.dgs.codegen.generated.types.Workout as WorkoutGraphQL
import com.netflix.dgs.codegen.generated.types.WorkoutEvent as WorkoutEventGraphQL
import com.netflix.dgs.codegen.generated.types.WorkoutType as WorkoutTypeGraphQL


fun WorkoutEventEntity.toGraphQL() = WorkoutEventGraphQL(
    id = this.id,
    start = this.start,
    end = this.end,
    workout = this.workout.toGraphQL()
)

fun WorkoutEntity.toGraphQL() = WorkoutGraphQL(
    id = this.id,
    duration = this.duration,
    name = this.name,
    description = this.description,
    type = this.type.toGraphQL(),
    exercises = this.exercises.map { it.toGraphQL() }
)

fun WorkoutType.toGraphQL(): WorkoutTypeGraphQL {
    return when (this) {
        WorkoutType.WEIGHTS -> WorkoutTypeGraphQL.WEIGHTS
        WorkoutType.CARDIO -> WorkoutTypeGraphQL.CARDIO
        WorkoutType.STRETCH -> WorkoutTypeGraphQL.STRETCH
    }
}

fun ExerciseEntity.toGraphQL() = ExerciseGraphQL(
    id = this.id,
    name = this.name,
    description = this.description,
    sets = this.sets,
    reps = this.reps
)