package com.freeware.pdfconverter.activities

import android.annotation.SuppressLint
import com.freeware.pdfconverter.databinding.ActivitySplashBinding

@SuppressLint("CustomSplashScreen")
class SplashActivity : BaseActivity<ActivitySplashBinding>() {

    override fun initViews() {
        binding.mainText.text = javaClass.simpleName
    }

    override fun createViewBinding(): ActivitySplashBinding {
        return ActivitySplashBinding.inflate(layoutInflater)
    }
}