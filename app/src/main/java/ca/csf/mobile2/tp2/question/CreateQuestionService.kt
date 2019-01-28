package ca.csf.mobile2.tp2.question

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.androidannotations.annotations.Background
import org.androidannotations.annotations.EBean
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.POST
import java.io.IOException

//todo:bonne url
//private const val URL="https://m2t2.csfpwmjv.tk/"

@EBean(scope = EBean.Scope.Singleton)
class CreateQuestionService{

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

    //todo:envoyer message réussite
    @Background
    fun postQuestion(question:String, onSuccess:()->Unit,
                     onConnectivityError:()->Unit,
                     onServerError:()->Unit){
        try{
            val response=service.postQuestion(question).execute()
            if(response.isSuccessful){
                onSuccess()
            }
            else{
                onServerError()
            }
        }
        catch(e:IOException){
            onConnectivityError
        }
    }

    private interface Service {

        //todo:les paramêtres font quoi?
        @POST("/api/v1/question/{id}/choose1")
        fun postQuestion(question:String) : Call<Question>
    }
}