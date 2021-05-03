package com.example.hotpizza.presenter

import com.example.hotpizza.ListContract
import com.example.hotpizza.api.Endpoints
import com.example.hotpizza.api.Service
import com.example.hotpizza.model.Pizza
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListPresenter(private var view: ListContract.View): ListContract.Presenter {

    override fun getData(path: String) {
        val retrofit = Service.getInstance(path)
        val endpoints = retrofit.create(Endpoints::class.java)
        val callback = endpoints.getPizzas()


        callback.enqueue(object : Callback<List<Pizza>> {
            var list: MutableList<Pizza> = ArrayList()

            override fun onResponse(call: Call<List<Pizza>>, response: Response<List<Pizza>>) {
                response.body()?.forEach{ pizza ->
                   list.add(pizza)
                }
                view.loadData(list)
            }

            override fun onFailure(call: Call<List<Pizza>>, t: Throwable) {
                t.message?.let { view.showInfo(it) }
            }

        })

    }
}