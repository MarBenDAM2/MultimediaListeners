package com.example.multimedialisteners

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.multimedialisteners.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    var contador = 0

    //Programa para que al hacer click en el boton "button2" sume 1 al textView "textView"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            sumar()
            binding.editTextNumero.clearFocus()
        }
        binding.button.setOnClickListener{
            restar()
            binding.editTextNumero.clearFocus()
        }

        binding.editTextNumero.onFocusChangeListener = View.OnFocusChangeListener{
            view, hasFocus ->
            if(hasFocus){
                binding.button.setBackgroundColor(getColor(R.color.black))
                binding.button2.setBackgroundColor(getColor(R.color.black))
            } else {
                binding.button.setBackgroundColor(getColor(R.color.purple_500))
                binding.button2.setBackgroundColor(getColor(R.color.purple_500))
            }
        }

        binding.editTextNumero.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

                try {
                    contador = s.toString().toInt()
                    binding.textView.text = contador.toString()
                } catch (e: NumberFormatException) {
                    binding.editTextNumero.text.clear()
                    contador = 0
                    binding.textView.text = "0"
                }

            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

    }
    //Creame una funcion para que sume 1 al contador y cambie el textView
    fun sumar(){
        contador++
        binding.textView.text = contador.toString()
    }
    //Ahora para restar 1
    fun restar(){
        if (contador > 0){
            contador--
            binding.textView.text = contador.toString()
        }
    }

}