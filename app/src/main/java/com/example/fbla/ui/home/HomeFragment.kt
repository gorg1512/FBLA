package com.example.fbla.ui.home

import android.app.AlertDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.fbla.R
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
            showAddWorkoutDialog()
        }

        homeViewModel.workouts.observe(viewLifecycleOwner) { workouts ->
            displayWorkouts(workouts)
        }

        return root
    }

    private fun showAddWorkoutDialog() {
        val dialogView = layoutInflater.inflate(R.layout.dialog_add_workout, null)
        val editTextName = dialogView.findViewById<EditText>(R.id.editTextWorkoutName)
        val editTextSets = dialogView.findViewById<EditText>(R.id.editTextSets)
        val editTextReps = dialogView.findViewById<EditText>(R.id.editTextReps)

        // Create a dialog
        val dialog = AlertDialog.Builder(requireContext())
            .setTitle("Add New Workout")
            .setView(dialogView)
            .setPositiveButton("Add") { _, _ ->
                // Get user input and add a new workout
                val name = editTextName.text.toString()
                val sets = editTextSets.text.toString().toIntOrNull() ?: 0
                val reps = editTextReps.text.toString().toIntOrNull() ?: 0
                val newWorkout = Workout(name, sets, reps, "Description") // Example values, replace with actual data
                homeViewModel.addWorkout(newWorkout)
            }
            .setNegativeButton("Cancel", null)
            .create()

        dialog.show()
    }

    private fun displayWorkouts(workouts: List<Workout>) {
        binding.workoutList.text = buildWorkoutDetails(workouts)
    }

    private fun buildWorkoutDetails(workouts: List<Workout>): String {
        val stringBuilder = StringBuilder()
        for (workout in workouts) {
            stringBuilder.append("Workout: ${workout.name}, Sets: ${workout.sets}, Reps: ${workout.reps}\n\n\n")
        }
        return stringBuilder.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
