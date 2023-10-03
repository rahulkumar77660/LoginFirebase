package com.example.loginfirebase

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {
    val auth = FirebaseAuth.getInstance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<EditText>(R.id.emailEditText)
        val password = findViewById<EditText>(R.id.passwordEditText)
        val registerBtn = findViewById<Button>(R.id.registerBtn)
        val logout = findViewById<Button>(R.id.logoutBtn)
        val loginBtn = findViewById<Button>(R.id.loginBtn)
        val deleteBtn = findViewById<Button>(R.id.deleteBtn)

        registerBtn.setOnClickListener {
            registerWithEmailAndPassword(email.text.toString(), password.text.toString())
        }



        logout.setOnClickListener {
            auth.signOut()
            Toast.makeText(this,"LOGOUT",Toast.LENGTH_SHORT).show()
        }



        loginBtn.setOnClickListener {
            if (auth.currentUser?.uid == null) {
                loginWithEmailAndPassword(email.text.toString(), password.text.toString())
            }
            else {
                Toast.makeText(this,"you are already login" ,Toast.LENGTH_SHORT).show()
            }

            }




        deleteBtn.setOnClickListener {
            auth.currentUser?.delete()
            Toast.makeText(this,"Acount has been DELETED",Toast.LENGTH_SHORT).show()
        }



        }
        @SuppressLint("SuspiciousIndentation")
        private fun registerWithEmailAndPassword(email:String, password:String) {
            auth.createUserWithEmailAndPassword(email,password)
                .addOnSuccessListener {
                  val id=it.user?.uid
                  val email=it.user?.email
                    Toast.makeText(this,"User created successfully $id" , Toast.LENGTH_SHORT).show()
                }
                .addOnFailureListener {
                    Toast.makeText(this, it.message,Toast.LENGTH_SHORT).show()
                }
        }
    private fun loginWithEmailAndPassword(email: String, password: String){
        auth.signInWithEmailAndPassword(email,password)
            .addOnSuccessListener {
                val id=it.user?.uid
                val email=it.user?.email
                Toast.makeText(this,"User Login successfully " , Toast.LENGTH_SHORT).show()
            }
            .addOnFailureListener {
                Toast.makeText(this, it.message,Toast.LENGTH_SHORT).show()
            }
    }
    }



