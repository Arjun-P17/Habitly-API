package com.juice.habitly.repository

import com.juice.habitly.entity.DrinkEvent
import org.springframework.data.mongodb.repository.MongoRepository
import org.springframework.stereotype.Repository

@Repository
interface DrinkEventRepository: MongoRepository<DrinkEvent,String>