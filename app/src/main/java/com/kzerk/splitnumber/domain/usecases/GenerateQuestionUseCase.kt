package com.kzerk.splitnumber.domain.usecases

import com.kzerk.splitnumber.domain.entity.GameSettings
import com.kzerk.splitnumber.domain.entity.Question
import com.kzerk.splitnumber.domain.repository.GameRepository

class GenerateQuestionUseCase(
	private val repository: GameRepository
) {
	private companion object{
		private const val COUNT_OF_OPTIONS = 6

	}
	operator fun invoke(maxSumValue: Int): Question {
		return repository.generateQuestion(maxSumValue, COUNT_OF_OPTIONS)
	}
}