package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class AdminLogin : AppCompatActivity() {
    var MedtAdminName:EditText?=null
    var MedtAdminEmail:EditText?=null
    var MedtAdminPass:EditText?=null
    var mAdminBtnLogin:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_login)

        MedtAdminName=findViewById(R.id.mAdminEdtName)
        MedtAdminEmail=findViewById(R.id.mAdminEdtEmail)
        MedtAdminPass=findViewById(R.id.mAdminEdtPassword)

        mAdminBtnLogin!!.setOnClickListener{
            var adminName = MedtAdminName!!.text.toString()
            var adminEmail = MedtAdminEmail!!.text.toString()
            var adminPassword = MedtAdminPass!!.text.toString()

            if (adminName.isEmpty() || adminEmail.isEmpty()||adminPassword.isEmpty()){
                messages( "Empty Fields", "Please fill in all inputs")
            }else if (adminName=="Linet" && adminEmail=="lynnmuthoni00@gmail.com" && adminPassword =="123"){
                val intent= Intent(this,AdminActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        }

    private fun messages(Title: String, message: String) {
    var alertDialog=AlertDialog.Builder(this)
        alertDialog.setTitle(Title)
        alertDialog.setMessage(message)
        alertDialog.create().show()
    }

}