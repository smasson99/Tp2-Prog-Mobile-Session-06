package ca.csf.mobile2.tp2.question

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.util.*

private const val URL="https://m2t2.csfpwmjv.tk"

class QuestionService{

    private val service : Service

    init {
       /* val jackson = ObjectMapper()
            .registerKotlinModule()*/
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(JacksonConverterFactory.create())
            .build()

        service = retrofit.create(Service::class.java)
    }
    private interface Service {
       /* @GET("/api/v1/question/random")
        fun getRandomQuestion() : Call<>

        @GET("/api/v1/question/{id}/choose1")
        fun chooseQuestion1(@Path("id") id : Int ) : Call<>

        @GET ("/api/v1/question/{id}/choose2")
        fun chooseQuestion2(@Path("id")id : Int) : Call<>*/


    }
}