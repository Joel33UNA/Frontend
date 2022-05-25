package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Registrarse : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrarse)

        val registrar = findViewById<Button>(R.id.btnRegistrarseS)
        registrar.setOnClickListener{
            val nombre = findViewById<EditText>(R.id.textNombreS)
            val apellido = findViewById<EditText>(R.id.textApellidoS)
            val direccion = findViewById<EditText>(R.id.textDireccionS)
            val correo = findViewById<EditText>(R.id.textCorreoS)
            val telefono = findViewById<EditText>(R.id.textTelefonoS)
            val posicion = findViewById<EditText>(R.id.textPosicionS)
            val fechaInicio = findViewById<EditText>(R.id.textFechaS)
            val username = findViewById<EditText>(R.id.textUsuarioS)
            val password = findViewById<EditText>(R.id.textPasswordS)

            val usuario = Usuario(nombre.text.toString(), apellido.text.toString(), direccion.text.toString(),
                correo.text.toString(), telefono.text.toString(), posicion.text.toString(),
                fechaInicio.text.toString(), username.text.toString(), password.text.toString(), "standard")
            Usuarios.instance.addUsuario(usuario)
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
            Toast.makeText(this, "El usuario ${usuario.nombre} registrado exitosamente", Toast.LENGTH_SHORT).show()

        }

    }
}