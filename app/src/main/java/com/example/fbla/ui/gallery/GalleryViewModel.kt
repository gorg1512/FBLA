import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class GalleryViewModel : ViewModel() {

    // Motivational quotes
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

    // LiveData for random motivational quote
    private val _randomQuote = MutableLiveData<String>()
    val randomQuote: LiveData<String> = _randomQuote

    // LiveData for navigating through quotes
    private val _currentQuoteIndex = MutableLiveData<Int>()
    val currentQuoteIndex: LiveData<Int> = _currentQuoteIndex

    init {
        // Initialize with a random quote
        updateRandomQuote()
        // Initialize with the first quote
        _currentQuoteIndex.value = 0
    }

    // Method to update the random motivational quote
    fun updateRandomQuote() {
        val randomIndex = (0 until motivationalQuotes.size).random()
        _randomQuote.value = motivationalQuotes[randomIndex]
    }

    // Method to navigate to the next quote
    fun nextQuote() {
        var index = _currentQuoteIndex.value ?: 0
        index = (index + 1) % motivationalQuotes.size
        _currentQuoteIndex.value = index
    }

    // Method to navigate to the previous quote
    fun previousQuote() {
        var index = _currentQuoteIndex.value ?: 0
        index = if (index > 0) index - 1 else motivationalQuotes.size - 1
        _currentQuoteIndex.value = index
    }
}
