package com.nvt.moviedbapp.ui.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.CompositePageTransformer
import androidx.viewpager2.widget.MarginPageTransformer
import com.nvt.moviedbapp.adapter.GroupGenMvTitleAdapter
import com.nvt.moviedbapp.adapter.TrendingViewPagerAdapter
import com.nvt.moviedbapp.databinding.HomeFragmentBinding
import com.nvt.moviedbapp.model.MovieModelDetail
import com.nvt.moviedbapp.repository.MainRepository
import com.nvt.moviedbapp.repository.vmfactory.MainVMFactory
import com.nvt.moviedbapp.ui.fragment.viewmodel.FragmentHomeViewModel


class HomeFragment : Fragment() {

    private lateinit var _bindingHomeF: HomeFragmentBinding
    private lateinit var fHomeViewModel: FragmentHomeViewModel
    private lateinit var adapterPaging: TrendingViewPagerAdapter
    private lateinit var groupGenMvTitleAdapter: GroupGenMvTitleAdapter
    private lateinit var listMovieGroup: HashMap<String, List<MovieModelDetail>>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bindingHomeF = HomeFragmentBinding.inflate(inflater, container, false)
        val viewHomeF = _bindingHomeF.root

        val factory = MainVMFactory(MainRepository)
        fHomeViewModel = ViewModelProvider(requireActivity(), factory)
            .get(FragmentHomeViewModel::class.java)

//        loadFakeListData()
        getTrendingList()
        loadFakeListData()

        getGroupItemView()
        return viewHomeF
    }

    private fun getGroupItemView() {


        fHomeViewModel.checkMvByGenredID()

        fHomeViewModel.listMovies.observe(viewLifecycleOwner) {
            groupGenMvTitleAdapter = GroupGenMvTitleAdapter(requireContext(),it)
            Log.d("GROUP", it.toString())
            var layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,
                false)
            _bindingHomeF.groupMvWithGenreName.layoutManager = layoutManager
            _bindingHomeF.groupMvWithGenreName.adapter = groupGenMvTitleAdapter
            groupGenMvTitleAdapter = GroupGenMvTitleAdapter(requireContext(), it)
            groupGenMvTitleAdapter.setData(it)

        }



    }

    private fun getTrendingList() {
        adapterPaging = TrendingViewPagerAdapter(requireContext(), listOf())
        _bindingHomeF.itemViewPagerTrending.adapter = adapterPaging

        fHomeViewModel.checkATrendingVpager()
        fHomeViewModel.listTrending.observe(viewLifecycleOwner) {
            adapterPaging.setData(it)
            Log.d("list", it.toString())
        }

    }

    private fun loadFakeListData() {
/*
        val travelLocations: MutableList<TravelLocation> = ArrayList()

        val travelLocationET = TravelLocation()
        travelLocationET.imageUrl =
            "https://images.unsplash.com/photo-1500297726361-1715d90aec00?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1047&q=80"
        travelLocationET.title = "China"
        travelLocationET.location = "Grate Wall of China"
        travelLocationET.startRating = 4.8f
        travelLocations.add(travelLocationET)

        val travelLocationMV = TravelLocation()
        travelLocationMV.imageUrl =
            "https://images.unsplash.com/photo-1567930009485-07d60c813306?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"
        travelLocationMV.title = "Mexico"
        travelLocationMV.location = "Chich??n Itz??"
        travelLocationMV.startRating = 4.5f
        travelLocations.add(travelLocationMV)

        val travelLocationTM = TravelLocation()
        travelLocationTM.imageUrl =
            "https://images.unsplash.com/photo-1589825274556-94746a018766?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"
        travelLocationTM.title = "Jordan"
        travelLocationTM.location = "Petra"
        travelLocationTM.startRating = 4.7f
        travelLocations.add(travelLocationTM)

        val travelLocationF = TravelLocation()
        travelLocationF.imageUrl =
            "https://images.unsplash.com/photo-1456244440184-1d494704a505?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1050&q=80"
        travelLocationF.title = "Peru"
        travelLocationF.location = "Machu Picchu"
        travelLocationF.startRating = 4.6f
        travelLocations.add(travelLocationF)

        val travelLocationFi = TravelLocation()
        travelLocationFi.imageUrl =
            "https://images.unsplash.com/photo-1595688878177-b72dfeeed683?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1151&q=80"
        travelLocationFi.title = "Brazil"
        travelLocationFi.location = "Christ the Redeemer"
        travelLocationFi.startRating = 4.6f
        travelLocations.add(travelLocationFi)

        val travelLocationS = TravelLocation()
        travelLocationS.imageUrl =
            "https://images.unsplash.com/photo-1482401204742-eb3c31c24722?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1112&q=80"
        travelLocationS.title = "Italy"
        travelLocationS.location = "Colosseum"
        travelLocationS.startRating = 4.7f
        travelLocations.add(travelLocationS)

        val travelLocationSe = TravelLocation()
        travelLocationSe.imageUrl =
            "https://images.unsplash.com/photo-1524492412937-b28074a5d7da?ixlib=rb-1.2.1&ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&auto=format&fit=crop&w=1051&q=80"
        travelLocationSe.title = "India"
        travelLocationSe.location = "Taj Mahal"
        travelLocationSe.startRating = 4.8f
        travelLocations.add(travelLocationSe)
 */

        _bindingHomeF.itemViewPagerTrending.setClipToPadding(false)
        _bindingHomeF.itemViewPagerTrending.setClipChildren(false)
        _bindingHomeF.itemViewPagerTrending.setOffscreenPageLimit(3)
        _bindingHomeF.itemViewPagerTrending.getChildAt(0)
            ?.setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER)

        val compositePageTransformer = CompositePageTransformer()
        compositePageTransformer.addTransformer(MarginPageTransformer(20))
        compositePageTransformer.addTransformer { page, position ->
            val r = 1 - Math.abs(position)
            page.scaleY = 0.90f + r * 0.04f
        }
        _bindingHomeF.itemViewPagerTrending.setPageTransformer(compositePageTransformer)
    }

}