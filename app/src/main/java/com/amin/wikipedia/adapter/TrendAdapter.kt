package com.amin.wikipedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.amin.wikipedia.databinding.ItemRvExploreBinding
import com.amin.wikipedia.databinding.ItemRvTrendBinding
import com.amin.wikipedia.dataclass.ItemPostDC
import com.bumptech.glide.Glide
import java.util.ArrayList


class TrendAdapter(private val list :ArrayList<ItemPostDC> , private val onItemCliCKEvent: OnItemCliCKEvent) : RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    private lateinit var binding: ItemRvTrendBinding
    inner class TrendViewHolder(private val binding: ItemRvTrendBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(position: Int) {
            Glide.with(binding.root)
                .load(list[position].imgUrl)
                .into(binding.imgViewRVTrend)
            binding.txtTitleRvTrend.text = list[position].txtTitle
            binding.txtRVSubTitleTrend.text = list[position].txtSubTitle
            binding.txtRVInsightTrend.text = list[position].insight
            binding.txtCounterRVTrend.text= (adapterPosition + 1).toString()

            itemView.setOnClickListener {
                onItemCliCKEvent.onItemClick(list[position])
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendViewHolder {
        val binding = ItemRvTrendBinding.inflate(LayoutInflater.from(parent.context) , parent , false)
        return TrendViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TrendViewHolder, position: Int) {
        holder.bindData(position)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}