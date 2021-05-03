package com.example.hotpizza

import com.example.hotpizza.model.Pizza

interface ListContract {
    interface View{
        fun loadData(listPizzaData: List<Pizza>)
        fun showInfo(message: String)
    }

    interface Presenter {
        fun getData(path: String)
    }
}