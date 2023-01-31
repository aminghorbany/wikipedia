package com.amin.wikipedia

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.amin.wikipedia.databinding.ActivityMainBinding
import com.amin.wikipedia.fragments.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.toolbarMain)
        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this ,
            binding.drawerLayoutMain ,
            binding.toolbarMain ,
            R.string.open_drawer ,
            R.string.close_drawer
        )
        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        binding.navigationViewMain.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menuNDWriter ->{
                    replaceFrag(FragmentWriter())
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menuNDPhotographer ->{
                    replaceFrag(FragmentPhotographer())
//                    binding.navigationViewMain.menu.getItem(1).isChecked = true
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menuNDVideoMaker ->{
                    replaceFrag(FragmentVideoMaker())
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menuNDTranslator ->{
                    replaceFrag(FragmentTranslate())
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                //---------------
                R.id.menuNDOpenWikipedia ->{
                    val url = "https://www.wikipedia.org"
                    val intent = Intent(Intent.ACTION_VIEW , Uri.parse(url))
                    startActivity(intent)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
                R.id.menuNDOpenWikimedia ->{
                    val url = "https://www.wikimedia.org"
                    val intent = Intent(Intent.ACTION_VIEW , Uri.parse(url))
                    startActivity(intent)
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)
                }
            }
            true
        }
        firstRun()
        binding.bottomNavMain.setOnItemSelectedListener {
                when(it.itemId){
                R.id.menuBNExplore ->{
                    replaceFrag(FragmentExplore())
                }
                R.id.menuBNTrend ->{
                    replaceFrag(FragmentTrend())
                }
                R.id.menuBNProfile ->{
                    replaceFrag(FragmentProfile())
                }
            }
            binding.navigationViewMain.menu.getItem(1).isChecked = false
            true
        }
        binding.bottomNavMain.setOnItemReselectedListener {  }
    }
    private  fun replaceFrag (fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameMainContainer , fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private  fun addFrag (fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.add(R.id.frameMainContainer , fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
    private fun firstRun(){
        binding.bottomNavMain.selectedItemId = R.id.menuBNExplore
        replaceFrag(FragmentExplore())
    }
    override fun onBackPressed() {
        super.onBackPressed()
        binding.navigationViewMain.menu.getItem(1).isChecked = false
    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(R.menu.menu_above_right , menu)
//        return true
//    }
//
//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when(item.itemId){
//            R.id.menuARExplore ->{
//                Toast.makeText(this, "${item.title} selected", Toast.LENGTH_SHORT).show()
//            }
//            R.id.menuARTrend ->{
//                Toast.makeText(this, "${item.title} selected", Toast.LENGTH_SHORT).show()
//            }
//            R.id.menuARProfile ->{
//                Toast.makeText(this, "${item.title} selected", Toast.LENGTH_SHORT).show()
//            }
//        }
//        return true
//    }
}