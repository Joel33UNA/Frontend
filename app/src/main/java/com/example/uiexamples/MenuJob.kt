package com.example.uiexamples


import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.google.android.material.snackbar.Snackbar


class MenuJob : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener  {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var l : Usuario

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu_job)

        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        val bundle = intent.extras
        l =  bundle?.getSerializable("usuario") as Usuario

        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_info
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
        navView.setNavigationItemSelectedListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_example, menu)

        var navigationView = findViewById<NavigationView>(R.id.nav_view);
        var  nav_Menu = navigationView.getMenu();
        if(l.rol=="standard")
            nav_Menu.findItem(R.id.usuarios).setVisible(false)

        return true
    }


    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var i: Intent? = null
        when (item.itemId){
            R.id.nav_info -> {
                val bundle = intent.extras
                l =  bundle?.getSerializable("usuario") as Usuario
                if(l.rol == "administrador"){
                    i = Intent(this, InfoUsuario::class.java)
                }else{
                    i = Intent(this, JobApplication::class.java)
                }
                i.putExtra("usuario",l)
                startActivity(i)
            }
            R.id.usuarios -> {

                    startActivity(Intent(this, CrudUsuarios::class.java))

            }
            R.id.logout -> {
                val i = Intent(this, Login::class.java)
                finish()
                startActivity(i)
            }
        }
        return true
    }
    override fun onBackPressed() {
        val fragments = supportFragmentManager.backStackEntryCount
        if (fragments == 1) {
            finish()
            return
        }
        super.onBackPressed()
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}