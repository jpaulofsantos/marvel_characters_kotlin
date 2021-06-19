package com.example.marvelcharacters.model

import java.io.Serializable

data class Data(
    val count: Int,
    val limit: Int,
    val offset: Int,
    val results: MutableList<Result>,
    val total: Int
):Serializable