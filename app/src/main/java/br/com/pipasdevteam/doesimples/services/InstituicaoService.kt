package br.com.pipasdevteam.doesimples.services

import android.content.ContentValues.TAG
import android.content.Context
import android.util.Log
import br.com.pipasdevteam.doesimples.AndroidUtils
import br.com.pipasdevteam.doesimples.HttpHelper
import br.com.pipasdevteam.doesimples.models.Instituicao
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.net.URL

object InstituicaoService {
    val host = "https://doesimples.ga/api"
    fun getInstituicoes(context: Context): List<Instituicao> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "$host/instituicao/"
            val json = HttpHelper.get(url)
            Log.d(TAG, json)
            val result = JSONObject(json).get("results").toString()
            return parserJson<List<Instituicao>>(result)
        } else {
            return ArrayList<Instituicao>()
        }

    }

    inline fun <reified T> parserJson(result: String): T {
        val type = object : TypeToken<T>() {}.type
        val x = Gson().fromJson<T>(result, type)
        return x
    }
}