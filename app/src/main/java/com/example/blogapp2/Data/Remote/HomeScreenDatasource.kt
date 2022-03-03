package com.example.blogapp2.Data.Remote

import android.util.Log
import com.example.blogapp2.Core.Result
import com.example.blogapp2.Data.Model.Post
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class HomeScreenDatasource {
    suspend fun getLatestPost():Result<List<Post>>{
        val postLt = mutableListOf<Post>()
        val querysnapshot = FirebaseFirestore.getInstance().collection("post").get().await()
        for(post in querysnapshot.documents){
            post.toObject(Post::class.java)?.let {
                postLt.add(it)
            }
        }
        Log.d("post", postLt.toString())
        return Result.Success(postLt)
    }
}