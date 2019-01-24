package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import android.os.Debug
import android.util.Log
import ca.csf.mobile2.tp2.util.ViewModelProperty
import org.parceler.Parcel
import org.parceler.ParcelConstructor
import java.util.*

enum class QuestionActivityErrorCode
{
    NONE,
    CONNECTIVITY,
    SERVER
}

@Parcel(Parcel.Serialization.BEAN)
class QuestionActivityViewModel @ParcelConstructor constructor(question : Question) : BaseObservable() {

    var question by ViewModelProperty(Question(), this)
    var currentErrorCode = QuestionActivityErrorCode.NONE
    var userHasAnswered = false
    private val questionTotalAnswers : Int get() = question.nbChoice1 + question.nbChoice2

    fun onResume() {

    }

    fun onPause() {

    }

    @get:Bindable
    val questionText : String get() = question.text


    @get:Bindable
    var isLoading : Boolean = false
    @get:Bindable
    val canShowQuestions : Boolean get() = !userHasAnswered && !hasAnError && !isLoading
    @get:Bindable
    val canShowAnswers : Boolean get() = userHasAnswered && !hasAnError && !isLoading
    @get:Bindable
    val hasAnError : Boolean get() = currentErrorCode != QuestionActivityErrorCode.NONE

    @get:Bindable
    val percentQuestion1 : String get() {

        if (question.nbChoice1 + question.nbChoice2 <= 0)
            return 0.toString()

        return (question.nbChoice1.toFloat() / questionTotalAnswers.toFloat() * 100).toInt().toString() + "%"
    }
    @get:Bindable
    val percentQuestion2 : String get() {
        if (question.nbChoice1 + question.nbChoice2 <= 0)
            return 0.toString()

        Log.v("bob", "1: " + question.nbChoice1 + " 2: " + question.nbChoice2 + " total : " + questionTotalAnswers)
        return (question.nbChoice2.toFloat() / questionTotalAnswers.toFloat() * 100).toInt().toString() + "%"
    }

    @get:Bindable
    val choice1 : String get() = question.choice1
    @get:Bindable
    val choice2 : String get() = question.choice2
    @get:Bindable
    var errorMessage : String = ""
}