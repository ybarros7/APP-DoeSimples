package br.com.pipasdevteam.doesimples

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.SearchView
import android.widget.Toast
import java.util.*
import kotlin.concurrent.schedule


class ListaInstituicoesActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_instituicoes)

        //Navigation Drawer
        configuraMenuLateral()

        //Lista
        val listaInstView = findViewById<ListView>(R.id.lista_instituicoes)
        val instituicoes = listOf(
            "Instituicao A",
            "Instituicao B",
            "Instituicao C",
            "Instituicao A",
            "Instituicao B",
            "Instituicao C",
            "Instituicao A",
            "Instituicao B",
            "Instituicao C",
            "Instituicao A",
            "Instituicao B",
            "Instituicao C",
            "Instituicao A",
            "Instituicao B",
            "Instituicao C",
            "Instituicao A",
            "Instituicao B",
            "Instituicao C",
            "Instituicao A",
            "Instituicao B",
            "Instituicao C"
        )
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, instituicoes)

        listaInstView.adapter = adapter
        listaInstView.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, DetailInstituicaoActivity::class.java)
            intent.putExtra("inst_name", instituicoes[position])
            this.startActivity(intent)
        }


    }

    private fun configuraMenuLateral() {
        var toolbar = findViewById<Toolbar>(R.id.toolbar)
        var menuLateral = findViewById<DrawerLayout>(R.id.layourMenuLateral)
// ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(
            this,
            menuLateral,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        menuLateral.addDrawerListener(toogle)
        toogle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.menu_lateral)
        navigationView.setNavigationItemSelectedListener(this)
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

        if (id == R.id.action_atualizar) {
            fakeDialog()
        } else if (id == R.id.action_config) {
            val intent = Intent(this, SettingsActivity::class.java)
            this.startActivity(intent)
            return true
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_instituicoes -> {
                Toast.makeText(this, "Clicou Instituições", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_quem_somos -> {
                Toast.makeText(this, "Clicou Quem Somos", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_listagem_filtrada -> {
                Toast.makeText(this, "Clicou Listagem Filtrada", Toast.LENGTH_SHORT).show()
            }
            R.id.nav_config -> {
                Toast.makeText(this, "Clicou Config", Toast.LENGTH_SHORT).show()
            }
        }
// fecha menu depois de tratar o evento
        val drawer = findViewById<DrawerLayout>(R.id.layourMenuLateral)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
