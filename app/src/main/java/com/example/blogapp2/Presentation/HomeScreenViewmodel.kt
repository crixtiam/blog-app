package com.example.blogapp2.Presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.blogapp2.Core.Result
import com.example.blogapp2.Domain.HomeScreenRepo
import kotlinx.coroutines.Dispatchers

class HomeScreenViewmodel(private val repo: HomeScreenRepo):ViewModel() {
    fun fetchLatestPost()= liveData(Dispatchers.IO) {
        emit(Result.Loading())
        try {
            emit(repo.getLatestPost())

        }catch (e:Exception){
            emit(Result.Failure(e))
        }

    }
}

class HomeScreenViewmodelFactory(private val repo: HomeScreenRepo):ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(HomeScreenRepo::class.java).newInstance(repo)
    }
}