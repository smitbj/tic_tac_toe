package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    // 0-x,1-0
    boolean gameactive = true;
    int activePlayer = 0;
    int[] gameState={2,2,2,2,2,2,2,2,2};
    //state 0-x,1-o,2-blank
    //winning position
    int[][] winPosition = {{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    public void playertap(View view){
        ImageView img = (ImageView)view;
        int tappedImage = Integer.parseInt(img.getTag().toString());
        if(!gameactive){
            gameReset(view);
        }
        if(gameState[tappedImage]==2){
            gameState[tappedImage] = activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.x);
                activePlayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("o-Turn");


            }else{
                img.setImageResource(R.drawable.o);
                activePlayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("x-Turn");

            }
            img.animate().translationYBy(1000f).setDuration(300);
        }
        for (int[] winPosition:winPosition){
            if(gameState[winPosition[0]]== gameState[winPosition[1]] && gameState[winPosition[1]]==gameState[winPosition[2]]&&
            gameState[winPosition[0]]!=2){
                String winnerstr;
                gameactive = false;
                if(gameState[winPosition[0]]==0){
                    winnerstr = "x is winner";
                }
                else{
                    winnerstr = "o is winner";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerstr);

            }
        }


    }
    public void gameReset(View view){
         gameactive = true;
         activePlayer = 0;
        gameState= new int[]{2, 2, 2, 2, 2, 2, 2, 2, 2};


        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("x's turn - tap to play");


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

}