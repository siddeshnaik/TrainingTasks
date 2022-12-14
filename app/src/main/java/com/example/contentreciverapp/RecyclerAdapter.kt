package com.example.contentreciverapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>(){

    private val dbInfo: ArrayList<SiddeshDbDataClass> = ArrayList()

    fun setDbData(dbInfoData: List<SiddeshDbDataClass>){
        dbInfo.clear()
        dbInfo.addAll(dbInfoData)
        notifyDataSetChanged()
    }


    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemName: TextView
        var itemMeaning : TextView

        init {
            itemName = itemView.findViewById(R.id.textViewName)
            itemMeaning = itemView.findViewById(R.id.textViewMeaning)


            itemView.setOnClickListener{
                val position:Int = adapterPosition


                Toast.makeText(itemView.context, "You Clicked on ${dbInfo[position].dbDataName}" +
                        "\n"+ "${dbInfo[position].dbDataMeaning}", Toast.LENGTH_LONG).show()
            }
        }


    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent, false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemName.text = dbInfo[position].dbDataName
        holder.itemMeaning.text = dbInfo[position].dbDataMeaning
    }

    override fun getItemCount(): Int {
        return dbInfo.size
    }
}

