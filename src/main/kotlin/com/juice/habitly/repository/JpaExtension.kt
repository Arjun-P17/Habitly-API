package com.juice.habitly.repository

import org.springframework.data.jpa.repository.JpaRepository

fun <T, ID> JpaRepository<T, ID>.findByIdOrNull(id: ID): T? = findById(id).orElse(null)
