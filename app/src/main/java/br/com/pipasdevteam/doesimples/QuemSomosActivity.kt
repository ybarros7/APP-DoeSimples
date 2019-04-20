package br.com.pipasdevteam.doesimples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import br.com.pipasdevteam.doesimples.util.NavigationItemSelected

class QuemSomosActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quem_somos)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        this.supportActionBar!!.title = "Quem Somos"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()
    }

    private fun configuraMenuLateral() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val menuLateral = findViewById<DrawerLayout>(R.id.layourMenuLateralQuemSomos)
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
        val navigationView = findViewById<NavigationView>(R.id.menu_lateral_quem_somos)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        NavigationItemSelected(this, item)
// fecha menu depois de tratar o evento
        val drawer = findViewById<DrawerLayout>(R.id.layourMenuLateralQuemSomos)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }
}
