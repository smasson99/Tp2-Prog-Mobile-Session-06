package ca.csf.mobile2.tp2.question

import android.databinding.BaseObservable
import android.databinding.Bindable
import org.parceler.Parcel
import org.parceler.ParcelConstructor
import ca.csf.mobile2.tp2.R
import ca.csf.mobile2.tp2.util.ViewModelProperty

@Parcel(Parcel.Serialization.BEAN)
class CreateQuestionActivityViewModel @ParcelConstructor constructor() : BaseObservable() {

    @get:Bindable
    @set:Bindable
    var questionText:String by ViewModelProperty("",this)
}