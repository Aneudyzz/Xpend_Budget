package com.example.xpend_budget

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.widget.addTextChangedListener
import com.example.xpend_budget.databinding.ActivityAddTransactionBinding
import com.example.xpend_budget.ui.theme.Xpend_BudgetTheme

class AddTransactionActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_transaction)

        lateinit var binding: ActivityAddTransactionBinding

        binding = ActivityAddTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.labelInput.addTextChangedListener {
            if (it!!.count()> 0)
                binding.labelLayout.error = null
        }

        binding.amountInput.addTextChangedListener {
            if (it!!.count()> 0)
                binding.amountInput.error = null
        }
       binding.addTransactionBtn.setOnClickListener {
            val label = binding.labelInput.text.toString()
            val amount= binding.amountInput.text.toString().toDoubleOrNull()

            if(label.isEmpty())
                binding.labelLayout.error ="Ingrese un valor correspondiente"

            if(amount == null)
            binding.amountLayout.error ="Ingrese un valor correspondiente"
        }

        binding.closeBtn.setOnClickListener {
            finish()
        }
                }

            }