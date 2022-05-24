package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class InfoUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info_usuario)

        val persona:Usuario = intent.getSerializableExtra("usuario") as Usuario

        val nombre = findViewById<TextView>(R.id.textView7)
        val apellido = findViewById<TextView>(R.id.textView11)
        val telefono = findViewById<TextView>(R.id.textView28)
        val correo = findViewById<TextView>(R.id.textView30)
        val posicion = findViewById<TextView>(R.id.textView32)
        val usuario = findViewById<TextView>(R.id.textView9)
        val btn = findViewById<Button>(R.id.button5)

        nombre.text = persona.nombre
        apellido.text = persona.apellido
        telefono.text = persona.telefono
        correo.text = persona.correo
        posicion.text = persona.posicion
        usuario.text = persona.user

        btn.setOnClickListener{
            val intent = Intent(this, MenuJob::class.java)
            startActivity(intent)
        }
    }
}