package com.example.gumivietnam

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_show_list.*
import kotlinx.android.synthetic.main.add_message_dialog.view.*
import kotlinx.android.synthetic.main.row.*
import kotlinx.android.synthetic.main.row.view.*
import kotlinx.android.synthetic.main.row.view.company
import java.util.*

class ShowListActivity : AppCompatActivity() {
    companion object{
        const val INTENT_PARCELABLE = "OBJECT_INTENT"
    }

    private val Models : ArrayList<Model> = ArrayList()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_list)

        this.title = "Messages"

        addModel()

        val recyclerView = findViewById<RecyclerView>(R.id.recycle)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)
        recyclerView.adapter = MyAdapter(items = Models, context = this){
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

            mDialogView.cancel_button.setOnClickListener {
                mAlertDialog.dismiss()
            }
            mDialogView.add_btn.setOnClickListener {
                mAlertDialog.dismiss()
                val message = mDialogView?.add?.text.toString()
                val des = mDialogView?.des?.text.toString()
                Models.add(Model(" $message", " $des", R.drawable.email ))
                Toast.makeText(this@ShowListActivity, " You add the message", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun addModel()
    {
        Models.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        Models.add(Model("The weather today is so bad", "You should bring raincoat or umbrella", R.drawable.email))
        Models.add(Model("The weather is so good", "Have a nice day!!!", R.drawable.email))
        Models.add(Model("Notification From Company", "Don't forget to check health care today!", R.drawable.email))
        Models.add(Model("Notification From Mr. Gumi", "Take a day off", R.drawable.email))
        Models.add(Model("Notification From Speech list", "Dont forget speech today", R.drawable.email))
        Models.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        Models.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        Models.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        Models.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        Models.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        Models.add(Model("Notification From Company", "Take a day off", R.drawable.email))
        Models.add(Model("Notification From Company", "Take a day off", R.drawable.email))
    }

//    override fun editItem(context: Context, Model: Int){
//        val intent = Intent(this@ShowListActivity, EditActivity::class.java )
//        intent.putExtra(INTENT_PARCELABLE,true)
//
//    }

//    override fun editItem(person: Person, index: Int) {
//        val intent = Intent(this@MainActivity, EditActivity::class.java)
//        intent.putExtra(PERSON_INTENT_EDIT, true)
//        intent.putExtra(PERSON_INTENT_OBJECT, person)
//        intent.putExtra(PERSON_INTENT_INDEX, index)
//        startActivityForResult(intent, REQUEST_CODE)
//    }
}



