package com.juice.habitly.repository

import com.juice.habitly.model.entity.ExerciseEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface ExerciseRepository: JpaRepository<ExerciseEntity, String>