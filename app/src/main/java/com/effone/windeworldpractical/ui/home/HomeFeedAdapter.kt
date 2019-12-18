package com.effone.windeworldpractical.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.effone.windeworldpractical.R
import com.effone.windeworldpractical.data.model.Children
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_login.view.*
import kotlinx.android.synthetic.main.rv_home_feed_row.view.*

class HomeFeedAdapterclass(val context: Context, var children: ArrayList<Children>) :
    androidx.recyclerview.widget.RecyclerView.Adapter<HomeFeedViewHolder>() {

    override fun getItemCount(): Int {


        return children.size
    }


    override fun onCreateViewHolder(parent: ViewGroup, p1: Int): HomeFeedViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rowObject = layoutInflater.inflate(R.layout.rv_home_feed_row, parent, false)
        return HomeFeedViewHolder(rowObject)
    }

    override fun onBindViewHolder(holder: HomeFeedViewHolder, position: Int) {

        val child = children.get(position)
        holder.itemView.tv_home_title.text = child.data.title
        holder.itemView.tv_home_desc.text = child.data.subreddit
        Picasso.with(holder.itemView.context).load(child.data.secure_media.oembed.thumbnail_url)
            .into(holder.itemView.iv_wew_home)


    }

}


class HomeFeedViewHolder(view: View) : androidx.recyclerview.widget.RecyclerView.ViewHolder(view)