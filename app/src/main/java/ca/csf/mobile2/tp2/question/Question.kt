package ca.csf.mobile2.tp2.question

import org.parceler.Parcel
import org.parceler.ParcelConstructor
import java.util.*

@Parcel(Parcel.Serialization.BEAN)
data class Question(
    var id: UUID? = null,
    var text: String = "",
    var choice1: String = "",
    var choice2: String = "",
    var nbChoice1: Int = 0,
    var nbChoice2: Int = 0
)