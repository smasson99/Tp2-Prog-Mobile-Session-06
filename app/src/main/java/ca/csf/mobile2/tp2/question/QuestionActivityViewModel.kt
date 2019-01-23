package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
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
    var errorMessage = ""

    fun onResume() {

    }

    fun onPause() {

    }

    @get:Bindable
    val text : String get() = question.text
    @get:Bindable
    var isLoading : Boolean = false
    @get:Bindable
    val errorCode : QuestionActivityErrorCode get() = currentErrorCode
    @get:Bindable
    val hasAnError : Boolean get() = currentErrorCode != QuestionActivityErrorCode.NONE
    @get:Bindable
    val error : String get() = errorMessage
}