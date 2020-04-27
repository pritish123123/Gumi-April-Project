package com.example.gumivietnam

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup
import android.widget.TextView
import com.example.gumivietnam.ShowListActivity.Companion.INTENT_PARCELABLE

class InfoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)

        val model = intent.getParcelableExtra<Model>(ShowListActivity.INTENT_PARCELABLE)

        val modeltitle = findViewById<TextView>(R.id.note)
        val modeldescription = findViewById<TextView>(R.id.textView3)

    }
}
