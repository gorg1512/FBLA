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
    )

    // LiveData for random motivational quote
    private val _randomQuote = MutableLiveData<String>()
    val randomQuote: LiveData<String> = _randomQuote

    init {
        // Initialize with a random quote
        updateRandomQuote()
    }

    // Method to update the random motivational quote
    fun updateRandomQuote() {
        val randomIndex = (0 until motivationalQuotes.size).random()
        _randomQuote.value = motivationalQuotes[randomIndex]
    }
}
