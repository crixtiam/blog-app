package com.example.blogapp2.Domain


import com.example.blogapp2.Core.Result
import com.example.blogapp2.Data.Model.Post
import com.example.blogapp2.Data.Remote.HomeScreenDatasource

class HomeScreenRepoImplement(private val dataSource: HomeScreenDatasource):HomeScreenRepo {
    override suspend fun getLatestPost(): Result<List<Post>> = dataSource.getLatestPost()
}