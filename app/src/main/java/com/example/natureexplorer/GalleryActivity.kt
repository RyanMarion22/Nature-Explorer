package com.example.natureexplorer

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class GalleryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gallery)

        val recycler = findViewById<RecyclerView>(R.id.recyclerView)

        val titles = listOf("Mountains", "Forest", "Lake")
        val descs = listOf("Beautiful mountains", "Green forest", "Peaceful lake")
        val images = listOf(R.drawable.nature, R.drawable.nature, R.drawable.nature)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = GalleryAdapter(titles, descs, images, this)
    }
}