package com.example.recyclerview2

import android.annotation.SuppressLint
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.Contacts
import android.util.Log
import android.view.LayoutInflater
import androidx.annotation.RequiresApi
import androidx.core.content.ContextCompat
import androidx.core.content.PackageManagerCompat
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.databinding.ActivityMainBinding
import java.util.jar.Manifest

class MainActivity : AppCompatActivity() {

    private val layoutManager by lazy { LinearLayoutManager(this) }
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    lateinit var binding: ActivityMainBinding
    lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        getContacts()


//        setContentView(R.layout.activity_main)

//        layoutManager = LinearLayoutManager(this)

//        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
//        recyclerView.layoutManager = layoutManager
//
//        adapter = RecyclerAdapter()
//        recyclerView.adapter = adapter

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        manager = LinearLayoutManager(this)

        binding.recyclerView.apply {

            adapter = RecyclerAdapter()
            layoutManager = manager

        }
    }

    @SuppressLint("Range")
    fun getContacts(){




        val cursor = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null)

//        val dataTransferMap = HashMap<>
        if(cursor!=null && cursor.moveToFirst())
            do{
                val name= cursor.getString(cursor.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME))
                val name1 = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME))
                val number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))
//
//
//                val contactList : MutableList<String> = ArrayList()

                Log.i("getContacts", "name : $number")





            }while (cursor.moveToNext())
        cursor?.close()
    }





}