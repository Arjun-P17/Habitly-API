package com.juice.habitly.graphql.query

import com.juice.habitly.model.entity.WorkoutEntity
import com.juice.habitly.mappers.toGraphQL
import com.juice.habitly.repository.WorkoutRepository
import com.netflix.dgs.codegen.generated.types.PageInfoInput
import com.netflix.dgs.codegen.generated.types.WorkoutsResponse
import com.netflix.graphql.dgs.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull
import java.util.*


@DgsComponent
class WorkoutQuery {

    @Autowired
    private lateinit var workoutRepository: WorkoutRepository

    // Ignores input parameters for now
    @DgsQuery
    fun workouts(input: PageInfoInput): WorkoutsResponse {
        val workouts = workoutRepository.findAll()
        return WorkoutsResponse(
            workouts = workouts.map {
                it.toGraphQL()
            }
        )
    }

    @DgsQuery
    fun workout(id: UUID): WorkoutEntity? {
        return workoutRepository.findByIdOrNull(id)
    }
}
