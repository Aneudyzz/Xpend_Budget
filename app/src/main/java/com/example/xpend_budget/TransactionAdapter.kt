package com.example.xpend_budget

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView

class TransactionAdapter(private val transactions:ArrayList<Transaction>) : RecyclerView.Adapter<TransactionAdapter.TransactionHolder>() {
    class TransactionHolder(view: View) : RecyclerView.ViewHolder(view){
        val label : TextView = view.findViewById(R.id.label)
        val amount : TextView = view.findViewById(R.id.amount)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.transaction_layout,parent,false)
        return TransactionHolder(view)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

    override fun onBindViewHolder(holder: TransactionHolder, position: Int) {
       val transactions: Transaction = transactions[position]
        val context: Context = holder.amount.context
        if(transactions.amount >= 0){
            holder.amount.text ="+ $%.2f".format(transactions.amount)
            holder.amount.setTextColor(ContextCompat.getColor(context,R.color.green))

        }else{
            holder.amount.text ="- $%.2f".format(Math.abs(transactions.amount))
            holder.amount.setTextColor(ContextCompat.getColor(context,R.color.red))
        }
        holder.label.text = transactions.label


    }
}