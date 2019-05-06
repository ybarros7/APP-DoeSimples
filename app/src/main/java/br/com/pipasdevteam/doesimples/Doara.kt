package br.com.pipasdevteam.doesimples

import com.google.gson.GsonBuilder
import java.io.Serializable

class Doara : Serializable{
    var nome = ""
    var telefone = ""
    var instituicao = 0
    var tipo_doacao = ""
    var doacao = ""

    override fun toString(): String {
        return "Disciplina(nome='$nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}