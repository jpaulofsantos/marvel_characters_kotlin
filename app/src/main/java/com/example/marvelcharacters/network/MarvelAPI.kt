package com.example.marvelcharacters.network
import com.example.marvelcharacters.model.Data
import com.example.marvelcharacters.util.Constants.Companion.API_PUBLIC_KEY
import com.example.marvelcharacters.util.Constants.Companion.HASH
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelAPI {

    @GET("/v1/public/characters")
    suspend fun getCharacters(
        @Query("ts")
        ts: Int =1,
        @Query("apiKey")
        apiKey: String = API_PUBLIC_KEY,
        @Query("hash")
        hash: String = HASH
    ): Response<Data>
}