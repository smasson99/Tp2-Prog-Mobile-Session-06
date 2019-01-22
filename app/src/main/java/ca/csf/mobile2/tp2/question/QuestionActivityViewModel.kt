package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import ca.csf.mobile2.tp2.util.ViewModelProperty
import org.parceler.Parcel
import org.parceler.ParcelConstructor

@Parcel(Parcel.Serialization.BEAN)
class QuestionActivityViewModel @ParcelConstructor constructor(var question : Question) : BaseObservable() {

    //var question by ViewModelProperty<Question>(Question(), this)

    fun onResume() {

    }

    fun onPause() {

    }

    @get:Bindable
    val text get() = question.text
}