package br.com.pipasdevteam.doesimples

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast


class ListaInstituicoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_instituicoes)
        val listaInstView = findViewById<ListView>(R.id.lista_instituicoes)
        val instituicoes = listOf("Instituicao A", "Instituicao B", "Instituicao C")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, instituicoes)
        listaInstView.adapter = adapter

        listaInstView.setOnItemClickListener { parent, view, position, id ->
//            Toast.makeText(this, "Clicou em :" + " " + instituicoes[position], Toast.LENGTH_SHORT).show()
            val intent = Intent(this, DetailInstituicaoActivity::class.java)
            intent.putExtra("inst_name", instituicoes[position])
            this.startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "Clicou buscar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou configuracoes", Toast.LENGTH_LONG).show()
        }
        return super.onOptionsItemSelected(item)
    }
}
