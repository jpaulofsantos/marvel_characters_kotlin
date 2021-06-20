package com.example.marvelcharacters.presenter

import com.example.marvelcharacters.model.Result

interface ViewHome {

    interface View {
        fun showProgressBar()
        fun showFailure(message: String)
        fun hideProgressBar()
        fun showCharacteres(result: List<Result>)
    }
}