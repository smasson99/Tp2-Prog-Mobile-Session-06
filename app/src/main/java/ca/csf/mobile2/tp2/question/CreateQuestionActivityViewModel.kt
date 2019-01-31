package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import org.parceler.Parcel
import ca.csf.mobile2.tp2.util.ViewModelProperty

@Parcel(Parcel.Serialization.BEAN)
class CreateQuestionActivityViewModel : BaseObservable() {

    @get:Bindable
    @set:Bindable
    var questionText: String by ViewModelProperty("", this)

    @get:Bindable
    @set:Bindable
    var choice1: String by ViewModelProperty("", this)

    @get:Bindable
    @set:Bindable
    var choice2: String by ViewModelProperty("", this)

}