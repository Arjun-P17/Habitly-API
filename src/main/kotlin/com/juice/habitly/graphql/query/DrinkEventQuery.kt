package com.juice.habitly.graphql.query

import com.juice.habitly.entity.DrinkEvent
import com.juice.habitly.repository.DrinkEventRepository
import com.netflix.graphql.dgs.*
import org.springframework.beans.factory.annotation.Autowired


@DgsComponent
class DrinkEventQuery {

    @Autowired
    private lateinit var drinkEventRepository: DrinkEventRepository

    @DgsQuery
    fun drinks(): List<DrinkEvent?>? {
        return drinkEventRepository.findAll()
    }
}