package lv.zabarovski.martins.shooterdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_diary.*
import java.time.LocalDateTime
import lv.zabarovski.martins.shooterdiary.RandomData.items as randomDataItems

class Diary_Fragment : Fragment()  {

    private val diaryItems = RandomData.items

    private lateinit var adapter: DiaryRecAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_diary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = DiaryRecAdapter(diaryItems)
        mainDiaryItems.adapter = adapter

       itemAddButton.setOnClickListener { addRandomDiaryItem(RandomData.noteItem) }

    }
    private fun addRandomDiaryItem(item: DiaryData) {
        diaryItems.add(0, item)
        //adapter.notifyDataSetChanged()
        adapter.notifyItemInserted(0)
        mainDiaryItems.smoothScrollToPosition(0)
    }


}