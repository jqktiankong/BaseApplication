package com.jqk.baseapplication.navigation

import android.os.Bundle
import androidx.navigation.findNavController
import com.jqk.baseapplication.R
import com.jqk.baseapplication.databinding.ActivityNavigationMainBinding
import com.jqk.common.base.BaseVBActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseVBActivity<ActivityNavigationMainBinding>() {
    override fun initViewBinding(): ActivityNavigationMainBinding {
        return ActivityNavigationMainBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.jump2.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("myArg", 1)

            findNavController(R.id.navHostFragment).navigate(R.id.blankFragment2, bundle)
        }

        binding.jump3.setOnClickListener {
            val bundle = Bundle()
            bundle.putInt("myArg", 1)

            findNavController(R.id.navHostFragment).navigate(R.id.blankFragment3, bundle)
        }
    }

    override fun initData() {
    }

    override fun addLiveData() {
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (findNavController(R.id.navHostFragment).previousBackStackEntry == null) {
            finish()
        }
    }
}