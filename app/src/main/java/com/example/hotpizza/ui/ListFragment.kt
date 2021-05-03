package com.example.hotpizza.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hotpizza.ListContract
import com.example.hotpizza.R
import com.example.hotpizza.adapter.PizzaAdapter
import com.example.hotpizza.model.Pizza
import com.example.hotpizza.presenter.ListPresenter

class ListFragment : Fragment(), ListContract.View {

    private val presenter = ListPresenter(this)

    lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_list, container, false)

        recyclerView = view.findViewById(R.id.recyclerViewList)

        presenter.getData("https://p3teufi0k9.execute-api.us-east-1.amazonaws.com/v1/")

        return view
    }

    override fun loadData(listPizzaData: List<Pizza>) {
        recyclerView.adapter = PizzaAdapter(listPizzaData, requireContext())

        val layoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = layoutManager
    }

    override fun showInfo(message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }
}