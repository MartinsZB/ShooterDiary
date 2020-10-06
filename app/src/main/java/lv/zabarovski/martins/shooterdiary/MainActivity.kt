package lv.zabarovski.martins.shooterdiary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val db get() = Database.getInstance(this)
        val adapter = PagerAdapter(this)

        pagerView.adapter = adapter

        TabLayoutMediator(tabLayout, pagerView) { tab, position ->
            if (position == 0){
                tab.text = getString(R.string.timer_pager)
            }else if (position == 1){
                tab.text = getString(R.string.diary_pager)
            }

        }.attach()
    }
}

