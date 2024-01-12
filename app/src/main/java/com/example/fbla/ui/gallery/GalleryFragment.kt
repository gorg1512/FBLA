package com.example.fbla.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.example.fbla.databinding.FragmentGalleryBinding

class GalleryFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private val binding get() = _binding!!

    private val motivationalQuotes = listOf(
        "Believe you can and you're halfway there.",
        "The only way to do great work is to love what you do.",
        "Don't watch the clock; do what it does. Keep going.",
        // Add more quotes as needed
        "Success is not final, failure is not fatal: It is the courage to continue that counts.",
        "The only limit to our realization of tomorrow will be our doubts of today.",
        "Your time is limited, don't waste it living someone else's life.",
        "The way to get started is to quit talking and begin doing.",
        "Success usually comes to those who are too busy to be looking for it.",
        "Don't be pushed around by the fears in your mind. Be led by the dreams in your heart.",
        "Believe in yourself and all that you are. Know that there is something inside you that is greater than any obstacle.",
        "Your work is going to fill a large part of your life, and the only way to be truly satisfied is to do what you believe is great work.",
        "Challenges are what make life interesting and overcoming them is what makes life meaningful.",
        "Don't let the fear of losing be greater than the excitement of winning.",
        "The only person you are destined to become is the person you decide to be.",
        "Success is stumbling from failure to failure with no loss of enthusiasm.",
        "The only way to do great work is to love what you do.",
        "What you get by achieving your goals is not as important as what you become by achieving your goals.",
        "Do not wait to strike till the iron is hot, but make it hot by striking.",
        "You are never too old to set another goal or to dream a new dream.",
        "The only thing standing between you and your goal is the story you keep telling yourself as to why you can't achieve it.",
        "Success is not in what you have, but who you are.",
        "The difference between a successful person and others is not a lack of strength, not a lack of knowledge, but rather a lack in will."
    )

    private lateinit var textView: TextView
    private lateinit var nextQuoteButton: Button
    private var currentQuoteIndex = 0

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGalleryBinding.inflate(inflater, container, false)
        val root: View = binding.root

        textView = binding.textGallery
        nextQuoteButton = binding.buttonNextQuote

        // Display the initial quote
        displayQuote()

        // Set up click listener for the button
        nextQuoteButton.setOnClickListener {
            // Display the next quote on button click
            showNextQuote()
        }

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun displayQuote() {
        textView.text = motivationalQuotes[currentQuoteIndex]
    }

    private fun showNextQuote() {
        // Increment the index and loop back to the first quote if needed
        currentQuoteIndex = (currentQuoteIndex + 1) % motivationalQuotes.size
        displayQuote()
    }
}
