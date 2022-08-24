package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class DashboardActivity : AppCompatActivity() {

    var buttonPatientslogin:Button?=null
    var buttonDoctorslogin:Button?=null
    var buttonAdminlogin:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        buttonPatientslogin=findViewById(R.id.mBtnPatients)
        buttonPatientslogin!!.setOnClickListener {
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
            finish()
        }
        buttonDoctorslogin=findViewById(R.id.mBtnDoctor)
        buttonDoctorslogin!!.setOnClickListener {
            val intent=Intent(this,DoctorsLoginActivity::class.java)
            startActivity(intent)
            finish()
        }
        buttonAdminlogin=findViewById(R.id.mBtnAdmin)
        buttonDoctorslogin!!.setOnClickListener {
            val intent=Intent(this,AdminLogin::class.java)
            startActivity(intent)
            finish()
        }
    }
}