package com.example.finit.repository

import com.example.finit.data.Post
import com.example.finit.data.PostsApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

internal class PostRepository {
    private val api = Retrofit.Builder()
        .baseUrl("https://jsonplaceholder.typicode.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(PostsApi::class.java)

    suspend fun getPosts(): List<Post> = api.getPosts()
}
