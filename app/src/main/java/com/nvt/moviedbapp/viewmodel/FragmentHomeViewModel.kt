package com.nvt.moviedbapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nvt.moviedbapp.repository.MainRepository
import com.nvt.moviedbapp.model.TrendingMvModelDetail
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FragmentHomeViewModel(private val mainRepository : MainRepository) : ViewModel(){

//    private val mainRepository : MainRepository = MainRepository()
    val compositeDisposable : CompositeDisposable = CompositeDisposable()

    var listTrending = MutableLiveData<List<TrendingMvModelDetail>>()

    fun checkATrendingVpager(){
       compositeDisposable.add(
            mainRepository.getATrendingMv()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({
                    listTrending.postValue(it.results)
                },{
                    Log.d("Error",it.message.toString())
                })
        )
    }
}