package br.com.pipasdevteam.doesimples

import android.app.PendingIntent.getActivity
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.Toast

class DetailInstituicaoActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_instituicao)
        val params = intent.extras
        val nome = params?.getString("inst_name")
//        Toast.makeText(this, "$nome", Toast.LENGTH_SHORT).show()
        this.supportActionBar!!.title = nome


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}
