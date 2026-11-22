package com.example.android_workshop

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

enum class TimerMode(val timeInSeconds: Int) {
    FOCUS(25 * 60),
    SHORT_BREAK(5 * 60),
    LONG_BREAK(15 * 60)
}

data class TimerUiState(
    val currentTime: Int = TimerMode.FOCUS.timeInSeconds,
    val mode: TimerMode = TimerMode.FOCUS,
    val isRunning: Boolean = false
)

sealed class TimerEvent {
    object TimerFinished : TimerEvent()
}

class TimerViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(TimerUiState())
    val uiState: StateFlow<TimerUiState> = _uiState.asStateFlow()

    private val _timerEvents = MutableSharedFlow<TimerEvent>()
    val timerEvents = _timerEvents.asSharedFlow()

    private var timerJob: Job? = null

    fun startTimer() {
        if (_uiState.value.isRunning) return
        _uiState.update { it.copy(isRunning = true) }

        timerJob = viewModelScope.launch {
            while (_uiState.value.currentTime > 0) {
                delay(1000L)
                _uiState.update { it.copy(currentTime = it.currentTime - 1) }
            }
            // Timer finished
            _uiState.update { it.copy(isRunning = false) }
            _timerEvents.emit(TimerEvent.TimerFinished)
        }
    }

    fun pauseTimer() {
        timerJob?.cancel()
        timerJob = null
        _uiState.update { it.copy(isRunning = false) }
    }

    fun resetTimer() {
        timerJob?.cancel()
        timerJob = null
        _uiState.update {
            it.copy(
                currentTime = it.mode.timeInSeconds,
                isRunning = false
            )
        }
    }

    fun setMode(mode: TimerMode) {
        timerJob?.cancel()
        timerJob = null
        _uiState.update {
            it.copy(
                mode = mode,
                currentTime = mode.timeInSeconds,
                isRunning = false
            )
        }
    }
}
