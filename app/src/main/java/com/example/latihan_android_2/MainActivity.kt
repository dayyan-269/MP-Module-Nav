package com.example.latihan_android_2

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var topBar: MaterialToolbar
    private lateinit var drawer: DrawerLayout
    private lateinit var navigation: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        topBar = findViewById(R.id.topbar)
        drawer = findViewById(R.id.drawer)
        navigation = findViewById(R.id.navigation)

        topBar.setNavigationOnClickListener {
            drawer.open()
        }

        navigation.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true
            drawer.close()
            true
        }
    }

    override fun onClick(v: View?) {

    }
}