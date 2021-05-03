package com.example.hotpizza

interface LoginContract {
    interface View {
        fun showInfo(message: String)
    }

    interface Presenter {
        fun validateUser(user: String, password: String) : Boolean
        fun postSigIn(baseUrl: String, email: String, password: String)
    }
}