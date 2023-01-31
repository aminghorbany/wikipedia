package com.amin.wikipedia.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ItemPostDC(
    val imgUrl :String ,
    val txtTitle:String ,
    val txtSubTitle:String ,
    val txtDetail:String ,
    // ----
    val isTrend:Boolean ,
    val insight:String
) : Parcelable
