package com.alko.frontend.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.alko.frontend.R
import com.alko.frontend.binders.AlcoholResponse

class AlcoholRecyclerViewAdapter internal constructor(private val context: Context, private val  data: List<AlcoholResponse>) : RecyclerView.Adapter<AlcoholRecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view: View = LayoutInflater.from(context).inflate(R.layout.item_alcohol, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data[position]
        holder.txtBrand.text = item.brand
        holder.txtAlcohol.text = item.name
        holder.txtBrand.setOnClickListener{
            Toast.makeText(context,"Marka: ${item.brand}", Toast.LENGTH_SHORT).show()
        }
        holder.txtAlcohol.setOnClickListener{
            Toast.makeText(context,"Alkochol: ${item.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    inner class ViewHolder internal constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtBrand: TextView = itemView.findViewById(R.id.txtBrand)
        var txtAlcohol: TextView = itemView.findViewById(R.id.txtAlcohol)

    }
}