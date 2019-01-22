package ca.csf.mobile2.tp2.question

import java.util.*

data class Question(
    var id : UUID,
    var text : String,
    var choice1 : String,
    var choice2 : String,
    var nbChoice1 : Int,
    var nbChoice2 : Int
)