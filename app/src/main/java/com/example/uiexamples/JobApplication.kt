package com.example.uiexamples

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class JobApplication : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_job_application)

        val usuario: Usuario = intent.getSerializableExtra("usuario") as Usuario

        val textViewNombre = findViewById<TextView>(R.id.textView20)
        val textViewApellido = findViewById<TextView>(R.id.textView21)
        val textViewDireccion = findViewById<TextView>(R.id.textView22)
        val textViewCorreo = findViewById<TextView>(R.id.textView23)
        val textViewTelefono = findViewById<TextView>(R.id.textView24)
        val textViewPosicion = findViewById<TextView>(R.id.textView25)
        val textViewFecha = findViewById<TextView>(R.id.textView26)
        val volver = findViewById<Button>(R.id.button2)

        textViewNombre.text = usuario.nombre
        textViewApellido.text = usuario.apellido
        textViewDireccion.text = usuario.direccion
        textViewCorreo.text = usuario.correo
        textViewTelefono.text = usuario.telefono
        textViewPosicion.text = usuario.posicion
        textViewFecha.text = usuario.fechaInicio
        volver.setOnClickListener{
            val intent = Intent(this, MenuJob::class.java)
            intent.putExtra("usuario", usuario)
            startActivity(intent)
        }
    }
}