package com.juice.habitly.entity

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.util.*

@Document(collection = "DrinkEvent")
data class DrinkEvent (
    @Id
    val id: String = UUID.randomUUID().toString(),
    val date: Long,
    val type: String,
    val amount: Number
)