package com.example.contactsappwithrecyclerviewcontextresolverfragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

@Suppress("DEPRECATION")
class RecyclerAdapter:RecyclerView.Adapter<RecyclerAdapter.ViewHolder>() {

    private val contactInfo: ArrayList<PhoneContactData> = ArrayList()

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        lateinit var itemImage: ImageView
        lateinit var itemTitle: TextView
        lateinit var itemDetails: TextView
        lateinit var itemStared: TextView

        init {
            itemImage = itemView.findViewById(R.id.item_image)
            itemTitle = itemView.findViewById(R.id.item_title)
            itemDetails = itemView.findViewById(R.id.item_detail)
            itemStared = itemView.findViewById(R.id.item_stared)


            itemView.setOnClickListener{
                val position:Int = adapterPosition

                Toast.makeText(itemView.context,"You Clicked on ${contactInfo[position].contactName}", Toast.LENGTH_SHORT).show()
            }

        }



    }

    fun setContactInfo(ContactInfoData: List<PhoneContactData>){
        contactInfo.clear()
        contactInfo.addAll(ContactInfoData)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflatedCardView = LayoutInflater.from(parent.context).inflate(R.layout.card_layout, parent,false)
        return ViewHolder(inflatedCardView)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.ViewHolder, position: Int) {
        holder.itemTitle.text = contactInfo[position].contactName
        holder.itemDetails.text = contactInfo[position].contactNumber
        if(contactInfo[position].contactStared=="1"){
            holder.itemStared.text= "Started"
        }
        else{
            holder.itemStared.text= "Not Started"

        }




    }

    override fun getItemCount(): Int {
        return contactInfo.size
    }
}