package com.example.androidsandbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_list_users.*

class ListUsers : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_users)

        fab.setOnClickListener {
            val intencao = Intent(this, MainActivity::class.java)
            startActivity(intencao)
        }
    }
}
