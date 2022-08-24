package com.example.easydoc

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(private  val context:Activity,private val arrayList: ArrayList<PatientUsers>):ArrayAdapter<PatientUsers>(context,
                R.layout.userordoctorlayout.arrayList)    {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        
        val inflater:LayoutInflater= LayoutInflater.from(context)
        val view:View=inflater.inflate((R.layout.userordoctorlayout,null)
        
        val imageView: ImageView=view.findViewById(R.id.profile_pic)
        val username: TextView =view.findViewById(R.id.userpname)
        val lastmsg: TextView=view.findViewById(R.id.lastMessage)
        val lastmesg: TextView=view.findViewById(R.id.time)


        imageView.setImageResource(arrayList[position].imageId)
        username.text=arrayList[position].userpname
        lastmsg.text=arrayList[position].lastMessage
        lastmesg.text=arrayList[position].time

        
        
        return view
    }
}