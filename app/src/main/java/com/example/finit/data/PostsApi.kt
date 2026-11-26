package com.example.finit.data

import retrofit2.http.GET

internal interface PostsApi {
    @GET("posts")
    suspend fun getPosts(): List<Post>
}
