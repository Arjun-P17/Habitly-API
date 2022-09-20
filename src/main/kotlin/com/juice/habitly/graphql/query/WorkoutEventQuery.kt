package com.juice.habitly.graphql.query

import com.juice.habitly.entity.WorkoutEvent
import com.juice.habitly.repository.WorkoutEventRepository
import com.netflix.dgs.codegen.generated.types.PageInfoInput
import com.netflix.graphql.dgs.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.repository.findByIdOrNull

@DgsComponent
class WorkoutEventQuery {

    @Autowired
    private lateinit var workoutEventRepository: WorkoutEventRepository

    // Ignores input parameters for now
    @DgsQuery
    fun workoutHistory(input: PageInfoInput): List<WorkoutEvent?>? {
        return workoutEventRepository.findAll()
    }

    @DgsQuery
    fun workoutEvent(id: String): WorkoutEvent? {
        return workoutEventRepository.findByIdOrNull(id)
    }
}