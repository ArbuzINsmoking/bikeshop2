package com.example.bikeshop.domain.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bikeshop.R
import com.example.bikeshop.domain.model.PostModel
import com.example.bikeshop.presentation.bikeshopDetail.ZooActivity
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class PostAdapter(private val postModel: MutableList<PostModel>): RecyclerView.Adapter<PostViewHandler>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHandler {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return PostViewHandler(view)
    }
    override fun getItemCount(): Int {
        return postModel.size
    }
    override fun onBindViewHolder(holder: PostViewHandler, position: Int) {
        val post = postModel[position]
        holder.openButton.setOnClickListener {
            val intent = Intent(holder.itemView.context, ZooActivity::class.java)
            intent.putExtra("name",postModel[position].name.toString())
            intent.putExtra("color",postModel[position].color.toString())
            intent.putExtra("pic",postModel[position].pic.toString())
            intent.putExtra("price",postModel[position].price.toString())
            holder.itemView.context.startActivity(intent)
        }

        return holder.bindView(postModel[position])
    }
}

class PostViewHandler(itemView: View): RecyclerView.ViewHolder(itemView){

    //-------------------------------------------//
    private val tvHeading: TextView = itemView.findViewById(R.id.tvHeading)
    private val price: TextView = itemView.findViewById(R.id.price)
    private val imageView: ShapeableImageView = itemView.findViewById(R.id.title_image)
    val openButton: Button = itemView.findViewById(R.id.openButton)


    fun bindView(postModel: PostModel) {

        tvHeading.text = postModel.name
        price.text = postModel.price.toString()

        Picasso.get()
            .load(postModel.pic)
            .into(imageView)
    }

}