package com.example.gumivietnam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.View
import android.widget.AdapterView
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_show_list.*

class ShowListActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        val modelList = listOf<Model>(
            Model("Notification From Company", "Take a day off", R.drawable.email),
            Model("The weather today is so bad", "You should bring raincoat or umbrella", R.drawable.email),
            Model("The weather is so good", "Have a nice day!!!", R.drawable.email),
            Model("Notification From Company", "Don't forget to check health care today!", R.drawable.email),
            Model("Notification From Mr. Gumi", "Take a day off", R.drawable.email),
            Model("Notification From Speech list", "Dont forget speech today", R.drawable.email),
            Model("Notification From Company", "Take a day off", R.drawable.email),
            Model("Notification From Company", "Take a day off", R.drawable.email),
            Model("Notification From Company", "Take a day off", R.drawable.email),
            Model("Notification From Company", "Take a day off", R.drawable.email),
            Model("Notification From Company", "Take a day off", R.drawable.email),
            Model("Notification From Company", "Take a day off", R.drawable.email)
        )

        val recyclerView = findViewById<RecyclerView>(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MyAdapter(this, modelList){
            val intent = Intent(this, InfoActivity::class.java)
            intent.putExtra(INTENT_PARCELABLE, it)
            startActivity(intent)
        }
    }
}

