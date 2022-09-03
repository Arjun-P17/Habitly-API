package com.juice.habitly.graphql.query

import com.juice.habitly.entity.DrinkEvent
import com.juice.habitly.repository.DrinkEventRepository
import com.netflix.graphql.dgs.*
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired


@DgsComponent
class DrinkEventQuery {
    private val logger: Logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    private lateinit var drinkEventRepository: DrinkEventRepository

    @DgsQuery
    fun testQuery(): String {
        logger.info("test")
        return "test"
    }

    @DgsQuery
    fun drinks(): List<DrinkEvent?>? {
        return drinkEventRepository.findAll()
    }
}