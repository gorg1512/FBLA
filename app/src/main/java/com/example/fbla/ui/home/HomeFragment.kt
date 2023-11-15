package com.example.fbla.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fbla.R
import com.example.fbla.databinding.FragmentHomeBinding
import android.widget.Toast
class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        val textView: TextView = binding.text

        // Observe changes in the list of workouts
        homeViewModel.workouts.observe(viewLifecycleOwner) { workouts ->
            // Update the UI with the latest list of workouts
            displayWorkouts(workouts)
        }

        val myButton: Button = binding.root.findViewById(R.id.btnAddWorkout)

        myButton.setOnClickListener {
            // Handle button click to add a new workout
            addNewWorkout()
        }

        return root
    }

    private fun displayWorkouts(workouts: List<Workout>) {
        // Assuming you have a TextView with the ID "workoutList" to display workouts
        val workoutListTextView: TextView = binding.root.findViewById(R.id.btnAddWorkout)

        // Build a string with workout details and set it to the TextView
        val workoutDetails = buildWorkoutDetails(workouts)
        workoutListTextView.text = workoutDetails
    }

    private fun buildWorkoutDetails(workouts: List<Workout>): String {
        val stringBuilder = StringBuilder()
        for (workout in workouts) {
            stringBuilder.append("Workout: ${workout.name}, Duration: ${workout.durationMinutes} minutes\n")
            // Add more details as needed
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
