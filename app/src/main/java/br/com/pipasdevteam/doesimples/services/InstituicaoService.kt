package br.com.pipasdevteam.doesimples.services

import android.content.Context
import br.com.pipasdevteam.doesimples.models.Instituicao

object InstituicaoService {
    fun getInstituicoes(context: Context): List<Instituicao> {
        val instituicoes = mutableListOf<Instituicao>()
        for (i in 1..10) {
            val inst = Instituicao()
            inst.id = i
            inst.instituicao = "Instituição $i"
            inst.bairro = "Bairro"
            inst.endereco = "Endereço $i"
            inst.lat = (i * i).toString()
            inst.lon = (i * i).toString()
            inst.foto = "https://butterflyeffectbethechange.com/wp-content/uploads/2016/01/Casa-de-Amparo.jpg"
            instituicoes.add(inst)
        }
        return instituicoes
    }
}