package com.amin.wikipedia.fragments

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.amin.wikipedia.AppCons
import com.amin.wikipedia.DetailActivity
import com.amin.wikipedia.adapter.ExploreAdapter
import com.amin.wikipedia.adapter.OnItemCliCKEvent
import com.amin.wikipedia.databinding.FragmentExploreBinding
import com.amin.wikipedia.databinding.FragmentPhotographerBinding
import com.amin.wikipedia.dataclass.ItemPostDC

class FragmentPhotographer : Fragment() {

    private lateinit var binding: FragmentPhotographerBinding
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentPhotographerBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}