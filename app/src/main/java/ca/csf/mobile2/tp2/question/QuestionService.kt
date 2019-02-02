package ca.csf.mobile2.tp2.question

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.androidannotations.annotations.Background
import org.androidannotations.annotations.EBean
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.io.IOException

private const val URL = "https://m2t2.csfpwmjv.tk/"

@EBean(scope = EBean.Scope.Singleton)
class QuestionService {

    private val service: Service

    init {
        val jackson = ObjectMapper()
            .registerKotlinModule()
        val retrofit = Retrofit.Builder()
            .baseUrl(URL)
            .addConverterFactory(JacksonConverterFactory.create(jackson))
            .build()

        service = retrofit.create(Service::class.java)
    }

    @Background
    fun postQuestion1(
        id: String, onSuccess: (Question) -> Unit,
        onConnectivityError: () -> Unit,
        onServerError: () -> Unit
    ) {
        try {
            val response = service.chooseQuestion1(id).execute()
            if (response.isSuccessful) {
                onSuccess(response.body()!!)
            } else {
                onServerError()
            }
        } catch (e: IOException) {
            onConnectivityError()
        }

    }

    @Background
    fun postQuestion2(
        id: String,
        onSuccess: (Question) -> Unit,
        onConnectivityError: () -> Unit,
        onServerError: () -> Unit
    ) {
        try {
            val response = service.chooseQuestion2(id).execute()
            if (response.isSuccessful) {
                onSuccess(response.body()!!)
            } else {
                onServerError()
            }
        } catch (e: IOException) {
            onConnectivityError()
        }
    }

    @Background
    fun getRandomQuestion(
        onSuccess: (Question) -> Unit,
        onConnectivityError: () -> Unit,
        onServerError: () -> Unit
    ) {

        try {
            val response = service.getRandomQuestion().execute()
            if (response.isSuccessful) {
                onSuccess(response.body()!!)
            } else {
                onServerError()
            }
        } catch (e: IOException) {
            onConnectivityError()
        }

    }


    private interface Service {
        @GET("/api/v1/question/random")
        fun getRandomQuestion(): Call<Question>

        @POST("/api/v1/question/{id}/choose1")
        fun chooseQuestion1(@Path("id") id: String): Call<Question>

        @POST("/api/v1/question/{id}/choose2")
        fun chooseQuestion2(@Path("id") id: String): Call<Question>
    }
}