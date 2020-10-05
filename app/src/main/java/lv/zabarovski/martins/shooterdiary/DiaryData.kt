package lv.zabarovski.martins.shooterdiary

import android.annotation.SuppressLint
import java.time.LocalDateTime
import java.util.Random

sealed class DiaryData
data class ItemDiaryImage(val title: String, val date: LocalDateTime, val note: String, val image: String) :
        DiaryData()
data class ItemDiaryNote(val title: String, val date: LocalDateTime, val note: String) : DiaryData()
data class ItemDiaryMantisX(
        val drill: String, val date: LocalDateTime, val shoots: Int, val score: Double,
        val fireType: String, val hand: String, val firearm: String, val note: String): DiaryData()



/*
object RandomData {

    private val random = Random()

    private const val LOREM =
        "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt " +
                "ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud " +
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute " +
                "irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat " +
                "nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa " +
                "qui officia deserunt mollit anim id est laborum."

    private const val LIST_SIZE = 10

    private val randomLorem
        get() = LOREM.take(random.nextInt(LOREM.length))

    private val randomTitle
        @SuppressLint("DefaultLocale")
        get() = with(LOREM.split(" ")) {
            this[random.nextInt(size)].capitalize()
        }

    private val uris = listOf(
        "https://p.kindpng.com/picc/s/72-722801_bread-roll-png-roll-of-bread-png-transparent.png",
        "https://atlas-content-cdn.pixelsquid.com/stock-images/bowl-with-eggs-egg-xwVrGL4-600.jpg",
        "https://atlas-content-cdn.pixelsquid.com/stock-images/glass-of-milk-2MEn1r7-600.jpg",
        "https://www.netclipart.com/pp/m/76-768140_freshly-fresh-potatoes-fresh-potatoes-png.png"
    )

    private val randomUri
        get() = uris[random.nextInt(uris.size)]

    private val randomSize
        get() = random.nextInt(LIST_SIZE)

    private val randomItem
        get() = when (random.nextInt(3)) {
            0 -> noteItem
            1 -> imageItem
            else -> mantisXItem
        }

    val items
        get() = MutableList(randomSize) { randomItem }

    val noteItem get() = ItemDiaryNote(randomTitle, LocalDateTime.now(),randomLorem)

    val imageItem get() = ItemDiaryImage(randomTitle, LocalDateTime.now(), randomLorem,
        randomUri)

    val mantisXItem get() = ItemDiaryMantisX(randomTitle, LocalDateTime.now(), 10,93.67,
        randomTitle, randomTitle, randomTitle, randomLorem)

}*/
