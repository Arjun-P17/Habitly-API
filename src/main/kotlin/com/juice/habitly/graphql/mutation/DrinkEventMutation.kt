package com.juice.habitly.graphql.mutation

import com.juice.habitly.entity.DrinkEvent
import com.juice.habitly.repository.DrinkEventRepository
import com.netflix.dgs.codegen.generated.types.DrinkEventInput
import com.netflix.graphql.dgs.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired


@DgsComponent
class DrinkEventMutation() {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var drinkEventRepository: DrinkEventRepository

    @DgsMutation
    fun drink(input: DrinkEventInput): DrinkEvent {
        logger.info(input.type.toString())

        return drinkEventRepository.save(DrinkEvent(
            date = input.date,
            type = input.type,
            amount = input.amount
        ))
    }

}