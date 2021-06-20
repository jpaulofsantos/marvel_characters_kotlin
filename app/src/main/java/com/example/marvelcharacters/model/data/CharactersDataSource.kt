package com.example.marvelcharacters.model.data

import android.content.Context
import com.example.marvelcharacters.network.RetrofitInstance
import com.example.marvelcharacters.presenter.CharacterHome
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class CharactersDataSource(context: Context) {

    fun getCharacters(callback: CharacterHome.Presenter) {
        GlobalScope.launch(Dispatchers.Main) {
            val charactersResponse = RetrofitInstance.api.getCharacters()
            if (charactersResponse.isSuccessful) {
                charactersResponse.body()?.let {
                    callback.onSucess(it)
                }
                callback.onComplete()
            } else {
                callback.onError(charactersResponse.message())
                callback.onComplete()
            }
        }
    }
}