package com.juice.habitly.repository

import com.juice.habitly.model.entity.WorkoutEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface WorkoutRepository: JpaRepository<WorkoutEntity, UUID>


