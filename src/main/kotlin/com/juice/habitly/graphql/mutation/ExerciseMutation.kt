package com.juice.habitly.graphql.mutation

import com.juice.habitly.service.ExerciseService
import com.netflix.graphql.dgs.DgsComponent
import com.netflix.graphql.dgs.DgsMutation
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import java.util.*

@DgsComponent
class ExerciseMutation(
    @Autowired private val exerciseService: ExerciseService,
) {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @DgsMutation
    fun removeExercise(exerciseId: UUID): Boolean {
        logger.info("Deleting exercise $exerciseId")

        exerciseService.deleteById(exerciseId)

        if (exerciseService.existsById(exerciseId)) return false
        return true
    }
}
