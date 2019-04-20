package br.com.pipasdevteam.doesimples

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import br.com.pipasdevteam.doesimples.util.NavigationItemSelected

class FilterInstituicao : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_filter_instituicao)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()


    }

    private fun configuraMenuLateral() {
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        val menuLateral = findViewById<DrawerLayout>(R.id.layourMenuLateralFilterInst)
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
        val navigationView = findViewById<NavigationView>(R.id.menu_lateral_filter_inst)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        NavigationItemSelected(this, item)
// fecha menu depois de tratar o evento
        val drawer = findViewById<DrawerLayout>(R.id.layourMenuLateralFilterInst)
        drawer.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onClick(view: View?) {
        val id = view?.id
//        if (id == R.id.buttonFilterInst) {
//            Toast.makeText(this, "Filtrar Instituicao", Toast.LENGTH_SHORT).show()
//        }
    }


}
