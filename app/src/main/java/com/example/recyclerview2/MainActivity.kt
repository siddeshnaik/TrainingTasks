package com.example.recyclerview2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val layoutManager by lazy { LinearLayoutManager(this) }
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        layoutManager = LinearLayoutManager(this)






        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        
        adapter = RecyclerAdapter()
        recyclerView.adapter = adapter




    }
}