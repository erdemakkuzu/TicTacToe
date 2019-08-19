package com.example.erdemakkuzu.tictactoe

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonArraylist.add(button1)
        buttonArraylist.add(button2)
        buttonArraylist.add(button3)
        buttonArraylist.add(button4)
        buttonArraylist.add(button5)
        buttonArraylist.add(button6)
        buttonArraylist.add(button7)
        buttonArraylist.add(button8)
        buttonArraylist.add(button9)

        tvP1Score.text="P1 Score $player1Score"
        tvP2Score.text="P2 Score: $player2Score"

    }

    fun updateScore(){

        tvP1Score.text="P1 Score $player1Score"
        tvP2Score.text="P2 Score: $player2Score"

    }

    var player1Score = 0
    var player2Score =0
    var winner:Int = -1
    var buttonArraylist = ArrayList<Button>()



    fun clearButons(btnArray:ArrayList<Button>){

        for(btn in btnArray){

            btn.text="Button"
            btn.setBackgroundColor(Color.WHITE)
            btn.isEnabled=true


        }



    }



    protected fun buClick(view:View){

        val buSelected = view as Button
        var cellID =0

        when(buSelected.id){

            R.id.button1-> cellID=1
            R.id.button2-> cellID=2
            R.id.button3-> cellID=3
            R.id.button4-> cellID=4
            R.id.button5-> cellID=5
            R.id.button6-> cellID=6
            R.id.button7-> cellID=7
            R.id.button8-> cellID=8
            R.id.button9-> cellID=9


        }

        //Toast.makeText(this,"Id:$cellID",Toast.LENGTH_LONG).show()

        PlayGame(cellID,buSelected)





    }

    var player1 =ArrayList<Int>()
    var player2 =ArrayList<Int>()
    var ActivePlayer =1



    fun PlayGame(cellId:Int,buSelected:Button){

        if(ActivePlayer==1){
            buSelected.text="X"
            buSelected.setBackgroundColor(Color.GREEN)
            player1.add(cellId)

            buSelected.isEnabled=false
            winner=checkWinner()


            if(winner==-1){
                ActivePlayer=2
                autoPlay()


            }

            else{

                clearButons(buttonArraylist)
               player1.clear()
                player2.clear()
                player1Score++
                ActivePlayer=1
                updateScore()

            }

        }

        else{
            buSelected.text="O"
            buSelected.setBackgroundColor(Color.BLUE)
            player2.add(cellId)

            buSelected.isEnabled=false
            winner=checkWinner()


            if(winner==-1){
                ActivePlayer=1

            }
            else{

                clearButons(buttonArraylist)
                player1.clear()
                player2.clear()
                player2Score++
                ActivePlayer=1
                updateScore()
            }


        }







    }


    fun checkWinner():Int{
        var winner=-1


        //FOR ROWS
        if(player1.contains(1)&& player1.contains(2) && player1.contains(3)){

                winner=1
        }

        if(player2.contains(1)&& player2.contains(2) && player2.contains(3)){

            winner=2
        }



        if(player1.contains(4)&& player1.contains(5) && player1.contains(6)){

            winner=1
        }

        if(player2.contains(4)&& player2.contains(5) && player2.contains(6)){

            winner=2
        }





        if(player1.contains(7)&& player1.contains(8) && player1.contains(9)){

            winner=1
        }

        if(player2.contains(7)&& player2.contains(8) && player2.contains(9)){

            winner=2
        }



                        //FOR COLUMNS


        if(player1.contains(1)&& player1.contains(4) && player1.contains(7)){

            winner=1
        }

        if(player2.contains(1)&& player2.contains(4) && player2.contains(7)){

            winner=2
        }


        if(player1.contains(2)&& player1.contains(5) && player1.contains(8)){

            winner=1
        }

        if(player2.contains(2)&& player2.contains(5) && player2.contains(8)){

            winner=2
        }



        if(player1.contains(3)&& player1.contains(6) && player1.contains(9)){

            winner=1
        }

        if(player2.contains(3)&& player2.contains(6) && player2.contains(9)){

            winner=2
        }


        if(winner!=-1){

            Toast.makeText(this,"Winner is Player$winner",Toast.LENGTH_LONG).show()
        }


        return winner



    }

    fun autoPlay(){



        var emptyCells= ArrayList<Int>()
            for(cellId in 1..9){
                if((!player1.contains(cellId))|| (!player2.contains(cellId))){
                    emptyCells.add(cellId)
                }}

                val r= Random()
                val randIndex = r.nextInt(emptyCells.size-0)+0

                val cellId = emptyCells.get(randIndex)

                var buSelect:Button?

                when(cellId){

                    1->buSelect=button1
                    2->buSelect=button2
                    3->buSelect=button3
                    4->buSelect=button4
                    5->buSelect=button5
                    6->buSelect=button6
                    7->buSelect=button7
                    8->buSelect=button8
                    9->buSelect=button9

                    else->{

                        buSelect=button1
                    }


                }

                PlayGame(cellId,buSelect)



            }




    }


