package com.example.googleloginauthentication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {

    private lateinit var mAuth: FirebaseAuth //late initialize firebase authentication api

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mAuth = FirebaseAuth.getInstance() //instantiate firebase
        val user = mAuth.currentUser
        //run the splashscreen in handler so a delay occurs before going to the next screen
        Handler().postDelayed({

            if(user !== null){
                //if user had signed in before now, then take them straight to dashboard
                val dashBoardIntent = Intent(this, DashBoard::class.java )
                startActivity(dashBoardIntent)
                finish()
            }else{
                //here means user has not signed in, so take them to sign in page
                val signInIntent = Intent(this, SignIn::class.java )
                startActivity(signInIntent)
                finish()

            }

        }, 2000)
    }
}