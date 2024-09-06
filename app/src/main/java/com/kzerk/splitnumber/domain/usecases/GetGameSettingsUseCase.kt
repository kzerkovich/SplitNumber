package com.kzerk.splitnumber.domain.usecases

import com.kzerk.splitnumber.domain.entity.GameSettings
import com.kzerk.splitnumber.domain.entity.Level
import com.kzerk.splitnumber.domain.repository.GameRepository

class GetGameSettingsUseCase(
	private val repository: GameRepository
) {
	operator fun invoke(level: Level): GameSettings{
		return repository.getGameSettings(level)
	}
}