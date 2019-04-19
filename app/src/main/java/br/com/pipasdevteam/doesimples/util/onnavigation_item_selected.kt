package br.com.pipasdevteam.doesimples.util

import android.app.Activity
import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import br.com.pipasdevteam.doesimples.DetailInstituicaoActivity
import br.com.pipasdevteam.doesimples.HomeActivity
import br.com.pipasdevteam.doesimples.ListaInstituicoesActivity
import br.com.pipasdevteam.doesimples.R

fun NavigationItemSelected(Activity: Activity, item: MenuItem) {
    when (item.itemId) {
        R.id.nav_home -> {
            Toast.makeText(Activity, "Clicou na Home", Toast.LENGTH_SHORT).show()
            if (Activity.localClassName != "HomeActivity") {
                val intent = Intent(Activity, HomeActivity::class.java)
                Activity.startActivity(intent)
            }
        }
        R.id.nav_instituicoes -> {
            Toast.makeText(Activity, "Clicou Instituições", Toast.LENGTH_SHORT).show()
            if (Activity.localClassName != "ListaInstituicoesActivity") {
                val intent = Intent(Activity, ListaInstituicoesActivity::class.java)
                Activity.startActivity(intent)
            }
        }
        R.id.nav_quem_somos -> {
            Toast.makeText(Activity, "Clicou Quem Somos", Toast.LENGTH_SHORT).show()
        }
        R.id.nav_listagem_filtrada -> {
            Toast.makeText(Activity, "Clicou Listagem Filtrada", Toast.LENGTH_SHORT).show()
        }
        R.id.nav_config -> {
            Toast.makeText(Activity, "Clicou Config", Toast.LENGTH_SHORT).show()
        }
    }
}