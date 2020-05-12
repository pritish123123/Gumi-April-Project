package com.example.gumivietnam

import android.content.Context
import android.text.Editable
import android.text.InputType
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.PopupMenu
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.add_message_dialog.view.*


class MyAdapter(
    val context: Context,
    val items: ArrayList<Model>,
    private val listener: (Model) -> Unit
) :
    RecyclerView.Adapter<MyAdapter.ModelViewHolder>()
{

    class ModelViewHolder(view: View) : RecyclerView.ViewHolder(view)
    {
        private val image: ImageView = view.findViewById(R.id.red)
        private val title: TextView? = view.findViewById(R.id.company)
        private val descriptor: TextView? = view.findViewById(R.id.take)
        val buttonViewOption: TextView? = itemView.findViewById(R.id.textViewOptions)
        fun bindView(items: Model, listener: (Model) -> Unit)
        {
            image.setImageResource(items.image)
            title?.text = items.title
            descriptor?.text = items.descriptor
            itemView.setOnClickListener { listener(items) }
            buttonViewOption?.setOnClickListener{ }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder
    {
        return ModelViewHolder(LayoutInflater.from(context).inflate(R.layout.row, parent, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int)
    {
        holder?.bindView(items[position], listener)
        holder?.buttonViewOption?.setOnClickListener {
            val popup = PopupMenu(context, holder.buttonViewOption)
            //inflating menu from xml resource
            popup.inflate(R.menu.menu_option)
            //adding click listener
            popup.setOnMenuItemClickListener { item ->
                when (item.itemId) {
                    R.id.delete -> {
                        items.removeAt(position)
                        notifyItemRemoved(position)
                        notifyItemRangeChanged(position,items.size)
                    }
                    R.id.edit -> {
                        val mDialogView = LayoutInflater.from(context).inflate(R.layout.add_message_dialog, null)
                        val mBuilder = AlertDialog.Builder(context)
                            .setView(mDialogView)
                            .setTitle("Edit Message")
                        val mAlertDialog = mBuilder.show()
                        //
                        mDialogView?.add?.setText(items[position].title)
                        mDialogView?.des?.setText(items[position].descriptor)

//                        mDialogView?.add?.hint=items[position].title
//                        mDialogView?.des?.hint =(items[position].descriptor)

                        mDialogView.cancel_button.setOnClickListener {
                            mAlertDialog.dismiss()
                        }
                        mDialogView.add_btn.setOnClickListener {
                            mAlertDialog.dismiss()
                            val message = mDialogView?.add?.text.toString()
                            val des = mDialogView?.des?.text.toString()
                            val editItem = items.get(position)
                            editItem.title = message
                            editItem.descriptor = des
                            notifyItemChanged(position)
                            Toast.makeText( context, " You edit the message", Toast.LENGTH_LONG).show()
                        }.also { mDialogView.add_btn.text="Save" }
                    }
                }
                false
            }
            //displaying the popup
            popup.show()
        }
    }
}
