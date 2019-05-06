package br.com.pipasdevteam.doesimples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.ArrayAdapter
import br.com.pipasdevteam.doesimples.services.DoacaoService
import br.com.pipasdevteam.doesimples.util.NavigationItemSelected
import kotlinx.android.synthetic.main.activity_cadastrar_inst.*

class CadastrarInstActivity :  AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar_inst)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        this.supportActionBar!!.title = "Cadastro de Doações"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
        configurarListaTipo()
        configurarListaInstituicao()

        buttonCad.setOnClickListener {
            val doara = Doara()
            doara.nome = nome.text.toString()
            doara.telefone = telefone.text.toString()
            doara.instituicao = listinstituicao.selectedItem.toString().toInt()

            doara.tipo_doacao = listTipo.selectedItem.toString()
            doara.doacao = doacao.text.toString()

            taskAtualizar(doara)
        }

    }
    private fun configuraMenuLateral() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val menuLateral = findViewById<DrawerLayout>(R.id.CadastrarInstituicao)
// ícone de menu (hamburger) para mostrar o menu
        val toogle = ActionBarDrawerToggle(
            this,
            menuLateral,
            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        menuLateral.addDrawerListener(toogle)
        toogle.syncState()
        val navigationView = findViewById<NavigationView>(R.id.menu_lateral_cadastrar_instituicao)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        NavigationItemSelected(this, item)
// fecha menu depois de tratar o evento
        val drawer = findViewById<DrawerLayout>(R.id.layourMenuLateralQuemSomos)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    private fun configurarListaInstituicao(){
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf("0"))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        listinstituicao.adapter = adapter
    }

    private fun configurarListaTipo(){
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, listOf("MONEY", "PRODUCTS", "SERVICES"))
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        listTipo.adapter = adapter
    }

    private fun taskAtualizar(doara: Doara) {
        Thread {
            println("Cadastro de Doação")
            DoacaoService.save(doara)
            runOnUiThread {
                // após cadastrar, voltar para activity anterior
                finish()
            }
        }.start()
    }
}
