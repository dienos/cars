package jth.com.thetrive.ui.views.main

import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.MainActivityBinding
import jth.com.thetrive.ui.viewmodels.MainViewModel
import jth.com.thetrive.ui.views.base.BaseActivity
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlin.math.log

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding>() {
    private val viewModel: MainViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.main_activity

    override fun initializeViewModel() {
        binding?.lifecycleOwner = this
        binding?.viewModel = viewModel
    }

    override fun initializeUiEvent() {
        initBottomNavigation()

        /*lifecycleScope.launch {
            viewModel.getCollectionCars().collectLatest {
               Log.i("jth", "호출")
            }
        }*/
    }

    private fun initBottomNavigation() {
        binding?.triveNavigation?.let {
            NavigationUI.setupWithNavController(it, findNavController(R.id.trive_navigation_host))
        }
    }
}