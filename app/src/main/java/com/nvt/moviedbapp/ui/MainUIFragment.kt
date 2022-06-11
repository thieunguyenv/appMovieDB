package com.nvt.moviedbapp.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.nvt.moviedbapp.R
import com.nvt.moviedbapp.databinding.MainFragmentBinding

class MainUIFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = layoutInflater.inflate(R.layout.main_fragment,container,false)
        return view
    }
}