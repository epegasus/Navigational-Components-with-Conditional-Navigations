package com.example.navigationalconditions.models

class UserSession {
    companion object {
        var user: User? = null
    }
}

data class User(
    val username: String, val password: String
)
