package com.example.hotpizza.adapter

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.hotpizza.MainActivity
import com.example.hotpizza.R
import com.example.hotpizza.model.Pizza
import com.example.hotpizza.ui.DetailFragment
import com.squareup.picasso.Picasso


class PizzaAdapter(
    private val pizza: List<Pizza>,
    private val context: Context
) : RecyclerView.Adapter<PizzaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val itemViewPizza = itemView.findViewById<View>(R.id.itemViewPizza)
        val imagePizza = itemView.findViewById<ImageView>(R.id.imagePizza)
        val namePizza = itemView.findViewById<TextView>(R.id.namePizza)
        val valuePizza = itemView.findViewById<TextView>(R.id.valuePizza)

        fun bindItems(pizza: Pizza) {
            namePizza.text = pizza.name
            valuePizza.text = pizza.priceP.toString()
            Picasso
                .with(imagePizza.context)
                .load(pizza.imageUrl)
                .into(imagePizza)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pizza_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(pizza[position])
        val detailFragment = DetailFragment()

        //Criar lógica para navegação entre os fragments, passando os dados do elemento que foi clicado
        holder.itemViewPizza.setOnClickListener {

            val bundle = Bundle()
            bundle.putString("namePizza", pizza[position].name)
            detailFragment.arguments = bundle

            val transaction = (context as MainActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.frame, detailFragment)
            transaction.commit()
        }
    }

    override fun getItemCount(): Int {
        return pizza.size
    }
}
