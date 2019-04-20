package br.com.pipasdevteam.doesimples

import android.os.Bundle
import android.support.v4.app.NavUtils
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.toolbar.*

class DetailInstituicaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_instituicao)


        // colocar toolbar
        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        val params = intent.extras
        val nome = params?.getString("inst_name")
//        Toast.makeText(this, "$nome", Toast.LENGTH_SHORT).show()
        this.supportActionBar!!.title = nome
        val actionBar = supportActionBar
        actionBar!!.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)




    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_inst_detail, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item?.itemId
//        if (id == R.id.action_sair) {
//            this.finish()
//            return true
//        }
        return super.onOptionsItemSelected(item)
    }
}
