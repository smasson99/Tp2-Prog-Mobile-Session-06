package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.databinding.BindingAdapter
import android.widget.TextView
import ca.csf.mobile2.tp2.R
import ca.csf.mobile2.tp2.util.ViewModelProperty
import org.parceler.Parcel
import org.parceler.ParcelConstructor

const val PERCENTAGE_MULTIPLIER = 100

enum class QuestionActivityErrorCode {
    NONE,
    CONNECTIVITY,
    SERVER
}

@Parcel(Parcel.Serialization.BEAN)
class QuestionActivityViewModel @ParcelConstructor constructor(question: Question) : BaseObservable() {

    private val questionTotalAnswers: Int get() = question.nbChoice1 + question.nbChoice2

    var question by ViewModelProperty(question, this)
    var userHasAnswered by ViewModelProperty(false, this)

    @get:Bindable
    var currentErrorCode by ViewModelProperty(QuestionActivityErrorCode.NONE, this)

    @get:Bindable
    val questionText: String
        get() = question.text

    @get:Bindable
    var isLoading: Boolean = false
    @get:Bindable
    val canShowQuestions: Boolean
        get() = !userHasAnswered && !hasAnError && !isLoading
    @get:Bindable
    val canShowAnswers: Boolean
        get() = userHasAnswered && !hasAnError && !isLoading
    @get:Bindable
    val hasAnError: Boolean
        get() = currentErrorCode != QuestionActivityErrorCode.NONE

    @get:Bindable
    val percentQuestion1: Float
        get() {

            if (question.nbChoice1 + question.nbChoice2 <= 0)
                return 0.0f

            return (question.nbChoice1.toFloat() / questionTotalAnswers.toFloat() * PERCENTAGE_MULTIPLIER)
        }
    @get:Bindable
    val percentQuestion2: Float
        get() {
            if (question.nbChoice1 + question.nbChoice2 <= 0)
                return 0.0f

            return (question.nbChoice2.toFloat() / questionTotalAnswers.toFloat() * PERCENTAGE_MULTIPLIER)
        }

    @get:Bindable
    val choice1: String
        get() = question.choice1
    @get:Bindable
    val choice2: String
        get() = question.choice2
    @get:Bindable
    var errorMessage by ViewModelProperty("", this)
}

@BindingAdapter("percentage")
fun displayPercentage(textView: TextView, percentage: Float) {
    textView.text = textView.resources.getString(
        R.string.text_percentage, percentage
    )
}