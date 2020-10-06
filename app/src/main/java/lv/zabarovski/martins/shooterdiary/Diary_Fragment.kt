package lv.zabarovski.martins.shooterdiary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_diary.*


class Diary_Fragment : Fragment(), AdapterClickListener {

    private val db get() = Database.getInstance(requireActivity())
    private val diaryItems = mutableListOf<DiaryData>()
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

        diaryItems.addAll(db.diaryNotesDao().getAllNotes())
        diaryItems.addAll(db.diaryImagesDao().getAllImages())

        adapter = DiaryRecAdapter(this,diaryItems)
        mainDiaryItems.adapter = adapter

//        itemAddButton.setOnClickListener { addDiaryItem() }

    }
    override fun noteDelClicked(item: ItemDiaryNote){
        db.diaryNotesDao().delete(item)
    }

    private fun addDiaryItem() {
        val item = ItemDiaryNote(
            "my title", System.currentTimeMillis(),
            "This is my random n ote")
        item.uid = db.diaryNotesDao().insertAllNotes(item).first()
        diaryItems.add(0, item)
//        diaryItems.sortBy {  }
        adapter.notifyDataSetChanged()
        mainDiaryItems.smoothScrollToPosition(0)
    }

    companion object{
        const val EXTRA_ID = "lv.zabarovski.martins.extras.diary_item_id"
        const val REQUEST_CODE_DETAILS = 12345
    }

}
interface AdapterClickListener {
    fun noteDelClicked(item: ItemDiaryNote)
//    fun imageDelClicked(item: ItemDiaryImage)
//    fun mantisxDelClicked(item: ItemDiaryMantisX)
}