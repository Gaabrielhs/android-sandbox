package com.example.androidsandbox

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

class ListUserViewModel internal constructor(repository : UserRepository) : ViewModel() {

//    val users: List<User> = repository.getAll()
    val users: LiveData<List<User>> = repository.getAllLive()

}
