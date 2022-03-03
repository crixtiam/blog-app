package com.example.blogapp2.UI.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.blogapp2.Core.Result

import com.example.blogapp2.Data.Remote.HomeScreenDatasource
import com.example.blogapp2.Domain.HomeScreenRepoImplement
import com.example.blogapp2.Presentation.HomeScreenViewmodel
import com.example.blogapp2.Presentation.HomeScreenViewmodelFactory
import com.example.blogapp2.R
import com.example.blogapp2.UI.adapter.HomeScreenAdapter
import com.example.blogapp2.databinding.FragmentHomeScreenBinding

class HomeScreenFragment : Fragment(R.layout.fragment_home_screen) {

    private lateinit var binding: FragmentHomeScreenBinding
    private val viewModel by viewModels<HomeScreenViewmodel> {
        //Inyeccion de dependencias
        HomeScreenViewmodelFactory(HomeScreenRepoImplement(HomeScreenDatasource()))
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentHomeScreenBinding.bind(view)

        viewModel.fetchLatestPost().observe(viewLifecycleOwner, Observer {result->
            when(result){
                is Result.Loading->{

                }
                is Result.Success->{
                    binding.rvHome.adapter=HomeScreenAdapter(result.data)
                }
                is Result.Failure->{
                    Toast.makeText(requireContext(),"Ocurrio un Error",Toast.LENGTH_LONG).show()
                }
            }
        })


    }
}