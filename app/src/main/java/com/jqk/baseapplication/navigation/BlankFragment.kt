package com.jqk.baseapplication.navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.jqk.baseapplication.R
import com.jqk.baseapplication.databinding.FragmentBlankBinding
import com.jqk.common.base.BaseVBFragment

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class BlankFragment : BaseVBFragment<FragmentBlankBinding>() {
    private var param1: String? = null
    private var param2: String? = null

    override fun initViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentBlankBinding {
        return FragmentBlankBinding.inflate(inflater, container, false)
    }

    override fun initView(savedInstanceState: Bundle?) {
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }

        binding.jump2.setOnClickListener {
            findNavController().navigate(R.id.blankFragment2)
        }

        binding.jump3.setOnClickListener {
            findNavController().navigate(R.id.blankFragment3)
        }
    }

    override fun initData() {
    }

    override fun addLiveData() {

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment BlankFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            BlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}