package ru.netology.diplomchina.data

import androidx.lifecycle.LiveData
import ru.netology.diplomchina.db.PostDao
import ru.netology.diplomchina.db.PostEntity

class PostRepository(private val postDao: PostDao) {

    fun getAllPosts(): LiveData<List<PostEntity>> {
        return postDao.getAllPosts()
    }

    suspend fun createPost(post: PostEntity) {
        postDao.createPost(post)
    }
}