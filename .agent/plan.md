# Project Plan

Create a "Pomodoro"-style Focus Timer application using Jetpack Compose. The UI should be modern, using Material 3 guidelines. Use a light-red ("tomato") color motif. Allow the user to toggle between "Focus" (25 min), "Short Break" (5 min), and "Long Break" (15 min) using a Segmented Button row. Display a large countdown timer (MM:SS) in the center of the screen, surrounded by a circular progress bar. Provide a large "Play/Pause" button and a smaller "Reset" button. When the timer hits 00:00, show a simple snackbar and play a default system notification sound.

## Project Brief

# Project Brief: Pomodoro Focus Timer

## Features
1. **Timer Modes**: Toggle between Focus (25 min), Short Break (5 min), and Long Break (15 min) sessions using a segmented button row.
2. **Visual Countdown**: A prominent countdown timer (MM:SS) surrounded by a circular progress bar to visually track remaining time.
3. **Timer Controls**: Essential controls including a large Play/Pause button and a secondary Reset button to manage the active session.
4. **Completion Alerts**: Automatic alerts upon timer completion, featuring a Snackbar notification and a default system sound.

## High-Level Technical Stack
- **Language**: Kotlin
- **UI Toolkit**: Jetpack Compose (using Material 3 guidelines and a custom light-red motif)
- **Navigation & Adaptive Strategy**: Jetpack Navigation 3 and Compose Material Adaptive library for robust, state-driven UI scaling across devices.
- **Asynchronous Execution**: Kotlin Coroutines for accurate, non-blocking countdown ticker implementation.
- **Architecture**: MVVM (Model-View-ViewModel) utilizing `ViewModel` and `StateFlow` for managing the timer state and UI logic.

## Implementation Steps

### Task_1_SetupThemeAndViewModel: Set up the light-red (tomato) Material 3 theme and create the ViewModel for Timer logic, handling Focus (25m), Short Break (5m), and Long Break (15m) using StateFlow and Coroutines.
- **Status:** COMPLETED
- **Updates:** Completed theme setup and TimerViewModel implementation with StateFlow and Coroutines.
- **Acceptance Criteria:**
  - Material 3 light-red theme is configured.
  - TimerViewModel is created with StateFlow for timer state.
  - Coroutines are used for timer countdown ticker logic.

### Task_2_BuildTimerUI: Build the Main Timer UI with Jetpack Compose, including a Segmented Button row, a central MM:SS countdown surrounded by a circular progress bar, and Play/Pause/Reset buttons.
- **Status:** COMPLETED
- **Updates:** Built the Main Timer UI with Jetpack Compose, including a Segmented Button row, a central MM:SS countdown surrounded by a circular progress bar, and Play/Pause/Reset buttons.
- **Acceptance Criteria:**
  - Segmented Button allows switching between Focus, Short Break, and Long Break.
  - Center screen has a large MM:SS text timer and Circular Progress Indicator.
  - Play/Pause and Reset buttons are present and styled properly.

### Task_3_IntegrateAndAlerts: Integrate the Timer UI with the ViewModel state and implement completion alerts. Play a default system notification sound and display a Snackbar when the timer reaches 00:00.
- **Status:** COMPLETED
- **Updates:** Integrated the Timer UI with the ViewModel state and implemented completion alerts (Snackbar and system sound) when the timer reaches 00:00.
- **Acceptance Criteria:**
  - UI accurately reflects the active timer session and remaining time from the ViewModel.
  - Snackbar shows when timer hits 00:00.
  - System notification sound plays on timer completion.

### Task_4_RunAndVerify: Run and Verify the application to ensure stability and correctness.
- **Status:** COMPLETED
- **Updates:** Deployed and verified the application. It builds successfully, does not crash, and all functionalities (timer, buttons, alerts) work as expected.
- **Acceptance Criteria:**
  - Project builds successfully
  - Make sure all existing tests pass
  - App does not crash
- **Duration:** N/A

