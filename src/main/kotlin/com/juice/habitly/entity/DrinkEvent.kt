package com.juice.habitly.entity

import com.netflix.dgs.codegen.generated.types.DrinkType
import com.netflix.dgs.codegen.generated.types.DrinkEvent as DgsDrinkEvent
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.lang.Long
import java.util.*

@Document(collection = "DrinkEvent")
data class DrinkEvent(
    @Id
    val id: String = UUID.randomUUID().toString(),
    val date: Long,
    val type: DrinkType,
    val amount: Number
)

fun DrinkEvent.toDgsDrinkEvent(): DgsDrinkEvent {
    return DgsDrinkEvent (
        id = this.id,
        date = this.date,
        type = this.type,
        amount = this.amount as Int
    )
}