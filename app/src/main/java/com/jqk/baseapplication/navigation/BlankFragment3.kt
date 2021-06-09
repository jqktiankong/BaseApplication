package com.jqk.baseapplication.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import com.jqk.baseapplication.R
import com.jqk.baseapplication.databinding.FragmentBlank3Binding
import com.jqk.common.expand.viewBinding

class BlankFragment3 : Fragment(R.layout.fragment_blank3) {
    private val binding by viewBinding(FragmentBlank3Binding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.jump5.setOnClickListener {
            findNavController().navigate(R.id.blankFragment6)
        }
    }
}