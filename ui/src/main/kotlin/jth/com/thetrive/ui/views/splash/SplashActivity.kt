package jth.com.thetrive.ui.views.splash

import android.animation.Animator
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import dagger.hilt.android.AndroidEntryPoint
import jth.com.thetrive.ui.R
import jth.com.thetrive.ui.databinding.SplashActivityBinding
import jth.com.thetrive.ui.utils.NetworkUtil
import jth.com.thetrive.ui.views.main.MainActivity
import javax.inject.Inject

@SuppressLint("CustomSplashScreen")
@AndroidEntryPoint
class SplashActivity : AppCompatActivity() {
    @Inject
    lateinit var networkUtil: NetworkUtil

    var binding: SplashActivityBinding? = null
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.splash_activity)

        networkUtil.currentContext = this
        networkUtil.registerNetworkCallback()

        if (networkUtil.checkNetwork()) {
            binding?.splash?.addAnimatorListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}

                override fun onAnimationEnd(animation: Animator) {
                    startMain()
                }

                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationRepeat(animation: Animator) {}
            })

            binding?.splash?.playAnimation()
        } else {
            networkUtil.networkNotConnect()
        }
    }

    fun startMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }
}