package com.example.marvelcharacters.presenter

import com.example.marvelcharacters.model.MarvelResponse
import com.example.marvelcharacters.model.data.CharactersDataSource

class CharacterPresenter(
    val view: ViewHome.View,
    private val dataSource: CharactersDataSource): CharacterHome.Presenter {

    override fun requestCharacters() {
        this.view.showProgressBar()
        this.dataSource.getCharacters(this)
    }

    override fun onSucess(response: MarvelResponse) {
        this.view.showCharacteres(response.data.results)
    }

    override fun onError(message: String) {
        this.view.showFailure(message)
    }

    override fun onComplete() {
        this.view.hideProgressBar()
    }
}