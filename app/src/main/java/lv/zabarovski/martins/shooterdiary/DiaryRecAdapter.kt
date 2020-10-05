package lv.zabarovski.martins.shooterdiary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.small_item_image.view.*
import kotlinx.android.synthetic.main.small_item_note.view.*
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.small_item_mantisx.view.*
import java.time.format.DateTimeFormatter

class DiaryRecAdapter (private val items: MutableList<DiaryData>) :
    RecyclerView.Adapter<DiaryRecAdapter.DiaryViewHolder>(){

    abstract class DiaryViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        abstract fun bind(position: Int)
    }

    inner class NoteViewHolder(view: View) : DiaryViewHolder(view) {
        override fun bind(position: Int) {
            val item = items[position] as ItemDiaryNote
            itemView.itemDateNote.text = item.date.format(DateTimeFormatter.ISO_LOCAL_DATE).toString()
            itemView.itemTitleNote.text = item.title
            itemView.itemTextNote.text = item.note
        }
    }
    inner class ImageViewHolder(view: View) : DiaryViewHolder(view) {
        override fun bind(position: Int) {
            val item = items[position] as ItemDiaryImage
            itemView.itemDateImage.text = item.date.format(DateTimeFormatter.ISO_LOCAL_DATE).toString()
            itemView.itemTitleImage.text = item.title
            Glide.with(itemView)
                .load(item.image)
                .into(itemView.diaryImage)
        }
    }
    inner class MantisxViewHolder(view: View) : DiaryViewHolder(view) {
        override fun bind(position: Int) {
            val item = items[position] as ItemDiaryMantisX
            itemView.itemDateMantisX.text = item.date.format(DateTimeFormatter.ISO_LOCAL_DATE).toString()
            itemView.itemDrillMantisX.text = item.drill
            itemView.itemShootsMantisX.text = item.shoots.toString()
            itemView.itemScoreMantisX.text = item.score.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiaryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            DIARY_NOTE -> NoteViewHolder(inflater.inflate(R.layout.small_item_note, parent, false))
            DIARY_IMAGE -> ImageViewHolder(inflater.inflate(R.layout.small_item_image, parent, false))
            else -> MantisxViewHolder(inflater.inflate(R.layout.small_item_mantisx, parent, false))
        }
    }
    override fun getItemViewType(position: Int) =
        when (items[position]) {
            is ItemDiaryNote -> DIARY_NOTE
            is ItemDiaryImage -> DIARY_IMAGE
            else -> DIARY_MANTISX
        }

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: DiaryViewHolder, position: Int) {
        holder.bind(position)
        val item = items[position]
/*
        holder.itemView.keepClose.setOnClickListener {
            val currentPosition = items.indexOf(item)
            items.removeAt(currentPosition)
            notifyItemRemoved(currentPosition)
        }*/
    }

    companion object {
        private const val DIARY_NOTE = 0
        private const val DIARY_IMAGE = 1
        private const val DIARY_MANTISX = 2
    }



}