package com.example.androidsandbox

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class User(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val nome: String,
    val apelido: String
)