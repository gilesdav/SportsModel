package com.dgiles.sportstest

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    companion object {
        private const val TAG = "MainActivity"
    }
    //  ArrayList<SportModel> sportModels = new ArrayList<>();
    var sportModels: ArrayList<SportsModel> = ArrayList<SportsModel>()
    //    val sportImages: Array<Int> = {R.drawable.ic_drinking, R.draw}
    val sportImages = arrayOf(R.drawable.ic_drinking, R.drawable.ic_football,
        R.drawable.ic_golf, R.drawable.ic_hiking,
        R.drawable.ic_hockey, R.drawable.ic_kayaking,
        R.drawable.ic_kitesurfing, R.drawable.ic_roller_skating,
        R.drawable.ic_rowing, R.drawable.ic_sailing,
        R.drawable.ic_scuba_diving, R.drawable.ic_skating,
        R.drawable.ic_snowboarding, R.drawable.ic_swimming,
        R.drawable.ic_volleyball)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        Log.d(TAG, "onCreate: Started.")
        //   var recyclerView = RecyclerView(findViewById(R.id.mRecyclerView))


        Log.d(TAG, "onCreate: Setup call.")
        setUpSportModels()

        val recyclerView: RecyclerView  = findViewById (R.id.mRecyclerView)
        Log.d(TAG, "onCreate: recyclerView." + recyclerView)

        // Setup recyclerview
        Log.d(TAG, "onCreate: After Setup.")


        val adapter: SP_RecyclerViewAdapter  = SP_RecyclerViewAdapter(this, sportModels)
        Log.d(TAG, "onCreate: adapter." + adapter)

        recyclerView.layoutManager = LinearLayoutManager(this)

        recyclerView.setAdapter(adapter)
        Log.d(TAG, "onCreate: Setadapter.")

     //   recyclerView.setLayoutManager(RecyclerView.LayoutManager())

    }
    private fun setUpSportModels() {
        Log.d(TAG, "setUpSportsModel: started." + sportModels)
        val sportNames:  Array<String> = resources.getStringArray(R.array.sports_full_txt)
        Log.d(TAG, "setUpSportsModel: Names:" + sportNames[1])
        Log.d(TAG, "setUpSportsModel: Count:" + sportNames.size)

        val sportAbbreviation:  Array<String> = resources.getStringArray(R.array.sports_one_letter_txt)
        val sportSeason:  Array<String> = resources.getStringArray(R.array.sports_season_txt)
        Log.d(TAG, "setUpSportsModel: Seasons:" + sportSeason[1])

        for ( i in sportNames.indices) {
            Log.d(TAG, "setUpSportsModel: For Loop Name:" + sportNames[i])
            sportModels.add(SportsModel(sportNames[i], sportAbbreviation[i], sportSeason[i], sportImages[i]  ))
            Log.d(TAG, "setUpSportsModel: For Loop Season:" + sportSeason[i])
        }

        Log.d(TAG, "setUpSportsModel: called." + sportModels)
    }
}