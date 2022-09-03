package com.juice.habitly

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HabitlyApplication

fun main(args: Array<String>) {
	runApplication<HabitlyApplication>(*args)
}
