package com.example.contentreciverapp

import android.annotation.SuppressLint
import android.database.sqlite.SQLiteDatabase
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Recycler

class MainActivity : AppCompatActivity() {

    var CONTENT_URI = Uri.parse("content://com.example.customcontentprovider/SIDDESH")


    private val layoutManger by lazy { LinearLayout(this) }
    private var adapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    lateinit var manager: RecyclerView.LayoutManager
    lateinit var recyclerView: RecyclerView



    @SuppressLint("SuspiciousIndentation", "Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)









        recyclerViewFunc()









    }

    override fun onResume() {
        super.onResume()
        recyclerViewFunc()
    }


    private fun recyclerViewFunc(){
        manager = LinearLayoutManager(this)

        recyclerView.apply {
            adapter=RecyclerAdapter().apply {
                setDbData(dbDataContent())
            }
            layoutManager=manager
        }
    }


    @SuppressLint("Range")
    private fun dbDataContent(): ArrayList<SiddeshDbDataClass>{

        val dbDataArray = ArrayList<SiddeshDbDataClass>()
        val cursor = contentResolver.query(CONTENT_URI, null, null, null, null)

        if(cursor!=null && cursor?.count?:0 >0){
            while (cursor!= null && cursor.moveToNext()){
                val name: String = cursor.getString(cursor.getColumnIndex("NAME"))

                val meaning: String = cursor.getString(cursor.getColumnIndex("MEANING"))

                dbDataArray.add(SiddeshDbDataClass(name, meaning))

                Log.i("Siddesh", dbDataArray[0].dbDataMeaning)


            }



        }else{
            Toast.makeText(this, "No Data Available in DB", Toast.LENGTH_LONG).show()
        }

        return dbDataArray


        cursor?.close()

    }

}

