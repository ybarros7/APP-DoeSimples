package br.com.pipasdevteam.doesimples.models

import java.io.Serializable

class Instituicao : Serializable {
    var id:Int = 0
    var instituicao = ""
    var endereco = ""
    var bairro = ""
    var lat_long = ""
    var foto = ""

    override fun toString(): String {
        return instituicao
    }
}