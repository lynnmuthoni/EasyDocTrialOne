package com.example.easydoc

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView


class CustomAdapter(var context: Context, var data:ArrayList<PatientUsers>):BaseAdapter() {
    private class ViewHolder(row:View?){
        var mTxtName:TextView
        var mTxtNumber:TextView
        var mTxtEmail:TextView
        var mImageView:ImageView


        init {
            this.mTxtName = row?.findViewById(R.id.userpname) as TextView
            this.mTxtNumber = row?.findViewById(R.id.userphonenumber) as TextView
            this.mTxtEmail = row?.findViewById(R.id.patientsemail) as TextView
            this.mImageView= row?.findViewById(R.id.profile_pic)as ImageView

        }
    }
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view:View?
        var viewHolder:ViewHolder
        if (convertView == null){
            var layout = LayoutInflater.from(context)
            view = layout.inflate(R.layout.userordoctorlayout,parent,false)
            viewHolder = ViewHolder(view)
            view.tag = viewHolder
        }else{
            view = convertView
            viewHolder = view.tag as ViewHolder
        }
        var item:PatientUsers = getItem(position) as PatientUsers
        viewHolder.mTxtName.text = item.name
        viewHolder.mTxtNumber.text = item.Number
        viewHolder.mTxtEmail.text=  item.email
        viewHolder.mImageView.image=  item.Image
        return view as View
    }

    override fun getItem(position: Int): Any {
        return  data.get(position)
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return data.count()
    }