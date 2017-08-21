package com.example.rohin.tic_tac_toe

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.telephony.CellIdentityCdma
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
//import java.util.ArrayList
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    var numclicks=0



    fun btnclick(view:View) {
        val btnselected = view as Button
        var cellid = 0

        when (btnselected.id) {
            R.id.bt1 -> cellid = 1
            R.id.bt2 -> cellid = 2
            R.id.bt3 -> cellid = 3
            R.id.bt4 -> cellid = 4
            R.id.bt5 -> cellid = 5
            R.id.bt6 -> cellid = 6
            R.id.bt7 -> cellid = 7
            R.id.bt8 -> cellid = 8
            R.id.bt9 -> cellid = 9
        }
        //Toast.makeText(this, "clicked button"+ cellid, Toast.LENGTH_LONG).show()
        numclicks++
        PlayGame(btnselected,cellid)
    }

    var currplayer = 1
    var p1cells= ArrayList<Int>()
    var p2cells= ArrayList<Int>()

    fun PlayGame(btnsel : Button, cellId: Int){
            if (currplayer == 1){
                btnsel.text="X"
                p1cells.add(cellId)
                currplayer = 2
            }
            else{
                btnsel.text = "O"
                p2cells.add(cellId)
                currplayer = 1
            }
            btnsel.isEnabled = false
            CheckWinner()
    }
    fun CheckWinner(){
        var winner=0;
        //rows
        if (p1cells.contains(1) && p1cells.contains(2) && p1cells.contains(3))
            winner = 1
        if (p2cells.contains(1)  && p2cells.contains(2) && p2cells.contains(3))
            winner = 2

        if (p1cells.contains(4) && p1cells.contains(5) && p1cells.contains(6))
            winner = 1
        if (p2cells.contains(4)  && p2cells.contains(5) && p2cells.contains(6))
            winner = 2

        if (p1cells.contains(7)  && p1cells.contains(8) && p1cells.contains(9))
            winner=1
        if (p2cells.contains(7) && p2cells.contains(8) && p2cells.contains(9))
            winner = 2
        //diagonal
        if (p1cells.contains(1)  && p1cells.contains(5) && p1cells.contains(9))
            winner=1
        if (p2cells.contains(1)  && p2cells.contains(5) && p2cells.contains(9))
            winner = 2
        if (p1cells.contains(3)  && p1cells.contains(5) && p1cells.contains(7))
            winner=1
        if (p2cells.contains(3)  && p2cells.contains(5) && p2cells.contains(7))
            winner=2
        //column
        if (p1cells.contains(1)  && p1cells.contains(4) && p1cells.contains(7))
            winner=1
        if (p2cells.contains(1)  && p2cells.contains(4) && p2cells.contains(7))
            winner=2
        if (p1cells.contains(2)  && p1cells.contains(5) && p1cells.contains(8))
            winner=1
        if (p2cells.contains(2)  && p2cells.contains(5) && p2cells.contains(8))
            winner=2
        if (p1cells.contains(3)  && p1cells.contains(6) && p1cells.contains(9))
            winner=1
        if (p2cells.contains(3)  && p2cells.contains(6) && p2cells.contains(9))
            winner=2

        if(winner != 0){
            if (winner == 1){
                Toast.makeText(this,"Player 1 wins", Toast.LENGTH_LONG).show()
                restartGame()
            }
            if (winner == 2){
                Toast.makeText(this,"player 2 wins",Toast.LENGTH_LONG).show()
                restartGame()
            }
        }
        else{
            if (numclicks >= 9){
                Toast.makeText(this,"it's draw!!",Toast.LENGTH_LONG).show()
                restartGame()
            }
        }

    }
    fun  restartGame(){
        bt1.text = ""
        bt1.isEnabled = true
        bt2.text = ""
        bt2.isEnabled = true
        bt3.text = ""
        bt3.isEnabled = true
        bt4.text = ""
        bt4.isEnabled = true
        bt5.text = ""
        bt5.isEnabled = true
        bt6.text = ""
        bt6.isEnabled = true
        bt7.text = ""
        bt7.isEnabled = true
        bt8.text = ""
        bt8.isEnabled = true
        bt9.text = ""
        bt9.isEnabled = true
        p1cells.clear()
        p2cells.clear()
        numclicks=0
        currplayer=1
    }
    fun restartbtn(view: View){
        restartGame()
    }

}

