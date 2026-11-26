package com.example.finit.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finit.data.Post
import com.example.finit.repository.PostRepository
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.launch

class PostsViewModel : ViewModel() {
    private val repository = PostRepository()

    var posts by mutableStateOf<List<Post>>(emptyList())
        private set

    var isLoading by mutableStateOf(false)
        private set

    var errorMessage by mutableStateOf<String?>(null)
        private set

    init {
        loadPosts()
    }

    fun loadPosts() {
        if (isLoading) return
        isLoading = true
        errorMessage = null
        viewModelScope.launch {
            try {
                posts = repository.getPosts()
            } catch (exception: CancellationException) {
                throw exception
            } catch (_: Exception) {
                errorMessage = "Couldn't load posts."
            } finally {
                isLoading = false
            }
        }
    }
}
