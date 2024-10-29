package com.example.myapplication


import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

private val adapter = MyAdapter()

class MyActivity : AppCompatActivity() {

    lateinit var recyclerView : RecyclerView
    lateinit var fab : FloatingActionButton
    lateinit var fab2 : FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        recyclerView = findViewById(R.id.recycle_view)
        fab = findViewById(R.id.fab)
        fab2 = findViewById(R.id.fab2)
        recyclerView.adapter = adapter

        fab.setOnClickListener {
            adapter.addItem(adapter.itemCount + 1)
        }

        fab2.setOnClickListener {
            adapter.delItem(adapter.itemCount - 1)
        }

        if (savedInstanceState == null) {
            adapter.setItem(listOf())
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
    }
}