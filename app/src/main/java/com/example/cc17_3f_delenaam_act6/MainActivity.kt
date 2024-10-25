package com.example.cc17_3f_delenaam_act6

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: TipAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val tips = generateTips()
        adapter = TipAdapter(tips)
        recyclerView.adapter = adapter
    }

    private fun generateTips(): List<Tip> {
        val titles = resources.getStringArray(R.array.tip_titles)
        val descriptions = resources.getStringArray(R.array.tip_descriptions)
        val imageNames = resources.getStringArray(R.array.tip_images)

        val tips = mutableListOf<Tip>()

        for (i in titles.indices) {
            val imageResId = resources.getIdentifier(imageNames[i], "drawable", packageName)
            tips.add(Tip(
                day = i + 1,
                title = titles[i],
                description = descriptions[i],
                imageResId = imageResId
            ))
        }

        return tips
    }
}