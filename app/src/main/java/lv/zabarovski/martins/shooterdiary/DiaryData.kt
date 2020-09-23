package lv.zabarovski.martins.shooterdiary

import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import kotlin.random.Random


sealed class DiaryData
data class ItemDiaryImage(val title: String, val date: String, val note: String, val image: String) : DiaryData
data class ItemDiaryNote(val title: String, val date: String, val note: String) : DiaryData
data class ItemDiaryMantisX(val drill: String, val date: String, val shoots: Int, val score: Double, val fireType: String, val hand: String, val firearm: String, val note: String)

private val titles = listOf("Trenniņš 1","Sacensības Ādažos","Sausais trenniņš","Šautuve")
private val dates = LocalDateTime.now()
private val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm")
private val notes = "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque " +
        "corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia " +
        "deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, " +
        "cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, " +
        "omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates " +
        "repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores " +
        "alias consequatur aut perferendis doloribus asperiores repellat."
private val imageUris = listOf(
    "https://p.kindpng.com/picc/s/72-722801_bread-roll-png-roll-of-bread-png-transparent.png",
    "https://atlas-content-cdn.pixelsquid.com/stock-images/bowl-with-eggs-egg-xwVrGL4-600.jpg",
    "https://atlas-content-cdn.pixelsquid.com/stock-images/glass-of-milk-2MEn1r7-600.jpg",
    "https://www.netclipart.com/pp/m/76-768140_freshly-fresh-potatoes-fresh-potatoes-png.png")
private val drills = listOf("Open Training","MantisX Benchmark","Compressed Surprise Break","Primary Hand Only")
private val shootsCount = listOf(10,7,6,5,20)
private val scores = listOf(82.13,89.41,91.54,94.35,93.24)
private val fireTypes = listOf("live fire","dry practice")
private val hands = listOf("Right","Left")
private val firearms = "Walther Arms Inc P99 AS 9x19mm"

private val randomImage
    get() = imageUris[Random().nextInt(imageUris.size)]
private val randomTitle
    get() = titles[Random().nextInt(titles.size)]
private val randomDrill
    get() = drills[Random().nextInt(drills.size)]
private val randomShoots
    get() = shootsCount[Random().nextInt(shootsCount.size)]
private val randomScore
    get() = scores[Random().nextInt(scores.size)]
private val randomFiretype
    get() = fireTypes[Random().nextInt(fireTypes.size)]
private val randomHand
    get() = hands[Random().nextInt(hands.size)]




val itemImageDiary get() = ItemDiaryImage(randomTitle, dates.format(formatter), notes,randomImage)
val itemNoteDiary get() = ItemDiaryNote(randomTitle,dates.format(formatter),notes)
val itemMantisXDiary get() = ItemDiaryMantisX(randomDrill,dates.format(formatter),randomShoots,randomScore,randomFiretype,randomHand,firearms, notes)