package br.com.pipasdevteam.doesimples.services

import br.com.pipasdevteam.doesimples.Doara
import br.com.pipasdevteam.doesimples.HttpHelper
import br.com.pipasdevteam.doesimples.Response
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object DoacaoService {

    //TROQUE PELA URL DE ONDE ESTÁ O WS
    // Veja um exemplo no repositório https://github.com/fesousa/aula-android-kotlin-api
    val host = "https://doesimples.ga"
    val TAG = "WS_CadDoacao"

    fun save(doara: Doara): Response {
        val json = HttpHelper.post(
            "$host/api/doacao_outros",
            doara.toJson()
        )
        return parserJson(json)
    }

    inline fun <reified T> parserJson(json: String): T {
        val type = object : TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}