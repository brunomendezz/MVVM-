package ar.edu.unlam.mvvmconlivedata.ui.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import ar.edu.unlam.mvvmconlivedata.databinding.ActivityMainBinding
import ar.edu.unlam.mvvmconlivedata.ui.viewmodel.QuoteViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        quoteViewModel.onCreate()

        quoteViewModel.quoteModel.observe(this, Observer {
            if (it != null) {
                binding.tvFrase.text= it.quote
            }
            if (it != null) {
                binding.tvAuthor.text= it.author
            }

        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progress.isVisible = it
        })
        binding.viewContainer.setOnClickListener(){
            quoteViewModel.randomQuote()
        }
    }
}