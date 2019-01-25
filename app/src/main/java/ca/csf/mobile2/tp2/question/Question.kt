package ca.csf.mobile2.tp2.question

import org.parceler.Parcel
import org.parceler.ParcelConstructor
import java.util.*

@Parcel(Parcel.Serialization.BEAN)
data class Question @ParcelConstructor constructor(
    var id : UUID?,
    var text : String,
    var choice1 : String,
    var choice2 : String,
    var nbChoice1 : Int,
    var nbChoice2 : Int
)
{
    constructor() : this (UUID.fromString("00000000-0000-0000-0000-000000000000"), "", "", "", -1, -1)


}