package com.nvt.moviedbapp.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nvt.moviedbapp.repository.MainRepository
import com.nvt.moviedbapp.ui.model.AllListMovie
import com.nvt.moviedbapp.ui.model.GenreMvDetail
import com.nvt.moviedbapp.ui.model.GenresMovie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class FragmentHomeViewModel : ViewModel(){

    private val mainRepository : MainRepository = MainRepository()
    private val compositeDisposable : CompositeDisposable = CompositeDisposable()

}