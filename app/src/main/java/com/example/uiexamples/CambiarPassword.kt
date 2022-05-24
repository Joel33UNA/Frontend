package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class CambiarPassword : AppCompatActivity() {

    var usuarios: Usuarios = Usuarios.instance

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cambiar_password)

        val cambiar = findViewById<Button>(R.id.btnCambiar)

        cambiar.setOnClickListener{

            val user = findViewById<EditText>(R.id.textUsu)
            val pass = findViewById<EditText>(R.id.textPassA)
            val nueva = findViewById<EditText>(R.id.textPassN)

            if(usuarios.login(user.text.toString(), pass.text.toString())){
                Usuarios.instance.cambiarContra(user.text.toString(),pass.text.toString(),nueva.text.toString())
                Toast.makeText(this, "Contraseña cambiada exitosamente para ${user.text.toString()}", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "El usuario ${user.text.toString()} no se encuentra registrado", Toast.LENGTH_SHORT).show()
            }
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}