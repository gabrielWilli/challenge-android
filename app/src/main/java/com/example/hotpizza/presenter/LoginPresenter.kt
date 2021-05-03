package com.example.hotpizza.presenter

import com.example.hotpizza.LoginContract
import com.example.hotpizza.api.Endpoints
import com.example.hotpizza.api.Service
import com.example.hotpizza.model.Pizza
import com.example.hotpizza.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginPresenter : LoginContract.Presenter {

    lateinit var view: LoginContract.View

    //fazer a validação do user e password pela API
    override fun validateUser(user: String, password: String): Boolean {
        return user == "user@xds.com.br" && password == "223344"
    }

    override fun postSigIn(baseUrl: String, email: String, password: String) {
        val retrofit = Service.getInstance(baseUrl)
        val endpoints = retrofit.create(Endpoints::class.java)
        val callback = endpoints.postSignIn(User(email, password))

        callback.enqueue(object : Callback<User> {
            override fun onResponse(call: Call<User>, response: Response<User>) {
                //Criar lógica para fazer o POST na API
            }

            override fun onFailure(call: Call<User>, t: Throwable) {
                t.message?.let { view.showInfo(it) }
            }


        })
    }
}