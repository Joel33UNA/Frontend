package com.example.uiexamples

import java.io.Serializable


class Usuario : Serializable {
    var nombre:String = ""
    var apellido:String=""
    var direccion:String=""
    var correo:String=""
    var telefono:String=""
    var posicion:String=""
    var fechaInicio:String=""
    var user:String = ""
    var password:String = ""
    var rol:String = ""

    internal constructor(nombre:String, apellido:String, direccion:String, correo:String,
                         telefono:String, posicion:String, fechaInicio:String, user:String,
                         password:String, rol:String){
        this.nombre = nombre
        this.apellido = apellido
        this.direccion = direccion
        this.correo = correo
        this.telefono = telefono
        this.posicion = posicion
        this.fechaInicio = fechaInicio
        this.user = user
        this.password = password
        this.rol = rol
    }
}