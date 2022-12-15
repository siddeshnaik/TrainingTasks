package com.example.contactsappwithrecyclerviewcontextresolverfragments

import android.annotation.SuppressLint
import android.content.ContentUris
import android.database.Cursor
import android.net.Uri
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.ContactsContract.Contacts
import android.util.JsonWriter
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.google.gson.Gson
import org.json.JSONException
import org.json.JSONObject
import java.io.BufferedReader
import java.io.ByteArrayInputStream
import java.io.File
import java.io.IOException
import java.io.InputStream
import java.io.OutputStream
import java.io.OutputStreamWriter
import java.io.PrintWriter
import java.nio.charset.Charset
import com.example.contactsappwithrecyclerviewcontextresolverfragments.PhoneContactData as PhoneContactData1

class MainActivity : AppCompatActivity() {

    lateinit var drawerLayout: DrawerLayout

    lateinit var ContactButton: Button
    lateinit var ContactFavButton: Button

    private lateinit var pager: ViewPager
    private lateinit var tab: TabLayout
    private lateinit var bar: Toolbar

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        pager = findViewById(R.id.viewPager)
        tab = findViewById(R.id.tabs)
        bar = findViewById(R.id.toolbar)
        setSupportActionBar(bar)



        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(FragmentContacts(), "Contacts")
        adapter.addFragment(FragmentFavContact(), "Favourite Contacts")

        pager.adapter = adapter

        tab.setupWithViewPager(pager)

    }




}



