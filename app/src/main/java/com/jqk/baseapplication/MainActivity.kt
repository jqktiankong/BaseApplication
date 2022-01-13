package com.jqk.baseapplication

import android.content.Intent
import android.os.Bundle
import android.os.Trace
import com.jqk.baseapplication.compose.ComposeActivity
import com.jqk.baseapplication.databinding.ActivityMainBinding
import com.jqk.baseapplication.hilt.news.NewsActivity
import com.jqk.baseapplication.navigation.MainActivity
import com.jqk.common.base.BaseVBActivity

/**
 *  author : jiqingke
 *  date : 2021/12/23 13:59
 *  description :
 */
class MainActivity : BaseVBActivity<ActivityMainBinding>() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Trace.beginSection("MainActivity begin")
        super.onCreate(savedInstanceState)
    }


    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)

        if (hasFocus) {
            Trace.endSection()
        }
    }


    override fun initViewBinding(): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.apply {
            btCommon.setOnClickListener {
                startActivity(Intent(this@MainActivity, CommonActivity::class.java))
            }

            btDialog.setOnClickListener {
                startActivity(Intent(this@MainActivity, DialogActivity::class.java))
            }

            btHilt.setOnClickListener {
                startActivity(Intent(this@MainActivity, NewsActivity::class.java))
            }

            btKoin.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        com.jqk.baseapplication.koin.NewsActivity::class.java
                    )
                )
            }

            btNavigation.setOnClickListener {
                startActivity(Intent(this@MainActivity, MainActivity::class.java))
            }

            btJsbridge.setOnClickListener {
                startActivity(
                    Intent(
                        this@MainActivity,
                        com.jqk.baseapplication.web.MainActivity::class.java
                    )
                )
            }

            btCompose.setOnClickListener {
                startActivity(Intent(this@MainActivity, ComposeActivity::class.java))
            }

            btCoil.setOnClickListener {
                startActivity(Intent(this@MainActivity, CoilActivity::class.java))
            }
        }
    }

    override fun initData() {
    }

    override fun addLiveData() {
    }
}