package com.example.marvelcharacters.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelcharacters.databinding.ItemCharacterBinding
import com.example.marvelcharacters.model.Result

class MainAdapter : RecyclerView.Adapter<MainAdapter.CharactersViewHolder>() {

    inner class CharactersViewHolder(val binding: ItemCharacterBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallBack = object : DiffUtil.ItemCallback<Result>() {

        override fun areItemsTheSame(oldItem: Result, newItem: Result): Boolean { //verifica se os itens são os mesmos objetos
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Result, newItem: Result): Boolean { //se os itens possuem os mesmos dados
            return oldItem == newItem
        }
    }

    val differ= AsyncListDiffer(this, diffCallBack)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharactersViewHolder =
        CharactersViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context), parent,false
            )
        )

    override fun getItemCount(): Int = differ.currentList.size

    override fun onBindViewHolder(holder: CharactersViewHolder, position: Int) {
        with(holder) {
            with(differ.currentList[position]) {
                Glide.with(holder.itemView.context).load(thumbnail.path.plus("/landscape_amazing.jpg")).into(binding.ivCharacter)
                binding.tvNameCharacter.text = name

                holder.itemView.setOnClickListener {
                    onItemClickLister?.let {
                        it(this)
                    }
                }
            }
        }
    }

    private var onItemClickLister: ((Result) -> Unit)? = null

    fun setOnClickListener(listener: (Result) -> Unit) {
        onItemClickLister = listener
    }
}