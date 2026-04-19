package com.example.natureexplorer

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class DetailsActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val img = findViewById<ImageView>(R.id.detailImage)
        val title = findViewById<TextView>(R.id.detailTitle)
        val desc = findViewById<TextView>(R.id.detailDesc)

        title.text = intent.getStringExtra("title")
        desc.text = intent.getStringExtra("desc")
        img.setImageResource(intent.getIntExtra("image", 0))
    }
}