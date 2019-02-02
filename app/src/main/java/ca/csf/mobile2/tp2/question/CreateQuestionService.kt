package ca.csf.mobile2.tp2.question

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.registerKotlinModule
import org.androidannotations.annotations.Background
import org.androidannotations.annotations.EBean
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.Body
import retrofit2.http.POST
import java.io.IOException

private const val URL = "https://m2t2.csfpwmjv.tk/"

@EBean(scope = EBean.Scope.Singleton)
class CreateQuestionService {

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
    fun postQuestion(
        question: Question,
        onSuccess: () -> Unit,
        onConnectivityError: () -> Unit,
        onServerError: () -> Unit
    ) {
        try {
            //crash à cette ligne, erreur inconnue après des heures de recherche
            val response = service.postQuestion(question).execute()
            if (response.isSuccessful) {
                onSuccess()
            } else {
                onServerError()
            }
        } catch (e: IOException) {
            onConnectivityError()
        }
    }

    private interface Service {
        @POST("/api/v1/question")
        fun postQuestion(@Body question: Question): Call<Question>
    }
}