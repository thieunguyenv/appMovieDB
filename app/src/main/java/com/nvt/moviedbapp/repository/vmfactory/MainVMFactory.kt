package com.nvt.moviedbapp.repository.vmfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nvt.moviedbapp.repository.IRepository
import com.nvt.moviedbapp.repository.MainRepository

class MainVMFactory(private val iRepository: IRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(MainRepository::class.java).newInstance(iRepository)
    }
}