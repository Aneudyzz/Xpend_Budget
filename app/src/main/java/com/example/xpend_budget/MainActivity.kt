package com.example.xpend_budget

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.xpend_budget.AddTransactionActivity
import com.example.xpend_budget.R
import com.example.xpend_budget.Transaction
import com.example.xpend_budget.TransactionAdapter
import com.example.xpend_budget.databinding.ActivityMainBinding
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    private lateinit var deletedTransaction: Transaction
    private lateinit var transactions : List<Transaction>
    private lateinit var oldTransactions : List<Transaction>
    private lateinit var transactionAdapter: TransactionAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        transactions = arrayListOf(
            transactions("Comida", -20.00),
            transactions("Alquiler", -10000.00),
            transactions("Sueldo", 30000.00),
            transactions("transporte", -20.00),
            transactions("chucherias", -100.00),
        )

        transactionAdapter = TransactionAdapter(transactions as ArrayList<Transaction>)
        linearLayoutManager = LinearLayoutManager(this)
        binding.recyclerview.apply {
            adapter = transactionAdapter
            layoutManager = linearLayoutManager
        }

        updateDashboard()
        binding.addBtn.setOnClickListener {
            val intent = Intent(this, AddTransactionActivity::class.java)
            startActivity(intent)
        }
    }

    private fun transactions(s: String, d: Double): Transaction {
        return Transaction(label = s, amount = d)

    }

    private  fun  updateDashboard(){
        val totalAmount = transactions.map { it.amount }.sum()
        val budgetAmount = transactions.filter { it.amount>0 }.map { it.amount }.sum()
        val expenseAmount = totalAmount - budgetAmount

        binding.balance.text ="$ %.2f".format(totalAmount)
        binding.presupuesto.text ="$ %.2f".format(budgetAmount)
        binding.gastos.text ="$ %.2f".format(expenseAmount)
    }
}












