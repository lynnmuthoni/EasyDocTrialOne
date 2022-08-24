package com.example.easydoc

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.app.Dialog
import android.content.DialogInterface
import android.widget.ListView
import android.widget.Toast

class AdminActivity : AppCompatActivity() {
    var listUsers:ListView?=null
    var adapter:CustomAdapter?=null
    var users:ArrayList?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)
        listUsers=findViewById(R.id.listUsers)
        users=ArrayList()
        adapter=CustomAdapter(this,users!!)

//        connect to users table/child
        val reference = FirebaseDatabase.getInstance().getReference().child("Employees")
//        start Fetching the Data
        reference.addValueEventListener(object  : ValueEventListener{
            //            override the on data change
            override fun onDataChange(snapshot: DataSnapshot) {
                users!!.clear()
//    use for each loop to add he users on the Arraylist
                for (snap in snapshot.children){
                    var user = snap.getValue(User::class.java)
                    users!!.add(user!!)
                }
                adapter!!.notifyDataSetChanged()
            }
            //            override on cancel method
            override fun onCancelled(error: DatabaseError) {
//    coz u had set the rules on the database as True, True,
                Toast.makeText(applicationContext,"Please contact the Admin",
                    Toast.LENGTH_LONG).show()
            }
        })
        listUsers!!.adapter=adapter!!
//        set on an item click listener to the list view
        listUsers!!.setOnItemClickListener { adapterView, view, i, l ->
            val UserId = users!!.get(i).id
            val deletionReference = FirebaseDatabase.getInstance().
            getReference().child("Employees/$UserId")
//         set an alert when someone clicks on an item
            val alertDialog = AlertDialog.Builder(this)
            alertDialog.setTitle("Alert!!")
            alertDialog.setMessage("Select an action you want to perform")
            alertDialog.setNegativeButton("Update",
                DialogInterface.OnClickListener { dialogInterface, i ->
                //Dimiss
            })
            alertDialog.setPositiveButton("Delete",DialogInterface.OnClickListener { dialogInterface, i ->
                deletionReference.removeValue()
                Toast.makeText(applicationContext,"Deleted Successfully",
                    Toast.LENGTH_LONG).show()
            })

        }
    }
    }
}