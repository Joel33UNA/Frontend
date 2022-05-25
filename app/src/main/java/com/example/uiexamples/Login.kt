package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Login : AppCompatActivity() {

    var usuarios: Usuarios = Usuarios.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.et_user_name) as EditText
        val password = findViewById<EditText>(R.id.et_password) as EditText

        val login = findViewById<Button>(R.id.btnLoginn) as Button
        val registrarse = findViewById<Button>(R.id.btnReg) as Button
        val nuevaPass = findViewById<Button>(R.id.btnCamPass) as Button

        login.setOnClickListener{
            val user_name = username.text;
            val password = password.text;
            //Toast.makeText(this@LoginExample, user_name, Toast.LENGTH_LONG).show()
            if(usuarios.login(user_name.toString(), password.toString())){
                val bundle = Bundle()
                val login = usuarios.loginU(user_name.toString(), password.toString())
                val i = Intent(this, MenuJob::class.java)
                i.putExtra("usuario", login)
                startActivity(i)
            }else{
                Toast.makeText(this, "El usuario ${user_name.toString()} no se encuentra registrado o las credenciales son incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

        registrarse.setOnClickListener{
            startActivity(Intent(this@Login, Registrarse::class.java))
        }

        nuevaPass.setOnClickListener{
            startActivity(Intent(this@Login, CambiarPassword::class.java))
        }
    }
}