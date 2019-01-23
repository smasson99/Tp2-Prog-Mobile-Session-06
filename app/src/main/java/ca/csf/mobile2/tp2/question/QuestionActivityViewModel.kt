package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import ca.csf.mobile2.tp2.util.ViewModelProperty
import org.parceler.Parcel
import org.parceler.ParcelConstructor

enum class ActivityState(){
    SEARCH,
    SHOW,
    ERROR_SERVER,
    ERROR_CONNECTIVITY
}

@Parcel(Parcel.Serialization.BEAN)
class QuestionActivityViewModel @ParcelConstructor constructor(question : Question?) : BaseObservable() {

    //var question by ViewModelProperty<Question>(Question(), this)

    fun onResume() {

    }

    fun onPause() {

    }

    @get:Bindable
    var question:Question? by ViewModelProperty(question,this)
    @get:Bindable
    var activityState:ActivityState by ViewModelProperty(ActivityState.SEARCH,this)
    /*@get:Bindable
    val text get() = question.text*/
}