package com.example.recyclerview2

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private var titles = arrayOf("One", "Two", "Three", "4",
        "5", "6", "7",
        "8", "9", "10",
        "11", "12", "13")

    private var details= arrayOf("Item 1", "Item 2", "Item 3","Item 4",
        "Item 5", "Item 6","Item 7",
        "Item 8", "Item 9","Item 10",
        "Item 11", "Item 12","Item 13",)

    private val images = intArrayOf(R.drawable.folder,R.drawable.folder,R.drawable.folder,R.drawable.folder,
        R.drawable.folder,R.drawable.folder,R.drawable.folder,
        R.drawable.folder,R.drawable.folder,R.drawable.folder,
        R.drawable.folder,R.drawable.folder,R.drawable.folder)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent, false)
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.itemTitle.text = titles[position]
        holder.itemDetail.text = details[position]
        holder.itemImage.setImageResource(images[position])
    }

    override fun getItemCount(): Int {
        return titles.size

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            itemView.setOnClickListener {
                val position: Int = adapterPosition

                Toast.makeText(itemView.context,"You Clicked on ${titles[position]}", Toast.LENGTH_SHORT).show()



            }





        }

    }
}