package br.com.pipasdevteam.doesimples

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonLogin) {
            Logar()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonLogin.setOnClickListener(this)
    }

    private fun Logar() {
        if (validarLogin()) {
            Toast.makeText(this, "Bem Vindo Usuario", Toast.LENGTH_LONG).show()
        } else {
            Toast.makeText(this, "Usuario/Senha invalidos", Toast.LENGTH_LONG).show()
        }

    }

    private fun validarLogin(): Boolean {
        return editUser.text.toString() == "aluno"
                && editPassword.text.toString() == "impacta"
    }
}
