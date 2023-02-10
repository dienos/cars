package jth.com.thetrive.ui.views

import android.view.View
import androidx.activity.viewModels
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import dagger.hilt.android.AndroidEntryPoint
import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.MainActivityBinding
import jth.com.thetrive.ui.viewmodels.MainViewModel

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
    }

    private fun initBottomNavigation() {
        binding?.triveNavigation?.let {
            NavigationUI.setupWithNavController(it, findNavController(R.id.trive_navigation_host))
        }
    }
}