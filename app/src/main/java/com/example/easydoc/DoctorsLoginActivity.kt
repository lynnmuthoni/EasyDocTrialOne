package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.easydoc.databinding.ActivityDoctorsLoginBinding
import com.example.easydoc.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class DoctorsLoginActivity : AppCompatActivity() {

        private lateinit var binding: ActivityDoctorsLoginBinding
        private lateinit var firebaseAuth: FirebaseAuth
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)

            binding= ActivityDoctorsLoginBinding.inflate(layoutInflater)
            setContentView(binding.root)

            binding.mDocTvRegisterPage.setOnClickListener {
                val intent= Intent(this,DoctorRegisterActivity::class.java)
                startActivity(intent)
            }
            binding.mDocBtnLogin.setOnClickListener {

                val username = binding.mDocEdtName.text.toString().trim()
                val useremail = binding.mDocEdtEmail.text.toString().trim()
                val userpassword = binding.mDocEdtPassword.text.toString().trim()


//            Check if user is empty
                if (username.isEmpty()) {
                    Toast.makeText(this, "Please enter name", Toast.LENGTH_LONG).show()
                } else if (useremail.isEmpty()) {
                    Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show()

                } else if (
                    userpassword.isEmpty()) {
                    Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()
                }else{
                    firebaseAuth.signInWithEmailAndPassword(useremail,userpassword).addOnCompleteListener{
                        if (it.isSuccessful){
                            val intent= Intent(this,HomeActivity::class.java)
                            startActivity(intent)
                        }else{
                            Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                        }
                    }
                }
            }
        }
    }
}