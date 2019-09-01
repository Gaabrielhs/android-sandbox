package com.example.androidsandbox

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.activity.viewModels

import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel by viewModels {
        UserViewModelFactory(UserRepository.getInstance(AppDatabase.getInstance(applicationContext).userDao()))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnSalvar.setOnClickListener {
            Toast.makeText(baseContext,"Salvante", Toast.LENGTH_SHORT).show()

            val usuario = User(nome = nome.text.toString(), apelido = apelido.text.toString())

            viewModel.insertUser(usuario)

            val intencao = Intent(this,  ListUsers::class.java)
            startActivity(intencao)

            finish()
        }

    }
}
