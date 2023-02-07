package com.example.exercise1

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import android.widget.TextView
import com.example.exercise1.model.Game

class ResultActivity : AppCompatActivity() {
    lateinit var resultEdit: TextView
    lateinit var reapetGame: Button
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        reapetGame = findViewById(R.id.repeatGame)
        resultEdit = findViewById(R.id.resultText)
        resultEdit.setText("Вы достигли уровня ${Game.level} \n оставалось ${Game.song.size - Game.currentSong} песен")
        reapetGame.setOnClickListener(){
            openMainActivity()
        }

        mediaPlayer = MediaPlayer.create(this, R.raw.song0)
        SystemClock.sleep(500)
        mediaPlayer.start()
    }

    private fun openMainActivity() {
        mediaPlayer.stop()
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
    }

}