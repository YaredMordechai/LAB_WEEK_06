package com.example.lab_week_06

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
) : RecyclerView.ViewHolder(containerView) {

    private val catPhotoView: ImageView by lazy { containerView.findViewById<ImageView>(R.id.cat_photo) }
    private val catNameView: TextView by lazy { containerView.findViewById<TextView>(R.id.cat_name) }
    private val catBreedView: TextView by lazy { containerView.findViewById<TextView>(R.id.cat_breed) }
    private val catBiographyView: TextView by lazy { containerView.findViewById<TextView>(R.id.cat_biography) }
    private val catGenderView: TextView by lazy { containerView.findViewById<TextView>(R.id.cat_gender) }

    fun bindData(cat: CatModel) {
        containerView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }

        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
        }
        catBiographyView.text = cat.biography
        catGenderView.text = when (cat.gender) {
            Gender.Female -> "♀"
            Gender.Male -> "♂"
            else -> "?"
        }
    }
}
