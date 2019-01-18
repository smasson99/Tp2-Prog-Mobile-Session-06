package ca.csf.mobile2.tp2.question

import retrofit2.Call
import retrofit2.http.GET

class QuestionService{

    private interface Service {
        @GET("/api/v1/question/random")
        fun getRandomQuestion() : Call<ArrayList<String>>
    }
}