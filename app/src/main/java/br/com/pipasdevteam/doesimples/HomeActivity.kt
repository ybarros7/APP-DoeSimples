package br.com.pipasdevteam.doesimples

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import br.com.pipasdevteam.doesimples.util.NavigationItemSelected
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    override fun onClick(view: View?) {

        val id = view?.id
        if (id == R.id.buttonListInst) {
            val intent = Intent(this, ListaInstituicoesActivity::class.java)
            this.startActivity(intent)
        }
        if (id == R.id.buttonCadInst) {
            val intent = Intent(this, CadastrarInstActivity::class.java)
            this.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        val imagem = findViewById<ImageView>(R.id.logo_doe_simples)
        imagem.setImageResource(R.drawable.doe_simples_logo)

        buttonListInst.setOnClickListener(this)
        buttonCadInst.setOnClickListener(this)
    }

    private fun configuraMenuLateral() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val menuLateral = findViewById<DrawerLayout>(R.id.layoutMenuLateralHome)
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
        val navigationView = findViewById<NavigationView>(R.id.menu_lateral_home)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        NavigationItemSelected(this, item)
// fecha menu depois de tratar o evento
        val drawer = findViewById<DrawerLayout>(R.id.layoutMenuLateralHome)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
