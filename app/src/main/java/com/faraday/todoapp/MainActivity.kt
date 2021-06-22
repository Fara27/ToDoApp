package com.faraday.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val validUserName = "admin"
    val validPassword  ="admin"

    private lateinit var userNameInput: EditText
    private lateinit var passwordInput: EditText
    private lateinit var submitButtonInput: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userNameInput = findViewById(R.id.userNameInput)
        passwordInput = findViewById(R.id.passwordInput)
        submitButtonInput = findViewById(R.id.submitButton)

        submitButtonInput.setOnClickListener {
            val username = userNameInput.text.toString()
            val password = passwordInput.text.toString()
            login(username,password)
        }
    }

    private fun login(username: String,password: String){
        if(isValidCredentials(username, password)){
            val intent: Intent = Intent(this, HomeActivity::class.java)
            intent.putExtra("name", username)
            startActivity(intent)
        }else{
            Toast.makeText(applicationContext, "Something went wrong.", Toast.LENGTH_SHORT).show()
        }
    }

    private fun isValidCredentials(username: String, password:String): Boolean{
        if(username == validUserName && password == validPassword) return true
        return false
    }
}