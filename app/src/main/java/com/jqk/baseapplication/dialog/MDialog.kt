package com.jqk.baseapplication.dialog

import android.content.DialogInterface
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import com.cvnavi.settings.expand.setOnThrottledClickListener
import com.jqk.baseapplication.databinding.DialogMBinding
import com.jqk.common.base.BaseDialogFragment

/**
 *  author : jiqingke
 *  date : 2021/06/05 10:51
 *  description :
 */
class MDialog : BaseDialogFragment<DialogMBinding>() {
    override fun initViewBinding(inflater: LayoutInflater, container: ViewGroup?): DialogMBinding {
        return DialogMBinding.inflate(inflater, container, false)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.btPositive.setOnThrottledClickListener {
            positiveClick?.invoke()
            dismiss()
        }

        binding.btMiddle.setOnThrottledClickListener {
            middleClick?.invoke()
            dismiss()
        }

        binding.btNegative.setOnThrottledClickListener {
            negativeClick?.invoke()
            dismiss()
        }

    }

    override fun initData() {
        val str = arguments?.getString(EXTRA_xxx)
    }

    override fun onDismiss(dialog: DialogInterface) {
        super.onDismiss(dialog)
        isShow = false
    }

    companion object {
        const val EXTRA_xxx = "xxx"

        var isShow = false

        fun show(
            fragmentManager: FragmentManager,
            positiveClick: (() -> Unit),
            negativeClick: (() -> Unit),
            middleClick: (() -> Unit)
        ) {
            val instance = MDialog()

            val ft = fragmentManager.beginTransaction()

            val bundle = Bundle()
            bundle.putString(EXTRA_xxx, "123")
            instance.arguments = bundle

            ft.add(instance, "MDialog")
            if (!isShow) {
                ft.commitAllowingStateLoss()
                instance.setOnDialogClickListener(positiveClick, negativeClick, middleClick)
            }
        }
    }
}