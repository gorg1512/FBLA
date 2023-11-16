package com.example.fbla.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fbla.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root


        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)


        binding.btnAddWorkoutLinearLayout.setOnClickListener {
            addNewWorkout()
        }

        homeViewModel.workouts.observe(viewLifecycleOwner) { workouts ->
            displayWorkouts(workouts)
        }

        return root
    }

    private fun displayWorkouts(workouts: List<Workout>) {

        binding.workoutList.text = buildWorkoutDetails(workouts)
    }

    private fun buildWorkoutDetails(workouts: List<Workout>): String {
        val stringBuilder = StringBuilder()
        for (workout in workouts) {
            stringBuilder.append("Workout: ${workout.name}, Duration: ${workout.durationMinutes} minutes\n\n\n")

        }
        return stringBuilder.toString()
    }

    private fun addNewWorkout() {
        val newWorkout = Workout("New Workout", 30, "Description") // Example values, replace with actual data
        homeViewModel.addWorkout(newWorkout)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
