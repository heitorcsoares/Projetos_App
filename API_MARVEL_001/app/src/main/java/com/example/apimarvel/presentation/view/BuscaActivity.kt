package com.example.apimarvel.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.apimarvel.R
import com.example.apimarvel.data.HeroiMarvelRepository
import com.example.apimarvel.databinding.ActivityBuscaBinding

class BuscaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityBuscaBinding
    private val repository = HeroiMarvelRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityBuscaBinding.inflate(layoutInflater)          //binding-> referencia (KT com o XML)
        setContentView(binding.root)

        //Titulo da toolbar
        setSupportActionBar(binding.toolbar).apply {
            title = getString(R.string.app_name)
        }

        //DOCUMENTAÇÃO-> TOAST:  https://developer.android.com/guide/topics/ui/notifiers/toasts?hl=pt-br
        binding.botaoPesquisar.setOnClickListener {

            val text = binding.barraPesquisa.text.toString()
            val duration = Toast.LENGTH_SHORT

            val toast = Toast.makeText(this, text, duration) // in Activity
            toast.show()

            repository.buscarHeroiPorNome(text,
                {},
                {})

        }

    }
}