package com.example.recyclerview2

import android.annotation.SuppressLint
import android.provider.ContactsContract
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.contentValuesOf
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class RecyclerAdapter: RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val contactInfo: ArrayList<PhoneContactData> = ArrayList()


    fun setContactInfo(ContactInfoData: List<PhoneContactData>){
        contactInfo.clear()
        contactInfo.addAll(ContactInfoData)
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.card_layout,parent, false)
        Log.i("OnCreateViewHolder", "Its Running")
        return ViewHolder(v)
    }


    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {

        holder.itemTitle.text = contactInfo[position].contactName
        holder.itemDetail.text = contactInfo[position].contactNumber
//        holder.itemImage.setImageResource(contactInfo[position].)

        Log.i("onBindViewHolder", "Its Running")
    }

    override fun getItemCount(): Int {
        return contactInfo.size

    }

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        var itemImage : ImageView
        var itemTitle: TextView
        var itemDetail: TextView

        init{
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetail = itemView.findViewById(R.id.item_detail)

            Log.i("inner class ViewHolder", "Its Running")



            itemView.setOnClickListener {
                val position: Int = adapterPosition

                Toast.makeText(itemView.context,"You Clicked on ${contactInfo[position].contactName}", Toast.LENGTH_SHORT).show()
                Log.i("Clicked on a folder", "${contactInfo[position].contactName}")



            }






        }

    }
}