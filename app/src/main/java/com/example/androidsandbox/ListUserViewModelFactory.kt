package com.example.androidsandbox

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ListUserViewModelFactory(val repository: UserRepository)  : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ListUserViewModel(repository) as T
    }
}