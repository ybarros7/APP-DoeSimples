package br.com.pipasdevteam.doesimples

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule
import android.support.v4.view.MenuItemCompat.getActionView
import android.widget.SearchView


class ListaInstituicoesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_instituicoes)

        //Lista
        val listaInstView = findViewById<ListView>(R.id.lista_instituicoes)
        val instituicoes = listOf("Instituicao A", "Instituicao B", "Instituicao C")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, instituicoes)

        listaInstView.adapter = adapter
        listaInstView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailInstituicaoActivity::class.java)
            intent.putExtra("inst_name", instituicoes[position])
            this.startActivity(intent)
        }


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        val searchView = menu!!.findItem(R.id.action_buscar).actionView as SearchView
        //Define um texto de ajuda:
        searchView.queryHint = "teste"

        // exemplos de utilização:
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                Toast.makeText(this@ListaInstituicoesActivity, "Buscou por : $query", Toast.LENGTH_SHORT).show()
                return false
            }

        })
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(this, "", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_atualizar) {
            fakeDialog()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou configuracoes", Toast.LENGTH_LONG).show()
        } else if (id == R.id.action_exit) {
            this.finish()
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    private fun fakeDialog() {
        val msg = "Atualizando a lista de instituições ...."
        val dialog = ProgressDialog.show(this, "Aguarde", msg, true, true)
        Timer().schedule(5000) {
            dialog.dismiss()

        }
    }
}
