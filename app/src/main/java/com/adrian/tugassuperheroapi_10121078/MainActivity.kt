package com.adrian.tugassuperheroapi_10121078


import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.adrian.tugassuperheroapi_10121078.Api.InstanceRetrofit
import com.adrian.tugassuperheroapi_10121078.Model.Superhero
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var superheroImage: ImageView
    private lateinit var superheroName: TextView
    private lateinit var superheroDetails: TextView
    private lateinit var superheroBiography: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        superheroImage = findViewById(R.id.superheroImage)
        superheroName = findViewById(R.id.superheroName)
        superheroDetails = findViewById(R.id.superheroDetails)
        superheroBiography = findViewById(R.id.superheroBiography)

        fetchSuperheroData()
    }

    private fun fetchSuperheroData() {
        InstanceRetrofit.api.getSuperhero().enqueue(object : Callback<Superhero> {
            override fun onFailure(call: Call<Superhero>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<Superhero>, response: Response<Superhero>) {
                if (response.isSuccessful) {
                    response.body()?.let { superhero ->
                        val imageUrl = superhero.image.url
                        val name = superhero.name
                        val powerstats = superhero.powerstats
                        val intelligence = powerstats.intelligence
                        val strength = powerstats.strength
                        val speed = powerstats.speed
                        val durability = powerstats.durability
                        val power = powerstats.power
                        val combat = powerstats.combat

                        val biography = superhero.biography
                        val aliases = biography.aliases.joinToString(", ")
                        val alignment = biography.alignment
                        val publisher = biography.publisher

                        val appearance = superhero.appearance
                        val gender = appearance.gender
                        val race = appearance.race

                        val work = superhero.work
                        val occupation = work.occupation
                        val base = work.base

                        val biographyDetails = """
                            Gender          : $gender
                            Race              : $race
                            Occupation  : $occupation
                            Base              : $base
                            Alignment     : $alignment
                            Publisher       : $publisher
                        """.trimIndent()

                        val details = """
                            Intelligence: $intelligence
                            Strength    : $strength
                            Speed        : $speed
                            Durability  : $durability
                              Power       : $power
                            Combat      : $combat
                        """.trimIndent()



                        Glide.with(this@MainActivity).load(imageUrl).into(superheroImage)
                        superheroName.text = name
                        superheroBiography.text = biographyDetails
                        superheroDetails.text = details
                    }
                }
            }
        })
    }
}
