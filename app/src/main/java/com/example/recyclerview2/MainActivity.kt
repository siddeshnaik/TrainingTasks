package com.example.recyclerview2

import android.annotation.SuppressLint
import android.database.Cursor
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.Contacts
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview2.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val layoutManager by lazy { LinearLayoutManager(this) }
    private var adapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>? = null

    lateinit var binding: ActivityMainBinding
    lateinit var manager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        getContacts()
        val phoneContactsData: ArrayList<PhoneContactData> = getContactList()

        Log.i("ContactObj", phoneContactsData.toString())



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

            adapter = RecyclerAdapter().apply {
                setContactInfo(phoneContactsData)
            }
            layoutManager = manager

        }
    }



    @SuppressLint("Range")
    private fun getContactList(): ArrayList<PhoneContactData> {

        val phoneContactDataFunc = ArrayList<PhoneContactData>()

        val cr = contentResolver
        val cur: Cursor? = cr.query(
            Contacts.CONTENT_URI,
            null, null, null, null
        )
        if ((cur?.count ?: 0) > 0) {
            while (cur != null && cur.moveToNext()) {
                val id: String = cur.getString(
                    cur.getColumnIndex(Contacts._ID)
                )



                val name: String = cur.getString(
                    cur.getColumnIndex(
                        Contacts.DISPLAY_NAME
                    )
                )


                if (cur.getInt(
                        cur.getColumnIndex(
                            Contacts.HAS_PHONE_NUMBER
                        )
                    ) > 0
                ) {
                    val pCur: Cursor? = cr.query(
                        ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                        null,
                        ContactsContract.CommonDataKinds.Phone.CONTACT_ID + " = ?",
                        arrayOf(id),
                        null
                    )
                    if (pCur != null) {
                        while (pCur.moveToNext()) {
                            val phoneNo: String = pCur.getString(
                                pCur.getColumnIndex(
                                    ContactsContract.CommonDataKinds.Phone.NUMBER
                                )
                            )
//                            Log.i("Name", "$name")
//                            Log.i("Phone Number", "$phoneNo")
                            phoneContactDataFunc.add(PhoneContactData(name, phoneNo, id))
                        }
                    }


                    pCur?.close()


                }



            }
        }
        cur?.close()
        return phoneContactDataFunc
    }





}


