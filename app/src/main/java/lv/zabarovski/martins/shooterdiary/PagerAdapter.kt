package lv.zabarovski.martins.shooterdiary

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class PagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int {
        return NUMBERS_OF_PAGES
    }

    override fun createFragment(position: Int): Fragment {
        return if (position == 0) Timer_Fragment() else Diary_Fragment()
    }

    companion object {
        const val NUMBERS_OF_PAGES = 2
    }
}