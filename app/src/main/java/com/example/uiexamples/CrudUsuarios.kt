package com.example.uiexamples

import android.content.Intent
import android.graphics.Canvas
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.widget.SearchView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import it.xabaras.android.recyclerview.swipedecorator.RecyclerViewSwipeDecorator

import java.util.*

class CrudUsuarios : AppCompatActivity() {
    private var usuarios : Usuarios = Usuarios.instance
    private lateinit var lista : RecyclerView
    private lateinit var adaptador : RecyclerView_Adapter
    private lateinit var usuario : Usuario
    private var position: Int = 0
    private var archived = ArrayList<Usuario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crud_usuarios)
        val searchIcon = findViewById<ImageView>(R.id.search_mag_icon)
        searchIcon.setColorFilter(Color.BLACK)
        val cancelIcon = findViewById<ImageView>(R.id.search_close_btn)
        cancelIcon.setColorFilter(Color.BLACK)
        val textView = findViewById<TextView>(R.id.search_src_text)
        textView.setTextColor(Color.BLACK)

        lista = findViewById(R.id.lista)
        lista.layoutManager = LinearLayoutManager(lista.context)
        lista.setHasFixedSize(true)

        findViewById<SearchView>(R.id.person_search).setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                adaptador.filter.filter(newText)
                return false
            }
        })

        getUsuarios()

        val itemTouchHelperCallback = object : ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.START or ItemTouchHelper.END, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
                val fromPosition: Int = viewHolder.adapterPosition
                val toPosition: Int = target.adapterPosition

                Collections.swap(usuarios.getUsuarios(), fromPosition, toPosition)

                lista.adapter?.notifyItemMoved(fromPosition, toPosition)

                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {

                position = viewHolder.adapterPosition

                /*nombre:String, apellido:String, direccion:String, correo:String,
                telefono:String, posicion:String, fechaInicio:String, user:String,
                password:String, rol:String*/

                if(direction == ItemTouchHelper.LEFT){
                    usuario = Usuario(usuarios.getUsuarios()[position].nombre, usuarios.getUsuarios()[position].apellido, usuarios.getUsuarios()[position].direccion,
                        usuarios.getUsuarios()[position].correo, usuarios.getUsuarios()[position].telefono, usuarios.getUsuarios()[position].posicion,
                        usuarios.getUsuarios()[position].fechaInicio, usuarios.getUsuarios()[position].user, usuarios.getUsuarios()[position].password,
                        usuarios.getUsuarios()[position].rol)
                    usuarios.deleteUsuario(position)
                    lista.adapter?.notifyItemRemoved(position)
                    adaptador = RecyclerView_Adapter(usuarios.getUsuarios())
                    lista.adapter = adaptador

                }else{
                    usuario = Usuario(usuarios.getUsuarios()[position].nombre, usuarios.getUsuarios()[position].apellido, usuarios.getUsuarios()[position].direccion,
                        usuarios.getUsuarios()[position].correo, usuarios.getUsuarios()[position].telefono, usuarios.getUsuarios()[position].posicion,
                        usuarios.getUsuarios()[position].fechaInicio, usuarios.getUsuarios()[position].user, usuarios.getUsuarios()[position].password,
                        usuarios.getUsuarios()[position].rol)
                    archived.add(usuario)
                    lista.adapter?.notifyItemChanged(position)
                    adaptador = RecyclerView_Adapter(usuarios.getUsuarios())
                    lista.adapter = adaptador
                    val intent = Intent(this@CrudUsuarios, EditUsuario::class.java)
                    intent.putExtra("position",position)
                    startActivity(intent)
                }
            }

            override fun onChildDraw(c: Canvas, recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, dX: Float, dY: Float, actionState: Int, isCurrentlyActive: Boolean) {

                RecyclerViewSwipeDecorator.Builder(this@CrudUsuarios, c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
                    .addSwipeLeftBackgroundColor(ContextCompat.getColor(this@CrudUsuarios, R.color.red))
                    .addSwipeLeftActionIcon(R.drawable.ic_baseline_delete_24)
                    .addSwipeRightBackgroundColor(ContextCompat.getColor(this@CrudUsuarios, R.color.green))
                    .addSwipeRightActionIcon(R.drawable.ic_baseline_edit_24)
                    .create()
                    .decorate()
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive)
            }

        }

        val itemTouchHelper = ItemTouchHelper(itemTouchHelperCallback)
        itemTouchHelper.attachToRecyclerView(lista)

        val add: FloatingActionButton = findViewById(R.id.add)
        add.setOnClickListener {
            startActivity(Intent(this@CrudUsuarios, RegistrarUsuario::class.java))
        }
    }

    private fun getUsuarios(){
        val usuariosAux = usuarios.getUsuarios()
        adaptador = RecyclerView_Adapter(usuariosAux)
        lista.adapter = adaptador
    }
}