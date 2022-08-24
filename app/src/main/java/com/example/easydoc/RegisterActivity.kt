package com.example.easydoc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.easydoc.databinding.ActivityRegisterBinding
import com.google.firebase.auth.FirebaseAuth


class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private lateinit var firebaseAuth:FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        binding =ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)
        firebaseAuth= FirebaseAuth.getInstance()

        binding.mTvLoginPage.setOnClickListener {
            val intent=Intent(this,Login::class.java)
            startActivity(intent)
        }

        binding.mBtnRegister.setOnClickListener {
            val username = binding.mEdtName.text.toString().trim()
            val useremail = binding.mEdtEmail.text.toString().trim()
            val userphonenumber = binding.mEdtPhoneNumber.text.toString().trim()
            val userpassword = binding.mEdtPassword.text.toString().trim()
            val userconfirmpass = binding.mEdtConfirmPassword.text.toString().trim()


//            Check if user is empty
            if (username.isEmpty()) {
                Toast.makeText(this, "Please enter name", Toast.LENGTH_LONG).show()
            } else if (useremail.isEmpty()) {
                Toast.makeText(this, "Please enter email", Toast.LENGTH_LONG).show()

            } else if (userphonenumber.isEmpty()) {
                Toast.makeText(this, "Please enter phone number", Toast.LENGTH_LONG).show()
            } else if (
                userpassword.isEmpty()) {
                Toast.makeText(this, "Please enter password", Toast.LENGTH_LONG).show()
            } else if (
                userconfirmpass.isEmpty()) {
                Toast.makeText(this, "Please enter password again", Toast.LENGTH_LONG).show()
            }else if (userpassword!==userconfirmpass){
                Toast.makeText(this,"passwords are not matching", Toast.LENGTH_LONG).show()
            }else{
                firebaseAuth.createUserWithEmailAndPassword(useremail,userpassword).addOnCompleteListener{
                    if (it.isSuccessful){
                        val intent=Intent(this,Login::class.java)
                        startActivity(intent)
                    }else{
                        Toast.makeText(this,it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            }
        }
    }
}
