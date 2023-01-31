package com.amin.wikipedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import cn.pedant.SweetAlert.SweetAlertDialog
import com.amin.wikipedia.databinding.DetailActivityBinding
import com.amin.wikipedia.dataclass.ItemPostDC
import com.bumptech.glide.Glide

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: DetailActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DetailActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain2)
        binding.collapsingAC2.setExpandedTitleColor(
            ContextCompat.getColor(
                this,
                android.R.color.transparent
            )
        )
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        binding.fabAnchor.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW , Uri.parse("https://en.wikipedia.org/wiki/Main_Page"))
            startActivity(intent)
        }

        val intent = intent.getParcelableExtra<ItemPostDC>(AppCons.SEND_DATA)
        if (intent != null){
            Glide.with(binding.root)
                .load(intent.imgUrl)
                .into(binding.imgViewDetailAC)
            binding.titleDetailAC.text = intent.txtTitle
            binding.subTitleDetailAC.text = intent.txtSubTitle
            binding.detailDetailAC.text = intent.txtDetail
        }

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
        }
        return true
    }

}
