package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    // adapter untuk RecyclerView
    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this)) { cat ->
            showSelectionDialog(cat)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // set RecyclerView
        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        // isi data dummy kucing
        val cats = listOf(
            CatModel(Gender.Male, CatBreed.BalineseJavanese,"Fred","Silent and deadly","https://cdn2.thecatapi.com/images/7dj.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair,"Wilma","Cuddly assassin","https://cdn2.thecatapi.com/images/egv.jpg"),
            CatModel(Gender.Unknown, CatBreed.AmericanCurl,"Curious George","Award winning investigator","https://cdn2.thecatapi.com/images/bar.jpg"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese,"Luna","Playful and shy","https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair,"Milo","Loves naps","https://cdn2.thecatapi.com/images/5j2.jpg"),
            CatModel(Gender.Female, CatBreed.AmericanCurl,"Bella","Kneads on blankets","https://cdn2.thecatapi.com/images/abc.jpg"),
            CatModel(Gender.Male, CatBreed.BalineseJavanese,"Oscar","Window watcher","https://cdn2.thecatapi.com/images/xyz.jpg"),
            CatModel(Gender.Unknown, CatBreed.ExoticShorthair,"Shadow","Stealth master","https://cdn2.thecatapi.com/images/def.jpg"),
            CatModel(Gender.Female, CatBreed.AmericanCurl,"Nala","Curious about everything","https://cdn2.thecatapi.com/images/ghi.jpg"),
            CatModel(Gender.Male, CatBreed.BalineseJavanese,"Simba","Brave little cat","https://cdn2.thecatapi.com/images/jkl.jpg")
        )

        // kirim data ke adapter
        catAdapter.setData(cats)
    }

    // dialog saat item diklik
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
