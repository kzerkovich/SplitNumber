package com.kzerk.splitnumber.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kzerk.splitnumber.R
import com.kzerk.splitnumber.databinding.FragmentGameBinding
import com.kzerk.splitnumber.domain.entity.GameResult
import com.kzerk.splitnumber.domain.entity.GameSettings
import com.kzerk.splitnumber.domain.entity.Level

class GameFragment: Fragment() {

	private lateinit var level: Level

	private var _binding: FragmentGameBinding? = null
	private val binding: FragmentGameBinding
		get() = _binding ?: throw RuntimeException("FragmentGameBinding == null")

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		parseArgs()
	}

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		_binding = FragmentGameBinding.inflate(inflater,container,false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
		super.onViewCreated(view, savedInstanceState)
		binding.tvOption1.setOnClickListener{
			launchGameFinishedFragment(
				GameResult(
				true,
				0,
				0,
				GameSettings(
					0,
					0,
					0,
					0
				)
			)
			)
		}
	}

	override fun onDestroyView() {
		super.onDestroyView()
		_binding = null
	}

	private fun parseArgs(){
		requireArguments().getParcelable<Level>(KEY_LEVEL)?.let {
			level = it
		}
	}

	private fun launchGameFinishedFragment(gameResult: GameResult) {
		requireActivity().supportFragmentManager.beginTransaction()
			.replace(R.id.main_container, GameFinishedFragment.newInstance(gameResult))
			.addToBackStack(null)
			.commit()
	}

	companion object {

		const val NAME = "GameFragment"

		private const val KEY_LEVEL = "level"

		fun newInstance(level: Level): GameFragment {
			return GameFragment().apply {
				arguments = Bundle().apply {
					putParcelable(KEY_LEVEL, level)
				}
			}
		}
	}
}