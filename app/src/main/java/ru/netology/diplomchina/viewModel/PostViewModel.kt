package ru.netology.diplomchina.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import ru.netology.diplomchina.data.PostRepository
import ru.netology.diplomchina.db.AppDb
import ru.netology.diplomchina.db.PostEntity

class PostViewModel(application: Application): AndroidViewModel(application) {
    private val repository = PostRepository(AppDb.getInstance(application).postDao())


    val postList = repository.getAllPosts()

    fun savePost(post: PostEntity) {
        viewModelScope.launch {
            repository.createPost(post)

        }
    }

}