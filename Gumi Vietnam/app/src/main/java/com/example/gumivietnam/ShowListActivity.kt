package com.example.gumivietnam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_show_list.*
import java.text.FieldPosition

class ShowListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        val arrayList = ArrayList<Model>()


        arrayList.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        arrayList.add(Model("The weather today is so bad", "You should bring raincoat or umbrella", R.drawable.email))
        arrayList.add(Model("The weather is so good", "Have a nice day!!!", R.drawable.email))
        arrayList.add(Model("Notification From Company", "Don't forget to check health care today!", R.drawable.email))
        arrayList.add(Model("Notification From Mr. Gumi", "Take a day off", R.drawable.email))
        arrayList.add(Model("Notification From Speech list", "Dont forget speech today", R.drawable.email))
        arrayList.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        arrayList.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        arrayList.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        arrayList.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        arrayList.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        arrayList.add(Model("Notification From Company", "Take a day off", R.drawable.email))

        val myAdapter = MyAdapter(arrayList, this)

        recyclerView.layoutManager = LinearLayoutManager( this)
        recyclerView.adapter = myAdapter


        fun onItemClick(model: Model, position: Int) {

            val intent = Intent(this@ShowListActivity, InfoActivity::class.java )

            intent.putExtra("TITLE", model.title)
            intent.putExtra("DESCRIPTION", model.des)
            intent.putExtra("IMAGE", model.image)

        }

    }
}
