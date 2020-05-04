package com.example.gumivietnam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.android.synthetic.main.activity_show_list.*
import kotlinx.android.synthetic.main.add_message_dialog.view.*
import kotlinx.android.synthetic.main.row.*
import java.util.*

class ShowListActivity : AppCompatActivity() {
    companion object{
        val INTENT_PARCELABLE = "OBJECT_INTENT"
    }
    private val mRandom = Random()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        this.title = "Messages"

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


        btn.setOnClickListener {
            val mDialogView = LayoutInflater.from(this).inflate(R.layout.add_message_dialog, null)

            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogView)
                .setTitle("Add Message")

            val mAlertDialog = mBuilder.show()

            mDialogView.add.setOnClickListener {

                mAlertDialog.dismiss()

                val message = mDialogView.add.editText.toString()
                val des = mDialogView.des.editText.toString()

            }

            mDialogView.cancel_button.setOnClickListener {
                mAlertDialog.dismiss()
            }
            mDialogView.add_btn.setOnClickListener {

                Toast.makeText(this@ShowListActivity, " You want To add message", Toast.LENGTH_LONG).show()
            }
        }

    }
}



