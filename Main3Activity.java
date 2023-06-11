package com.weebly.noctiseastern.androidstudioproject7;

import android.content.Intent;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;
import java.util.Collections;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
    TextView step_Text;
    TextView match_Text;
    static ImageButton[] ibList1 = new ImageButton[20];
    int[] ibId = {R.id.ib, R.id.ib2, R.id.ib3, R.id.ib4, R.id.ib5, R.id.ib6, R.id.ib7, R.id.ib8, R.id.ib9, R.id.ib10, R.id.ib11, R.id.ib12,
        R.id.ib13, R.id.ib14, R.id.ib15, R.id.ib16, R.id.ib17, R.id.ib18, R.id.ib19, R.id.ib20};
    //Integer[] randArray = {0,1,2,3,4,5,6,7,8,9,10,11};
    //ArrayList <Integer> randList = Arrays.asList(randArray);
    //ibList1 = randList.toArray(new ImageButton[randList.size()]);
    //randList.add();
    String[] imgName = new String[20];
    int flipNum = 0;
    int step;
    int match;
    int ibOne;
    int ibTwo;
    String imgOne;
    String imgTwo;
    int frontOne, frontTwo;

    CountDownTimer timer;
    long seconds = 1000;
    ImageView book;

    public static ImageView player_icon;
    ImageButton ib_you_win;
    ImageButton exit;

    static int star_num;
    static int bonus_value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        player_icon = findViewById(R.id.player_icon);
        step_Text = findViewById(R.id.step_Text);
        match_Text = findViewById(R.id.match_Text);
        flipNum = 0;
        step = 0;
        match = 0;
        ib_you_win = findViewById(R.id.ib_you_win);
        ib_you_win.setOnClickListener(this);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(this);
        ib_you_win.setVisibility(View.INVISIBLE);
        ib_you_win.setClickable(false);
        book = findViewById(R.id.book);

        ibList1[0] = findViewById(R.id.ib);/*randList.get(*/
        ibList1[1] = findViewById(R.id.ib2);
        ibList1[2] = findViewById(R.id.ib3);
        ibList1[3] = findViewById(R.id.ib4);
        ibList1[4] = findViewById(R.id.ib5);
        ibList1[5] = findViewById(R.id.ib6);
        ibList1[6] = findViewById(R.id.ib7);
        ibList1[7] = findViewById(R.id.ib8);
        ibList1[8] = findViewById(R.id.ib9);
        ibList1[9] = findViewById(R.id.ib10);
        ibList1[10] = findViewById(R.id.ib11);
        ibList1[11] = findViewById(R.id.ib12);
        ibList1[12] = findViewById(R.id.ib13);
        ibList1[13] = findViewById(R.id.ib14);
        ibList1[14] = findViewById(R.id.ib15);
        ibList1[15] = findViewById(R.id.ib16);
        ibList1[16] = findViewById(R.id.ib17);
        ibList1[17] = findViewById(R.id.ib18);
        ibList1[18] = findViewById(R.id.ib19);
        ibList1[19] = findViewById(R.id.ib20);

        if(Main6Activity.card_option == 1){
            imgName[0] = "card_animal_cat";
            imgName[1] = "card_animal_cat";
            imgName[2] = "card_animal_chicken";
            imgName[3] = "card_animal_chicken";
            imgName[4] = "card_animal_cow";
            imgName[5] = "card_animal_cow";
            imgName[6] = "card_animal_dog";
            imgName[7] = "card_animal_dog";
            imgName[8] = "card_animal_elephant";
            imgName[9] = "card_animal_elephant";
            imgName[10] = "card_animal_fox";
            imgName[11] = "card_animal_fox";
            imgName[12] = "card_animal_frog";
            imgName[13] = "card_animal_frog";
            imgName[14] = "card_animal_goldfish";
            imgName[15] = "card_animal_goldfish";
            imgName[16] = "card_animal_hippo";
            imgName[17] = "card_animal_hippo";
            imgName[18] = "card_animal_horse";
            imgName[19] = "card_animal_horse";
        }else if(Main6Activity.card_option == 2){
            imgName[0] = "card_fruit_apple";
            imgName[1] = "card_fruit_apple";
            imgName[2] = "card_fruit_banana";
            imgName[3] = "card_fruit_banana";
            imgName[4] = "card_fruit_blackcurrant";
            imgName[5] = "card_fruit_blackcurrant";
            imgName[6] = "card_fruit_blueberry";
            imgName[7] = "card_fruit_blueberry";
            imgName[8] = "card_fruit_cherry";
            imgName[9] = "card_fruit_cherry";
            imgName[10] = "card_fruit_coconut";
            imgName[11] = "card_fruit_coconut";
            imgName[12] = "card_fruit_kiwis";
            imgName[13] = "card_fruit_kiwis";
            imgName[14] = "card_fruit_lemon";
            imgName[15] = "card_fruit_lemon";
            imgName[16] = "card_fruit_lychee";
            imgName[17] = "card_fruit_lychee";
            imgName[18] = "card_fruit_mango";
            imgName[19] = "card_fruit_mango";
        }else if(Main6Activity.card_option == 3){
            imgName[0] = "card_character_1";
            imgName[1] = "card_character_1";
            imgName[2] = "card_character_2";
            imgName[3] = "card_character_2";
            imgName[4] = "card_character_3";
            imgName[5] = "card_character_3";
            imgName[6] = "card_character_4";
            imgName[7] = "card_character_4";
            imgName[8] = "card_character_5";
            imgName[9] = "card_character_5";
            imgName[10] = "card_character_6";
            imgName[11] = "card_character_6";
            imgName[12] = "card_character_7";
            imgName[13] = "card_character_7";
            imgName[14] = "card_character_8";
            imgName[15] = "card_character_8";
            imgName[16] = "card_character_9";
            imgName[17] = "card_character_9";
            imgName[18] = "card_character_10";
            imgName[19] = "card_character_10";
        }

        Collections.shuffle(Arrays.asList(imgName));


        for (int i = 0; i < 20; i++) {
            ibList1[i].setOnClickListener(this);
            if(Main6Activity.preview_option > 1){
                ibList1[i].setImageResource(getResources().getIdentifier(imgName[i], "drawable", getPackageName()));
                ibList1[i].setClickable(false);
            }
            if(Main6Activity.preview_option == 2){
                book.setVisibility(View.VISIBLE);
            }
            //List<ImageButton> randList = Arrays.asList(ibList1);
            //ibList1 = randList.toArray(new ImageButton[randList.size()]);
        }
        if(Main6Activity.preview_option > 1) {
            timer = new CountDownTimer(seconds, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {

                }

                @Override
                public void onFinish() {
                    for (int i = 0; i < 20; i++) {
                        ibList1[i].setImageResource(getResources().getIdentifier("card_back1_org", "drawable", getPackageName()));
                        ibList1[i].setClickable(true);
                        if(Main6Activity.preview_option == 2){
                            book.setVisibility(View.INVISIBLE);
                        }
                    }
                }
            };
            timer.start();
        }
    }

    public void onClick(View v) {
        if(v.getId() != R.id.exit){
            int i;
            for (i = 0; i < 20; i++) {
                if (v.getId() == ibId[i]) {
                    break;
                }
            }
            if (flipNum < 2) {
                flipNum += 1;
                step += 1;
                int card_front = v.getContext().getResources().getIdentifier(imgName[i], "drawable",
                        v.getContext().getPackageName());
                int card_back = v.getContext().getResources().getIdentifier(
                        "card_back1_org", "drawable",
                        v.getContext().getPackageName());
                AnimateFlipCard(0, ibList1[i], 500, card_front, card_back);
                step_Text.setText("" + step);
                if (flipNum == 1) {
                    ibOne = i;
                    imgOne = imgName[i];
                    frontOne = card_front;
                    ibList1[i].setClickable(false);
                } else if (flipNum == 2) {
                    ibTwo = i;
                    imgTwo = imgName[i];
                    frontTwo = card_front;
                    ibList1[i].setClickable(false);
                    if (ibOne != ibTwo && imgOne == imgTwo) {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                ibList1[ibOne].setVisibility(View.INVISIBLE);
                                ibList1[ibTwo].setVisibility(View.INVISIBLE);
                                match += 1;
                                match_Text.setText(match + "/10");
                                if(match == 10){
                                    if(step <= 30){
                                        MainActivity.money += 600;
                                        star_num = 3;
                                        bonus_value = 600;
                                    }else if (step <= 60){
                                        MainActivity.money += 400;
                                        star_num = 2;
                                        bonus_value = 400;
                                    }else{
                                        MainActivity.money += 200;
                                        star_num = 1;
                                        bonus_value = 200;
                                    }
                                    MainActivity.moneyText.setText(""+MainActivity.money);
                                    Intent intent = new Intent(Main3Activity.this, Main7Activity.class);
                                    startActivity(intent);
                                    MainActivity.btn2.setClickable(false);
                                    overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
                                    MainActivity.mydb.updatePlayer(1, MainActivity.name, MainActivity.player_icon_id, MainActivity.money);
                                    finish();
                                }
                            }
                        }, 500);
                    } else {
                        AnimateFlipCard(230, ibList1[ibOne], 500, card_back, frontOne);
                        AnimateFlipCard(230, ibList1[ibTwo], 500, card_back, frontTwo);
                        ibList1[ibOne].setClickable(true);
                        ibList1[ibTwo].setClickable(true);
                    }
                    flipNum = 0;
                }
            }
        }
        if(v.getId() == R.id.exit){
            finish();
        }

     /*   if (v.getId() == ibId[i]) {
            int card_front = v.getContext().getResources().getIdentifier(
                    "card_animal_cat", "drawable",
                    v.getContext().getPackageName());
            int card_back = v.getContext().getResources().getIdentifier(
                    "card_back1_org", "drawable",
                    v.getContext().getPackageName());
            AnimateFlipCard(0, ibList1[0], 500, card_front, card_back);
        }*/
    }

    public static void AnimateFlipCard(int DELAY, final ImageButton ivDH, final int CardAnimTime, final int ResId, final int card_back) {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // ((BitmapDrawable)ivDH.getDrawable()).getBitmap().recycle();
                ivDH.setImageResource(card_back);
                ivDH.setBackgroundResource(card_back);
                flipAnimation(ivDH, 1f, 0f, CardAnimTime);
            }
        }, DELAY);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //((BitmapDrawable)imageView.getDrawable()).getBitmap().recycle();
                //((BitmapDrawable)ivDH.getDrawable()).getBitmap().recycle();
                ivDH.setImageResource(ResId);
                ivDH.setBackgroundResource(ResId);
                flipAnimation(ivDH, 0f, 1f, CardAnimTime);
            }
        }, DELAY + CardAnimTime / 3);
    }

    public static void flipAnimation(ImageButton ivDH, float x1, float x2, int CardAnimTime) {
        Animation animationSet1 = new ScaleAnimation(
                x1, x2, // Start and end values for the X axis scaling
                1f, 1f, // Start and end values for the Y axis scaling
                Animation.RELATIVE_TO_SELF, .5f, // Pivot point of X scaling
                Animation.RELATIVE_TO_SELF, .5f); // Pivot point of Y scaling
        //animationSet1.setFillAfter(true); // Needed to keep the result of the animation
        animationSet1.setDuration(CardAnimTime / 3);
        animationSet1.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                for (int i = 0; i < 20; i++) {
                    ibList1[i].setClickable(false);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                for (int i = 0; i < 20; i++) {
                    ibList1[i].setClickable(true);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ivDH.startAnimation(animationSet1);
    }
}
