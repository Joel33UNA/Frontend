package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup

class RegistrarUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registrar_usuario)

        val registrar = findViewById<Button>(R.id.btnRegistrarse)

        registrar.setOnClickListener{
            val nombre = findViewById<EditText>(R.id.textNombre)
            val apellido = findViewById<EditText>(R.id.textApellido)
            val direccion = findViewById<EditText>(R.id.textDireccion)
            val correo = findViewById<EditText>(R.id.textCorreo)
            val telefono = findViewById<EditText>(R.id.textTelefono)
            val posicion = findViewById<EditText>(R.id.textPosicion)
            val fechaInicio = findViewById<EditText>(R.id.textFecha)
            val username = findViewById<EditText>(R.id.textUsuario)
            val password = findViewById<EditText>(R.id.textPassword)
            val rolRadioGroup = findViewById<RadioGroup>(R.id.editRadioRol)
            val rolRadioButton = findViewById<RadioButton>(rolRadioGroup.checkedRadioButtonId)

            val usuario = Usuario(nombre.text.toString(), apellido.text.toString(), direccion.text.toString(),
                correo.text.toString(), telefono.text.toString(), posicion.text.toString(),
                fechaInicio.text.toString(), username.text.toString(), password.text.toString(), rolRadioButton.text.toString())
            Usuarios.instance.addUsuario(usuario)
            val intent = Intent(this, Login::class.java)
            startActivity(intent)
        }
    }
}