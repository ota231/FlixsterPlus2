
package com.example.flixsterplus

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    //private val shows = mutableListOf<Show>()
    //private lateinit var showsRecyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val supportFragmentManager = supportFragmentManager
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.content, ShowFragment(), null).commit()

        //val showAdapter = ShowAdapter(this, shows)
        //showsRecyclerView.adapter = showAdapter
    }
}