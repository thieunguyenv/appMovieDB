package com.nvt.moviedbapp



import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.nvt.moviedbapp.databinding.ActivityMainBinding
import com.nvt.moviedbapp.ui.fragment.HomeFragment


class MainActivity : AppCompatActivity() {


    lateinit var _bindingMain : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
        _bindingMain = ActivityMainBinding.inflate(layoutInflater)
        val view = _bindingMain.root
        setContentView(view)

        val fragment = HomeFragment()
        loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment) {
        // load fragment
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_layout_host, fragment)
        transaction.commit()
    }
}