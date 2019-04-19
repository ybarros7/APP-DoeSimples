package br.com.pipasdevteam.doesimples

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonLogin) {
            Logar()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonLogin.setOnClickListener(this)
        val imagem = findViewById<ImageView>(R.id.campo_imagem)
        imagem.setImageResource(R.drawable.doacao)
    }

    private fun Logar() {
        if (validarLogin()) {
            Toast.makeText(this, "Bem Vindo Usuario", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, HomeActivity::class.java)

            intent.putExtra("user", editUser.text.toString())
            startActivity(intent)
        } else {
            Toast.makeText(this, "Usuario/Senha invalidos", Toast.LENGTH_SHORT).show()
        }

    }

    private fun validarLogin(): Boolean {
        return editUser.text.toString() == "aluno"
                && editPassword.text.toString() == "impacta"
    }
}
