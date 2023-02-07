package com.example.exercise1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.exercise1.model.Game

class MainActivity : AppCompatActivity(), OnClickListener {

    lateinit var button1: Button
    lateinit var button2: Button
    lateinit var button3: Button
    lateinit var button4: Button
    lateinit var repeatBtn: Button
    lateinit var headText: TextView
    lateinit var game: Game

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)
        button4 = findViewById(R.id.button4)
        repeatBtn = findViewById(R.id.repeatBtn)
        headText = findViewById(R.id.headText)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)
        repeatBtn.setOnClickListener(this)

        button1.setText("ОПА")
        button2.setText("УХУУ")
        button3.setText("ЧПОК")
        button4.setText("АЙФОН")


        game = Game(this)
        game.startGame()

        game.startLevel(1)
        headText.setText(Game.info)
    }

    override fun onClick(v: View?) {
        headText.setText(Game.info)
        when (v?.id) {
            R.id.button1 -> {
                game.playSong(0)
                if (!game.checkButton(0)) {
                    openResultActivity()
                }
                headText.setText(Game.info)
            }
            R.id.button2 -> {
                game.playSong(1)
                if (!game.checkButton(1)) {
                    openResultActivity()
                }
                headText.setText(Game.info)
            }
            R.id.button3 -> {
                game.playSong(2)
                if (!game.checkButton(2)) {
                    openResultActivity()
                }
                headText.setText(Game.info)
            }
            R.id.button4 -> {
                game.playSong(3)
                if (!game.checkButton(3)) {
                    openResultActivity()
                }
                headText.setText(Game.info)
            }
            R.id.repeatBtn -> {
                game.playComposition()
                headText.setText(Game.info)
            }
        }
    }

    private fun openResultActivity(){
        if (Game.level > 0) {
            val intent = Intent(this,ResultActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(0,1,0,"New Game")
        menu?.add(0,2,0,"Free Game")
        menu?.add(0,3,0,"About")

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            1 -> {
                Toast.makeText(this,"New Game Selected",Toast.LENGTH_SHORT).show()
                finish();
                startActivity(getIntent());
            }
            2 -> {
                Toast.makeText(this, "Free Game Selected", Toast.LENGTH_SHORT).show()
                Game.noCheck = true
            }
            3 -> Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}