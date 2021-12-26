package com.example.week5

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import com.example.week5.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnNol.setOnClickListener { addValue("0", true) }
        binding.btnSatu.setOnClickListener { addValue("1", true) }
        binding.btnDua.setOnClickListener { addValue("2", true) }
        binding.btnTiga.setOnClickListener { addValue("3", true) }
        binding.btnEmpat.setOnClickListener { addValue("4", true) }
        binding.btnLima.setOnClickListener { addValue("5", true) }
        binding.btnEnam.setOnClickListener { addValue("6", true) }
        binding.btnTujuh.setOnClickListener { addValue("7", true) }
        binding.btnDlpan.setOnClickListener { addValue("8", true) }
        binding.btnSmbilan.setOnClickListener { addValue("9", true) }
        binding.btnNolDua.setOnClickListener { addValue("00", true) }
        binding.btnKoma.setOnClickListener { addValue(".", true) }



        binding.btnPlus.setOnClickListener { addValue("+", false) }
        binding.btnMinus.setOnClickListener { addValue("-", false) }
        binding.btnBagi.setOnClickListener { addValue("/", false) }
        binding.btnKali.setOnClickListener { addValue("*", false) }

        btnSamDeng()
        btnDelete()
        btnClear()
    }

    private fun addValue(value: String, clear: Boolean) {
        if (clear) {
            binding.tvResult.text = ""
            binding.tvCalculate.append(value)
        } else {
            if (binding.tvResult.text.toString().contains("Eror")) {
                binding.tvResult.text = ""
            } else {
                binding.tvCalculate.append(binding.tvResult.text.toString())
                binding.tvCalculate.append(value)
                binding.tvResult.text = ""
            }
        }
    }

    private fun btnSamDeng(){
        binding.btnSamDeng.setOnClickListener {
            if (binding.tvCalculate.text.toString().isEmpty()){
                binding.tvResult.text = "0"
            } else {
                try {
                    val expression = ExpressionBuilder(binding.tvCalculate.text.toString()).build()
                    val result = expression.evaluate()
                    val longResult = result.toLong()
                    if (result == longResult.toDouble()) {
                        binding.tvResult.text = longResult.toString()
                    } else {
                        binding.tvResult.text = result.toString()
                    }

                } catch (e : Exception){
                    binding.tvResult.text = "Error"
                }
            }
            binding.tvCalculate.text = ""
        }
    }

    private fun btnDelete(){
        binding.btnDel.setOnClickListener {
            val string = binding.tvCalculate.text.toString()
            if (string.isNotEmpty()) {
                // 123
                binding.tvCalculate.text = string.substring(0,string.length-1)
            }
        }
    }

    private fun btnClear(){
        binding.btnClear.setOnClickListener {
            binding.tvCalculate.text = ""
            binding.tvResult.text = ""
        }
    }
}