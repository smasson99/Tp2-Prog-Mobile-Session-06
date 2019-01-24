package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import ca.csf.mobile2.tp2.util.ViewModelProperty
import org.parceler.Parcel
import org.parceler.ParcelConstructor
import java.util.*

enum class ActivityState(){
    SEARCH,
    SHOW,
    ERROR_SERVER,
    ERROR_CONNECTIVITY
}

@Parcel(Parcel.Serialization.BEAN)
class QuestionActivityViewModel /*@ParcelConstructor constructor*/(question : Question=Question()) : BaseObservable() {

    //var question by ViewModelProperty<Question>(Question(), this)

    fun onResume() {

    }

    fun onPause() {

    }

    @get:Bindable
    var question:Question by ViewModelProperty(Question(), this)
    @get:Bindable
    var id: UUID by ViewModelProperty(question.id,this)
    @get:Bindable
    var text:String by ViewModelProperty(question.text,this)
    @get:Bindable
    var choice1:String by ViewModelProperty(question.choice1,this)
    @get:Bindable
    var choice2:String by ViewModelProperty(question.choice2,this)
    @get:Bindable
    var nbChoice1:Int by ViewModelProperty(question.nbChoice1,this)
    @get:Bindable
    var nbChoice2:Int by ViewModelProperty(question.nbChoice2,this)
    @get:Bindable
    var activityState:ActivityState by ViewModelProperty(ActivityState.SEARCH,this)
}