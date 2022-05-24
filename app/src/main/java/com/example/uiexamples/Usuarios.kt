package com.example.uiexamples

class Usuarios private constructor() {
    private var usuarios: ArrayList<Usuario> = ArrayList<Usuario>()
    init{
        addUsuario(Usuario("Juan", "Perez","San José", "juan@gmail.com",
            "84752158","CEO","1/6/2022","jperez","111",
            "administrador"))
        addUsuario(Usuario("Maria", "Mata","Heredia", "maria@gmail.com",
            "60254789","Directora","5/8/2022","mmata","222",
            "administrador"))
        addUsuario(Usuario("Carlos", "Chaves","Cartago", "carlos@gmail.com",
            "71485796","Desarrollador","1/7/2022","cchaves","333",
            "standard"))
        addUsuario(Usuario("Laura", "Flores","Alajuela", "laura@gmail.com",
            "85741258","Finanzas","1/9/2022","lflores","444",
            "standard"))
    }

    private object HOLDER {
        val INSTANCE = Usuarios()
    }

    companion object {
        val instance: Usuarios by lazy {
            HOLDER.INSTANCE
        }
    }

    fun addUsuario(u: Usuario){
        usuarios?.add(u)
    }

    fun getUsuario(nombre: String): Usuario? {
        for (u: Usuario in usuarios!!){
            if(u.nombre.equals(nombre)){
                return u;
            }
        }
        return null;
    }

    fun getUsuarios(): ArrayList<Usuario>{
        return this.usuarios!!
    }

    fun login(user: String?, password: String?): Boolean{
        for(u: Usuario in usuarios!!){
            if(u.user.equals(user) && u.password.equals(password)){
                return true
            }
        }
        return false
    }

    fun loginU(user: String?, password: String?): Usuario?{
        for(u: Usuario in usuarios!!){
            if(u.user.equals(user) && u.password.equals(password)){
                return u
            }
        }
        return null
    }

    fun deleteUsuario(position: Int){
        usuarios!!.removeAt(position)
    }

    fun editUsuario(u: Usuario, position: Int){
        var aux = usuarios!!.get(position)
        aux.nombre = u.nombre
        aux.apellido = u.apellido
        aux.direccion = u.direccion
        aux.correo = u.correo
        aux.telefono = u.telefono
        aux.fechaInicio = u.fechaInicio
        aux.posicion = u.posicion
        aux.user = u.user
        aux.password = u.password
        aux.rol = u.rol
    }

    fun cambiarContra(userr: String, passw: String, nuevaa: String){
        var aux = loginU(userr,passw)
        if (aux != null) {
            aux.password = nuevaa
        }
    }
}