package br.com.pipasdevteam.doesimples.util

import android.app.Activity
import android.content.Intent
import android.view.MenuItem
import android.widget.Toast
import br.com.pipasdevteam.doesimples.*

fun NavigationItemSelected(context: Activity, item: MenuItem) {
    when (item.itemId) {
        R.id.nav_home -> {
//            Toast.makeText(context, "Clicou na Home", Toast.LENGTH_SHORT).show()
            if (context.localClassName != "HomeActivity") {
                val intent = Intent(context, HomeActivity::class.java)
                context.startActivity(intent)
            }
        }
        R.id.nav_instituicoes -> {
//            Toast.makeText(context, "Clicou Instituições", Toast.LENGTH_SHORT).show()
            if (context.localClassName != "ListaInstituicoesActivity") {
                val intent = Intent(context, ListaInstituicoesActivity::class.java)
                context.startActivity(intent)
            }
        }
        R.id.nav_quem_somos -> {
            Toast.makeText(context, "Clicou Quem Somos", Toast.LENGTH_SHORT).show()
            if (context.localClassName != "QuemSomosActivity") {
                val intent = Intent(context, QuemSomosActivity::class.java)
                context.startActivity(intent)
            }
        }
        R.id.nav_listagem_filtrada -> {
//            Toast.makeText(context, "Clicou Listagem Filtrada", Toast.LENGTH_SHORT).show()
            if (context.localClassName != "FilterInstituicao") {
                val intent = Intent(context, FilterInstituicao::class.java)
                context.startActivity(intent)
            }
        }
        R.id.nav_config -> {
//            Toast.makeText(context, "Clicou Config", Toast.LENGTH_SHORT).show()
            if (context.localClassName != "SettingsActivity") {
                val intent = Intent(context, SettingsActivity::class.java)
                context.startActivity(intent)
            }
        }
        R.id.nav_exit -> {
//            Toast.makeText(context, "Clicou Sair", Toast.LENGTH_SHORT).show()
            val intent = Intent(context, LoginActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
            context.startActivity(intent)
        }
    }
}