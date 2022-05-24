package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class EditUsuario : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_usuario)

        val usuario = intent.getSerializableExtra("user") as Usuario

        val nombre = findViewById<EditText>(R.id.editTextNombre)
        val apellido = findViewById<EditText>(R.id.editTextApellido)
        val direccion = findViewById<EditText>(R.id.editTextDireccion)
        val correo = findViewById<EditText>(R.id.editTextCorreo)
        val telefono = findViewById<EditText>(R.id.editTextTelefono)
        val posicion = findViewById<EditText>(R.id.editTextPosicion)
        val fechaInicio = findViewById<EditText>(R.id.editTextFechaInicio)
        val username = findViewById<EditText>(R.id.editTextUsuario)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val rolRadioGroup = findViewById<RadioGroup>(R.id.editRadioRol)


        nombre.setText(usuario.nombre)
        apellido.setText(usuario.apellido)
        direccion.setText(usuario.direccion)
        correo.setText(usuario.correo)
        telefono.setText(usuario.telefono)
        posicion.setText(usuario.posicion)
        fechaInicio.setText(usuario.fechaInicio)
        username.setText(usuario.user)
        password.setText(usuario.password)
        rolRadioGroup.check(0)

        val actualizar = findViewById<Button>(R.id.button)
        actualizar.setOnClickListener{

            val rolRadioButton = findViewById<RadioButton>(rolRadioGroup.checkedRadioButtonId)

            val usuarioNuevo = Usuario(nombre.text.toString(), apellido.text.toString(), direccion.text.toString(), correo.text.toString(),
                telefono.text.toString(), posicion.text.toString(), fechaInicio.text.toString(), username.text.toString(),
                password.text.toString(), rolRadioButton.text.toString())
            val pos = intent.getIntExtra("position",-1)
            Usuarios.instance.editUsuario(usuarioNuevo ,pos)
            val intent = Intent(this, CrudUsuarios::class.java)
            startActivity(intent)
            Toast.makeText(this, "Usuario ${usuario.nombre} actualizado exitosamente", Toast.LENGTH_SHORT).show()
        }
    }
}