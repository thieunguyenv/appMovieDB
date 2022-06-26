package com.nvt.moviedbapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nvt.moviedbapp.model.MovieModelDetail
import com.nvt.moviedbapp.repository.MainRepository
import com.nvt.moviedbapp.model.TrendingMvModelDetail
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FragmentHomeViewModel(private val mainRepository : MainRepository) : ViewModel(){



    //    private val mainRepository : MainRepository = MainRepository()
    val compositeDisposable : CompositeDisposable = CompositeDisposable()

    var listTrending = MutableLiveData<List<TrendingMvModelDetail>>()

    var listMovies = MutableLiveData<HashMap<String,List<MovieModelDetail>>>()
   val map = HashMap<String,List<MovieModelDetail>>()

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

    fun checkMvByGenredID(){
       compositeDisposable.add(
           mainRepository.getAGenres()
               .flatMapObservable { listGenre -> Observable.fromIterable(listGenre.genres)  }
               .flatMapSingle { item -> mainRepository.getMvWithGenresID(item.id)
                   .map { item.name to it }}
               .subscribeOn(Schedulers.io())
               .observeOn(AndroidSchedulers.mainThread())
               .subscribe({
                   map.put(it.first,it.second.results)
               },{
                    Log.d("ECombine",it.message.toString())
               },{
                    listMovies.postValue(map)
                   val result =  listMovies.postValue(map)
                   Log.d("Result",result.toString())
               })
       )
    }
}


