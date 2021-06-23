package com.faraday.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class HomeActivity : AppCompatActivity() {

    private lateinit var userNameDisplay: TextView
    private lateinit var profileButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        userNameDisplay = findViewById(R.id.userNameDisplay)

        userNameDisplay.text = "Welcome, ${intent.getStringExtra("name")}"

        profileButton =  findViewById(R.id.profileButton)

        profileButton.setOnClickListener(){
            goToHome()
        }

    }
    fun goToHome(){
        val intent: Intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

}