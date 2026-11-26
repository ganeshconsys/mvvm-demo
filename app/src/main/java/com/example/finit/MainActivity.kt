package com.example.finit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.example.finit.ui.PostsScreen
import com.example.finit.ui.theme.FinItTheme
import com.example.finit.viewmodel.PostsViewModel

class MainActivity : ComponentActivity() {
    private val viewModel: PostsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            FinItTheme {
                Scaffold { innerPadding ->
                    PostsScreen(
                        posts = viewModel.posts,
                        isLoading = viewModel.isLoading,
                        errorMessage = viewModel.errorMessage,
                        onRetry = viewModel::loadPosts,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}
