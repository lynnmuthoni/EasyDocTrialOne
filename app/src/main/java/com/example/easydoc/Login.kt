package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.easydoc.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.mTvRegisterPage.setOnClickListener {
            val intent= Intent(this,RegisterActivity::class.java)
            startActivity(intent)
        }
        binding.mBtnLogin.setOnClickListener {

            val username = binding.mEdtName.text.toString().trim()
            val useremail = binding.mEdtEmail.text.toString().trim()
            val userpassword = binding.mEdtPassword.text.toString().trim()


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
                        val intent=Intent(this,HomeActivity::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}