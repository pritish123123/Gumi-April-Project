package com.example.gumivietnam

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val arrayList: ArrayList<Model>, val context: Context):
    RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        fun bindItems(model: Model){
            itemView.company.text = model.title
            itemView.take.text = model.des
            itemView.red.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
       return arrayList.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position])

        holder.itemView.setOnClickListener{

            if (position == 0) {

                Toast.makeText(
                    context,
                    "You clicked on Company notification",
                    Toast.LENGTH_SHORT
                ).show()

            }

            if (position == 1) {

                Toast.makeText(
                    context,
                    "You clicked on position 1",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (position == 2) {

                Toast.makeText(
                    context,
                    "You clicked on position 2",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (position == 3) {

                Toast.makeText(
                    context,
                    "You clicked on position 3",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (position == 4) {

                Toast.makeText(
                    context,
                    "You clicked on position 4",
                    Toast.LENGTH_SHORT
                ).show()
            }

            if (position == 5) {

                Toast.makeText(
                    context,
                    "You clicked on position 5",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}
