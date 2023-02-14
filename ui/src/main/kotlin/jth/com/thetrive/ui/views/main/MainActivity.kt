package jth.com.thetrive.ui.views.main

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

@AndroidEntryPoint
class MainActivity : BaseActivity<MainActivityBinding>() {
    private val viewModel: MainViewModel by viewModels()

    override fun getLayoutResId(): Int = R.layout.main_activity

    override fun initializeViewModel() {
        binding?.viewModel = viewModel
    }

    override fun initializeUiEvent() {
        initBottomNavigation()

        binding?.lifecycleOwner?.lifecycleScope?.launch {

            viewModel.toastFlow.collectLatest { msg ->
                if (msg.isNotEmpty()) {
                    Toast.makeText(applicationContext, msg, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    private fun initBottomNavigation() {
        binding?.triveNavigation?.let {
            NavigationUI.setupWithNavController(it, findNavController(R.id.trive_navigation_host))
        }
    }
}