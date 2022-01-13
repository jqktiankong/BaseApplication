package com.jqk.baseapplication

import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.load
import coil.transform.RoundedCornersTransformation
import com.jqk.baseapplication.databinding.ActivityCoilBinding
import com.jqk.common.base.BaseVBActivity
import kotlinx.coroutines.Dispatchers

/**
 *  author : jiqingke
 *  date : 2022/01/13 14:39
 *  description :
 */
class CoilActivity : BaseVBActivity<ActivityCoilBinding>() {
    override fun initViewBinding(): ActivityCoilBinding {
        return ActivityCoilBinding.inflate(layoutInflater)
    }

    override fun initView(savedInstanceState: Bundle?) {
        binding.ivNormal.load(R.drawable.img) {
            crossfade(true)
            placeholder(R.drawable.img)
            transformations(RoundedCornersTransformation(10F))
        }

        val imageLoader = ImageLoader.Builder(this)
            .componentRegistry {
                if (SDK_INT >= 28) {
                    add(ImageDecoderDecoder(this@CoilActivity))
                } else {
                    add(GifDecoder())
                }
            }
            .build()

        binding.ivGif.load(R.drawable.test, imageLoader)
    }

    override fun initData() {

    }

    override fun addLiveData() {

    }
}