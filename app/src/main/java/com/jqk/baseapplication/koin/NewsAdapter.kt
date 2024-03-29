package com.jqk.baseapplication.koin

import android.content.Context
import android.os.Trace
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.bumptech.glide.Glide
import com.jqk.baseapplication.databinding.ItemNewsBinding
import com.jqk.common.network.retrofit.bean.News

class NewsAdapter(private val context: Context, private val dataList: List<News.Result.Data>) :
    RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return try {
            Trace.beginSection("NewsAdapter.onCreateViewHolder")
            ViewHolder(ItemNewsBinding.inflate(LayoutInflater.from(parent.context)))
        } finally {
            Trace.endSection()
        }
    }

    override fun getItemCount(): Int {
        return dataList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Trace.beginSection("NewsAdapter.onBindViewHolder")
        ItemNewsBinding.bind(holder.itemView).apply {
            dataList[position].let {
                tvTitle.text = it.title
                tvCategory.text = it.category
                tvDate.text = it.date

                Glide.with(context).load(it.thumbnail_pic_s).into(ivIcon)
            }
        }
        Trace.endSection()
    }

    class ViewHolder(viewBinding: ViewBinding) : RecyclerView.ViewHolder(viewBinding.root)
}