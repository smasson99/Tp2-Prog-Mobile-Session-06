package ca.csf.mobile2.tp2.question

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.androidannotations.annotations.Background
import org.androidannotations.annotations.EBean
import org.androidannotations.annotations.UiThread
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import java.io.IOException
import java.util.*

private const val URL="https://m2t2.csfpwmjv.tk/"

@EBean(scope = EBean.Scope.Singleton)
class QuestionService{

    private val service : Service

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
    fun getQuestion1(id : Int,onSuccess : (Question) -> Unit,
                     onConnectivityError : () -> Unit,
                     onServerError : () -> Unit){
        try{
            val response = service.chooseQuestion1(id).execute()
            if(response.isSuccessful){
                onSuccess(response.body()!!)
            }
            else{
                onServerError()
            }
        }
        catch (e: IOException){
            onConnectivityError()
        }

    }
    @Background
    fun getQuestion2(id : Int,onSuccess : (Question) -> Unit,
                     onConnectivityError : () -> Unit,
                     onServerError : () -> Unit){
        try{
            val response = service.chooseQuestion2(id).execute()
            if(response.isSuccessful){
                onSuccess(response.body()!!)
            }
            else{
                onServerError()
            }
        }
        catch (e: IOException){
            onConnectivityError()
        }
    }
    @Background
    fun getRandomQuestion(onSuccess : (Question) -> Unit,
                          onConnectivityError : () -> Unit,
                          onServerError : () -> Unit){

        try{
            val response = service.getRandomQuestion().execute()
            if(response.isSuccessful){
                onSuccess(response.body()!!)
            }
            else{
                onServerError()
            }
        }
        catch (e: IOException){
            onConnectivityError()
        }

    }



    private interface Service {
        @GET("/api/v1/question/random")
        fun getRandomQuestion() : Call<Question>

        @GET("/api/v1/question/{id}/choose1")
        fun chooseQuestion1(@Path("id") id : Int ) : Call<Question>

        @GET ("/api/v1/question/{id}/choose2")
        fun chooseQuestion2(@Path("id")id : Int) : Call<Question>


    }
}