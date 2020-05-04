package com.example.gumivietnam

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.util.*


class MyAdapter(
    private val context: Context,
    private val model: List<Model>,
    private val mRandom: Random = Random(),
    val listener: (Model) -> Unit
) :
    RecyclerView.Adapter<MyAdapter.ModelViewHolder>()
{

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        val image = view.findViewById<ImageView>(R.id.red)
        val title = view.findViewById<TextView>(R.id.company)
        val descriptor = view.findViewById<TextView>(R.id.take)
        val delete = view.findViewById<ImageView>(R.id.imageDelete)
        fun bindView(model: Model, listener: (Model) -> Unit)
        {
            image.setImageResource(model.image)
            title.text = model.title
            descriptor.text = model.descriptor
            itemView.setOnClickListener { listener(model) }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder =
        ModelViewHolder(LayoutInflater.from(context).inflate(R.layout.row, parent, false))

    override fun getItemCount(): Int = model.size


    override fun onBindViewHolder(holder: ModelViewHolder, position: Int)
    {
        holder.bindView(model[position], listener)

    }
}
