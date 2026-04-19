package com.example.natureexplorer

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val drawerLayout = findViewById<DrawerLayout>(R.id.main)
        val toolbar = findViewById<MaterialToolbar>(R.id.toolbar)
        val navView = findViewById<NavigationView>(R.id.navigation_view)

        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
            toolbar,
            0,
            0
        )

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_home -> Toast.makeText(this, "Home clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_gallery -> Toast.makeText(this, "Gallery clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_favorites -> Toast.makeText(this, "Favorites clicked", Toast.LENGTH_SHORT).show()
                R.id.nav_settings -> Toast.makeText(this, "Settings clicked", Toast.LENGTH_SHORT).show()
            }
            drawerLayout.closeDrawers()
            true
        }
    }
}