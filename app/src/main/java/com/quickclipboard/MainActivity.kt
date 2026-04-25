
package com.quickclipboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.ads.*
import com.quickclipboard.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var b: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        MobileAds.initialize(this)

        b = ActivityMainBinding.inflate(layoutInflater)
        setContentView(b.root)

        b.btnHistory.setOnClickListener {
            startActivity(Intent(this, ClipboardHistoryActivity::class.java))
        }

        b.btnPrivacy.setOnClickListener {
            startActivity(Intent(this, PrivacyActivity::class.java))
        }

        val adRequest = AdRequest.Builder().build()
        b.adView.loadAd(adRequest)
    }
}
