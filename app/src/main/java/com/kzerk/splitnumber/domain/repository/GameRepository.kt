package com.kzerk.splitnumber.domain.repository

import com.kzerk.splitnumber.domain.entity.GameSettings
import com.kzerk.splitnumber.domain.entity.Level
import com.kzerk.splitnumber.domain.entity.Question

interface GameRepository {

	fun generateQuestion(
		maxSumValue: Int,
		countOfOptions: Int
	): Question

	fun getGameSettings(level: Level): GameSettings
}