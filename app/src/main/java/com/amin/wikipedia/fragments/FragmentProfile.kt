package com.amin.wikipedia.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.amin.wikipedia.R
import com.amin.wikipedia.databinding.FragmentExploreBinding
import com.amin.wikipedia.databinding.FragmentProfileBinding
import com.google.android.material.card.MaterialCardView

class FragmentProfile : Fragment() {

    private lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProfileBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//instagram
        binding.imageViewInstagram.setOnClickListener {
            val url = "https://instagram.com/realaminghorbany"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
        binding.txtInstagram.setOnClickListener {
            val url = "https://instagram.com/realaminghorbany"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            startActivity(intent)
        }
// contact
        binding.imageViewContact.setOnClickListener {
            val url = "+989037052133"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel" , url , null))
            startActivity(intent)
        }
        binding.txtPhoneNumber.setOnClickListener {
            val url = "+989037052133"
            val intent = Intent(Intent.ACTION_DIAL, Uri.fromParts("tel" , url , null))
            startActivity(intent)
        }
    }


}