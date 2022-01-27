package com.example.googleloginauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.auth.FirebaseAuth

class DashBoard : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        mAuth = FirebaseAuth.getInstance()
        val currentUser = mAuth.currentUser
        val userId = findViewById<TextView>(R.id.id_txt)
        val userName = findViewById<TextView>(R.id.name_txt)
        val userEmail = findViewById<TextView>(R.id.email_txt)
        val profileImage = findViewById<ImageView>(R.id.profile_image)
        val signOut = findViewById<Button>(R.id.sign_out_btn)

        userId.text = currentUser?.uid
        userName.text = currentUser?.displayName
        userEmail.text = currentUser?.email

        Glide.with(this).load(currentUser?.photoUrl).into(profileImage)

        signOut.setOnClickListener {

            mAuth.signOut()
            val intent = Intent(this, SignIn::class.java)
            startActivity(intent)
            finish()
        }
    }
}