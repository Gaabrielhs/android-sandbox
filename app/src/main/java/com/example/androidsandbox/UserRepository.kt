package com.example.androidsandbox

class UserRepository private constructor(private val userDao: UserDao) {

    fun getAll() = userDao.getAll()
    fun getAllLive() = userDao.getAllLive()

    fun insertUser(user: User) = userDao.insertUser(user)

    companion object {
        @Volatile private var instance : UserRepository? = null

        fun getInstance(userDao: UserDao) =
            instance ?: synchronized(this) {
                instance
                    ?: UserRepository(userDao).also { instance = it }
            }
    }
}