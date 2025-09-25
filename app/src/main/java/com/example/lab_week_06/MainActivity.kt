package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(layoutInflater, GlideImageLoader(this), object : CatAdapter.OnClickListener {
            override fun onItemClick(cat: CatModel) {
                showSelectionDialog(cat)
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        val cats = listOf(
            CatModel(Gender.Male, CatBreed.BalineseJavanese,"Ucup","Suka ngintip tetangga dari jendela, dikira satpam komplek","https://cdn2.thecatapi.com/images/7dj.jpg"),
            CatModel(Gender.Female, CatBreed.ExoticShorthair,"Mbak Iyah","Kerjanya tidur, bangun cuma kalo dengar suara plastik makanan","https://cdn2.thecatapi.com/images/egv.jpg"),
            CatModel(Gender.Unknown, CatBreed.AmericanCurl,"Bang Kumis","Kepo level dewa, sampai masuk ember cucian tetangga","https://cdn2.thecatapi.com/images/bar.jpg"),
            CatModel(Gender.Female, CatBreed.BalineseJavanese,"Siti","Mainannya cuma karet gelang, padahal beli mainan mahal nggak dipeduliin","https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"),
            CatModel(Gender.Male, CatBreed.ExoticShorthair,"Jono","Hobi tidur di keyboard, bikin skripsi majikan auto berantakan","https://cdn2.thecatapi.com/images/5j2.jpg"),
            CatModel(Gender.Female, CatBreed.AmericanCurl,"Mpok Lela","Gayanya sok luwes loncat-loncat, ujung-ujungnya jatuh juga","https://cdn2.thecatapi.com/images/abc.jpg"),
            CatModel(Gender.Unknown, CatBreed.ExoticShorthair,"Si Item","Muncul tiba-tiba di malam hari, bikin jantung copot","https://cdn2.thecatapi.com/images/def.jpg"),
        )

        catAdapter.setData(cats)
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
