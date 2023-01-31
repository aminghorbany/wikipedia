package com.amin.wikipedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amin.wikipedia.databinding.ItemRvExploreBinding
import com.amin.wikipedia.dataclass.ItemPostDC
import com.bumptech.glide.Glide
import java.util.ArrayList


class ExploreAdapter(private val list :ArrayList<ItemPostDC> , private val onItemCliCKEvent: OnItemCliCKEvent) : RecyclerView.Adapter<ExploreAdapter.ExploreViewHolder>() {
    private lateinit var binding: ItemRvExploreBinding
    inner class ExploreViewHolder(private val binding: ItemRvExploreBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(position: Int) {
            Glide.with(itemView.context)
                .load(list[position].imgUrl)
                .into(binding.imgViewRV)
            binding.titleRVExplore.text = list[position].txtTitle
            binding.subTitleRVExplore.text = list[position].txtSubTitle
            binding.detailRVExplore.text = list[position].txtDetail
            itemView.setOnClickListener {
                onItemCliCKEvent.onItemClick(list[position])
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExploreViewHolder {
        val binding = ItemRvExploreBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return ExploreViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ExploreViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}