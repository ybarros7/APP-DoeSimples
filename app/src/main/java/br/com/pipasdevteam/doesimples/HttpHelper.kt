package br.com.pipasdevteam.doesimples

import android.util.Log
import com.google.gson.Gson
import okhttp3.MediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import org.json.JSONArray
import org.json.JSONObject
import java.io.IOException

object HttpHelper {

    private val TAG = "HTTP_LMSApp"
    private val LOG_ON = true
    val JSON = MediaType.parse("application/json; charset=utf-8")

    var client = OkHttpClient()

    // GET
    fun get(url: String): String {
        Log.d(TAG, "HttpHelper.get: $url")
        val request = Request.Builder().url(url).get().build()
        return getJson(request)
    }

    // POST JSON
    fun post(url: String, json: String): String {
        Log.d(TAG, "HttpHelper.post: $url > $json")
        val body = RequestBody.create(JSON, json)
        val request = Request.Builder().url(url).post(body).build()
        return getJson(request)
    }

    // DELETE
    fun delete(url: String): String {
        Log.d(TAG, "HttpHelper.delete: $url")
        val request = Request.Builder().url(url).delete().build()
        return getJson(request)
    }


    // Lê resposta em formato JSON
    private fun getJson(request: Request?): String {
        val response = client.newCall(request).execute()
        val body = response.body()
        if (body != null) {
            val json = body.string()
            Log.d(TAG, "  << : $json")
            val result = JSONObject(json).get("results").toString()
            return result
        }
        throw IOException("Erro na requisição")
    }
}