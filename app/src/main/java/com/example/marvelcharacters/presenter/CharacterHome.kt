package com.example.marvelcharacters.presenter

import com.example.marvelcharacters.model.Data
import com.example.marvelcharacters.model.MarvelResponse


interface CharacterHome {

    interface Presenter{
        fun requestCharacters()
        fun onSucess(response: MarvelResponse)
        fun onError(message: String)
        fun onComplete()
    }
}