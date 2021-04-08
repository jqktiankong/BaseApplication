package com.jqk.baseapplication.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.NavHostFragment
import com.jqk.baseapplication.R
import com.jqk.baseapplication.databinding.FragmentBlank2Binding
import com.jqk.common.base.BaseVBFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BlankFragment2 : BaseVBFragment<FragmentBlank2Binding>() {
    private val viewModel: BlankViewModel by viewModels()

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBlank2Binding {
        return FragmentBlank2Binding.inflate(inflater, container, false)
    }

    override fun initView(savedInstanceState: Bundle?) {
        mBinding.jump4.setOnClickListener {
            NavHostFragment.findNavController(this)
                .navigate(R.id.action_blankFragment2_to_blankFragment4)
        }

        mBinding.get.setOnClickListener {
            viewModel.getString2()
        }
    }

    override fun initData() {
        viewModel.getString()
    }

    override fun addLiveData() {
        viewModel.apply {
            stringLiveData.observe(this@BlankFragment2, Observer {

                mBinding.title.text = it
            })

            stringLiveData2.observe(this@BlankFragment2, Observer {

                mBinding.title.text = it
            })
        }
    }
}