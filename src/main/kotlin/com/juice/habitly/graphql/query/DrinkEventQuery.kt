package com.juice.habitly.graphql.query

import com.juice.habitly.entity.DrinkEvent
import com.juice.habitly.entity.toDgsDrinkEvent
import com.netflix.dgs.codegen.generated.types.DrinkEvent as DgsDrinkEvent
import com.juice.habitly.repository.DrinkEventRepository
import com.netflix.graphql.dgs.*
import org.springframework.beans.factory.annotation.Autowired


@DgsComponent
class DrinkEventQuery {

    @Autowired
    private lateinit var drinkEventRepository: DrinkEventRepository

    @DgsQuery
    fun drinks(): List<DgsDrinkEvent?>? {
        return drinkEventRepository.findAll().map {
            it.toDgsDrinkEvent()
        }
    }
}