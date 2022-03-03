package com.example.blogapp2.Domain

import com.example.blogapp2.Core.Result
import com.example.blogapp2.Data.Model.Post

interface HomeScreenRepo {
    suspend fun getLatestPost():Result<List<Post>>
}