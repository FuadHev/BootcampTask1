package com.fuadhev.mybootcamp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.fuadhev.mybootcamp.common.utils.Extensions.gone
import com.fuadhev.mybootcamp.common.utils.Extensions.goneEach
import com.fuadhev.mybootcamp.common.utils.Extensions.visible
import com.fuadhev.mybootcamp.common.utils.Extensions.visibleEach
import com.fuadhev.mybootcamp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navHostFragment.navController
        NavigationUI.setupWithNavController(binding.bottomMenu, navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->

            with(binding){
                when (destination.id) {
                    R.id.profileFragment->{

                        listOf(homeHeader,bottomMenu).goneEach()
                        profileHeader.visible()
                    }
                    R.id.homeFragment->{
                        listOf(homeHeader,bottomMenu,txt66,anaseyfe).visibleEach()
                        listOf(profileHeader,serviceTxt).goneEach()
//                        homeHeader.visible()
//                        profileHeader.gone()
//                        bottomMenu.visible()
//                        txt66.visible()
//                        anaseyfe.visible()
//                        serviceTxt.gone()

                    }
                    R.id.servicesFragment->{

                        listOf(homeHeader,bottomMenu,serviceTxt).visibleEach()
                        listOf(profileHeader,txt66,anaseyfe).goneEach()
                        serviceTxt.text=resources.getString(R.string.xidm_tl_r)
//                        homeHeader.visible()
//                        profileHeader.gone()
//                        bottomMenu.visible()
//                        txt66.gone()
//                        anaseyfe.gone()
//                        serviceTxt.visible()
                    }
                    R.id.othersFragment->{
                        listOf(homeHeader,bottomMenu,serviceTxt).visibleEach()
                        listOf(profileHeader,txt66,anaseyfe).goneEach()
                        serviceTxt.text=resources.getString(R.string.diger)

                    }
                    R.id.quickQuestionsFragment->{

                        listOf(homeHeader,bottomMenu,serviceTxt).visibleEach()
                        listOf(profileHeader,txt66,anaseyfe).goneEach()
                        serviceTxt.text=resources.getString(R.string.question_txt)

                    }


                    else -> { binding.bottomMenu.visible() }
                }
            }


        }


        binding.profileIc.setOnClickListener {
          val navControl=findNavController(R.id.fragmentContainerView)
            navControl.navigate(R.id.profileFragment)
        }
        binding.btnBack.setOnClickListener{
            val navControl=findNavController(R.id.fragmentContainerView)
            navControl.popBackStack()
        }

    }
}