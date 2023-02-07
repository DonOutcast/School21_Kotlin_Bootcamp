package com.example.exercise1.model

import android.content.Context
import android.media.MediaPlayer
import android.os.SystemClock
import android.widget.TextView
import com.example.exercise1.R

class Game(context: Context) {
    var level: Int = 0
    public var song: ArrayList<Int> = ArrayList()
    var songFile = listOf(R.raw.song1,R.raw.song2,R.raw.song3,R.raw.song4)
    var context = context
    var currentSong: Int = 0


    fun playSong(i: Int) {
        MediaPlayer.create(context,songFile[i]).start()
    }

    fun playComposition() {
        for (sound in Game.song) {
            var mediaPlayer = MediaPlayer.create(context, sound)
            SystemClock.sleep(500)
            mediaPlayer.start()
        }
        System.out.println("%%%% "+ Game.song.size)
    }

    fun checkButton(i: Int): Boolean{
        if (Game.noCheck) {
            return true
        }
        var check: Boolean = true
        if (currentSong < song.size) {
            if (song[currentSong] == songFile[i]) {
                check = true
                currentSong++;
            } else {
                check = false
                Game.level = level
                Game.currentSong = currentSong
                Game.song = song
            }
        }
        if (currentSong == song.size) {
            setNextLevel()
        }
        if (level < 3) {
            Game.info = "Level: ${level}    угадано ${currentSong - 1} звуков"
        } else {
            Game.info = "You WIN"
        }

        return check
    }

    fun setNextLevel(){
        if (level > 3) {
            Game.info = "You WIN"
        } else {
            level++
            startLevel(level)
        }
    }

    fun startLevel(level: Int) {
        SystemClock.sleep(2000)
        currentSong == 0
        this.level = level
        song.clear()
        Game.song.clear()
        for (j in 1..level) {
            val i = (Math.random() * (songFile.size - 1)).toInt()
            val s = songFile[i]
            song.add(s)
            Game.song.add(s)
        }
        if (song.size-1 == level){
            var i = "asd"
        }
        var i = "asd"
        Game.info = "Уровень: ${level}"
        playComposition()
    }

    fun startGame(){
        level = 0
        song.clear()
        Game.song.clear()
        Game.info = "Начинаем игру"
    }

    companion object{
        var level: Int = 0
        var currentSong: Int = 0
        var song: ArrayList<Int> = ArrayList()
        var info: String = ""
        var noCheck: Boolean = false
    }

}