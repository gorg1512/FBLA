// HomeViewModel.kt
package com.example.fbla.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "Workout Tracker"
    }

    val text: LiveData<String> = _text

    private val _workouts = MutableLiveData<List<Workout>>()
    val workouts: LiveData<List<Workout>> get() = _workouts

    fun addWorkout(workout: Workout) {
        // Get the current list of workouts and add the new workout
        val currentWorkouts = _workouts.value.orEmpty().toMutableList()
        currentWorkouts.add(workout)

        // Update the LiveData with the new list of workouts
        _workouts.value = currentWorkouts
    }
}

