package dev.agustacandi.learn.storystory

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import dev.agustacandi.learn.storystory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var activityMain: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMain = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMain.root)
    }
}