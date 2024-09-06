package com.kzerk.splitnumber.domain.entity

data class GameSettings(
	val maxSumValue: Int,
	val minCountOfRightAnswers: Int,
	val minPercentOfRightAnswers: Int,
	val gameTimeInSec: Int
)