package com.amin.wikipedia.adapter
import com.amin.wikipedia.dataclass.ItemPostDC

interface OnItemCliCKEvent {
    fun onItemClick(itemPostDC: ItemPostDC)
}