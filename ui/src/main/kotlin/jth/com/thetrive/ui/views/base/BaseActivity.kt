package jth.com.thetrive.ui.views.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import jth.com.thetrive.ui.utils.NetworkUtil
import jth.com.thetrive.ui.views.dialog.ProgressDialog
import javax.inject.Inject

abstract class BaseActivity<T : ViewDataBinding?> : AppCompatActivity() {
    @LayoutRes
    abstract fun getLayoutResId(): Int
    abstract fun initializeViewModel()
    abstract fun initializeUiEvent()

    protected val progress = ProgressDialog()

    @Inject
    lateinit var networkUtil: NetworkUtil

    var binding: T? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding?.lifecycleOwner = this
        binding = DataBindingUtil.setContentView(this, getLayoutResId())
        initializeViewModel()
        initializeUiEvent()
        networkUtil.currentContext = this
        networkUtil.registerNetworkCallback()
    }

    override fun onDestroy() {
        super.onDestroy()
        networkUtil.terminateNetworkCallback(this)
        binding = null
    }
}