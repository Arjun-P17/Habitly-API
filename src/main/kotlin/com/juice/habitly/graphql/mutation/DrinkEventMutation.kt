package com.juice.habitly.graphql.mutation

import com.juice.habitly.entity.DrinkEvent
import com.juice.habitly.repository.DrinkEventRepository
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
    fun drink(date: Long,  type: String, amount: Number): DrinkEvent {
        logger.info(type)

        return drinkEventRepository.save(DrinkEvent(
            date = date,
            type = type,
            amount = amount
        ))
    }

}