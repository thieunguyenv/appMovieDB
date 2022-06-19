package com.nvt.moviedbapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nvt.moviedbapp.repository.MainRepository
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FragmentHomeViewModel : ViewModel(){

    private val mainRepository : MainRepository = MainRepository()
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()


//    fun checkATrendingVpager(){
//        compositeDisposable.add(
//            mainRepository
//        )
//    }
}