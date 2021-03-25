package com.example.webservice.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.webservice.R
import com.example.webservice.models.DataModel


class PostDetailsAdapter(private val context: Context, private val dataSet: List<DataModel>) :
    RecyclerView.Adapter<PostDetailsAdapter.ViewHolder>() {


    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postAuthorTextView: TextView = view.findViewById(R.id.name_TV)
        val postMsgTextView: TextView = view.findViewById(R.id.post_Msg_TV)
        val postImageView: ImageView = view.findViewById(R.id.post_IV)
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PostDetailsAdapter.ViewHolder {


        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount() = dataSet.size

    override fun onBindViewHolder(holder: PostDetailsAdapter.ViewHolder, position: Int) {
        holder.postAuthorTextView.text = dataSet[position].postName
        holder.postMsgTextView.text = dataSet[position].postMessage

        val profileImgURL = dataSet[position].postProfileImgURL
        Glide.with(context).load(profileImgURL).placeholder(R.drawable.ic_launcher_foreground)
            .into(holder.postImageView)

    }
}