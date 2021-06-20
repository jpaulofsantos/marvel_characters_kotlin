package com.example.marvelcharacters.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.marvelcharacters.R
import com.example.marvelcharacters.adapter.MainAdapter
import com.example.marvelcharacters.databinding.ActivityMainBinding
import com.example.marvelcharacters.model.Result
import com.example.marvelcharacters.model.data.CharactersDataSource
import com.example.marvelcharacters.presenter.CharacterPresenter
import com.example.marvelcharacters.presenter.ViewHome

class MainActivity : AppCompatActivity(), ViewHome.View {

    private val mainAdapter by lazy {
        MainAdapter()
    }

    private lateinit var presenter : CharacterPresenter

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val dataSource = CharactersDataSource(this)
        presenter = CharacterPresenter(this, dataSource)
        presenter.requestCharacters()

        configRecycler()

    }

    private fun configRecycler() {
        with(binding.rvCharacters) {
            adapter = mainAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(DividerItemDecoration(
                this@MainActivity, DividerItemDecoration.VERTICAL
            ))
        }
    }

    override fun showProgressBar() {
        binding.rvProgressBar.visibility = View.VISIBLE
    }

    override fun showFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun hideProgressBar() {
        binding.rvProgressBar.visibility = View.INVISIBLE
    }

    override fun showCharacteres(result: List<Result>) {
        mainAdapter.differ.submitList(result.toList())
    }
}