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
import java.util.Random;

public class Main8Activity extends AppCompatActivity implements View.OnClickListener {

    CountDownTimer timer, ai1_timer, ai2_timer, ai3_timer;
    long seconds = 90000;
    long ai1, ai2, ai3;
    static TextView tv, round1, round2, round3, round4, country1, country2, country3;
    TextView player_name;
    ImageView flag1, flag2, flag3;
    ImageView player_icon;
    static ImageButton[] ibList1 = new ImageButton[8];
    int[] ibId = {R.id.ib, R.id.ib2, R.id.ib3, R.id.ib4, R.id.ib5, R.id.ib6, R.id.ib7, R.id.ib8};
    ImageButton exit;
    String[] imgName = new String[8];
    int flipNum = 0;
    int ibOne;
    int ibTwo;
    String imgOne;
    String imgTwo;
    int frontOne, frontTwo;
    int step;
    int match;
    static int bonus_value;
    int i;
    static int player_round;
    static int ai1_round, ai2_round, ai3_round;
    int card_option = 1;
    public static int ai_seconds[] = {16550, 16600, 16750, 16850, 16900, 17000, 17650, 18750, 19000, 20000, 21000, 22000, 23000, 23500, 24500, 25000, 25500, 26000, 26500, 26550};
    public static String country[] = {"France", "Germany", "Hong Kong", "Russia", "United Kingdom", "United States"};
    static boolean exitOrNot = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        tv = findViewById(R.id.tv1);
        round1 = findViewById(R.id.round1);
        round2 = findViewById(R.id.round2);
        round3 = findViewById(R.id.round3);
        round4 = findViewById(R.id.round4);
        country1 = findViewById(R.id.country1);
        country2 = findViewById(R.id.country2);
        country3 = findViewById(R.id.country3);
        player_name = findViewById(R.id.player_name);
        flag1 = findViewById(R.id.flag1);
        flag2 = findViewById(R.id.flag2);
        flag3 = findViewById(R.id.flag3);
        exit = findViewById(R.id.exit);
        exit.setOnClickListener(this);
        player_icon = findViewById(R.id.player_icon);

        flipNum = 0;
        step = 0;
        match = 0;
        bonus_value = 0;
        player_round = 0;
        ai1_round = 0;
        ai2_round = 0;
        ai3_round = 0;

        Collections.shuffle(Arrays.asList(country));
        country1.setText("" + country[0]);
        country2.setText("" + country[1]);
        country3.setText("" + country[2]);

        if(country[0] == "France"){
            flag1.setImageResource(R.drawable.flag_france);
        }else if(country[0] == "Germany"){
            flag1.setImageResource(R.drawable.flag_germany);
        }else if(country[0] == "Hong Kong"){
            flag1.setImageResource(R.drawable.flag_hk);
        }else if(country[0] == "Russia"){
            flag1.setImageResource(R.drawable.flag_russia);
        }else if(country[0] == "United Kingdom"){
            flag1.setImageResource(R.drawable.flag_uk);
        }else if(country[0] == "United States"){
            flag1.setImageResource(R.drawable.flag_us);
        }
        if(country[1] == "France"){
            flag2.setImageResource(R.drawable.flag_france);
        }else if(country[1] == "Germany"){
            flag2.setImageResource(R.drawable.flag_germany);
        }else if(country[1] == "Hong Kong"){
            flag2.setImageResource(R.drawable.flag_hk);
        }else if(country[1] == "Russia"){
            flag2.setImageResource(R.drawable.flag_russia);
        }else if(country[1] == "United Kingdom"){
            flag2.setImageResource(R.drawable.flag_uk);
        }else if(country[1] == "United States"){
            flag2.setImageResource(R.drawable.flag_us);
        }
        if(country[2] == "France"){
            flag3.setImageResource(R.drawable.flag_france);
        }else if(country[2] == "Germany"){
            flag3.setImageResource(R.drawable.flag_germany);
        }else if(country[2] == "Hong Kong"){
            flag3.setImageResource(R.drawable.flag_hk);
        }else if(country[2] == "Russia"){
            flag3.setImageResource(R.drawable.flag_russia);
        }else if(country[2] == "United Kingdom"){
            flag3.setImageResource(R.drawable.flag_uk);
        }else if(country[2] == "United States"){
            flag3.setImageResource(R.drawable.flag_us);
        }

        if(MainActivity.player_icon_id == 1){
            player_icon.setImageResource(R.drawable.player_icon01);
        } else if(MainActivity.player_icon_id == 2){
            player_icon.setImageResource(R.drawable.player_icon02);
        } else if(MainActivity.player_icon_id == 3){
            player_icon.setImageResource(R.drawable.player_icon03);
        }

        player_name.setText("" + MainActivity.player_name.getText());

        ibList1[0] = findViewById(R.id.ib);/*randList.get(*/
        ibList1[1] = findViewById(R.id.ib2);
        ibList1[2] = findViewById(R.id.ib3);
        ibList1[3] = findViewById(R.id.ib4);
        ibList1[4] = findViewById(R.id.ib5);
        ibList1[5] = findViewById(R.id.ib6);
        ibList1[6] = findViewById(R.id.ib7);
        ibList1[7] = findViewById(R.id.ib8);
        card_option = new Random().nextInt(3) + 1;
        if(card_option == 1){
            imgName[0] = "card_animal_cat";
            imgName[1] = "card_animal_cat";
            imgName[2] = "card_animal_chicken";
            imgName[3] = "card_animal_chicken";
            imgName[4] = "card_animal_cow";
            imgName[5] = "card_animal_cow";
            imgName[6] = "card_animal_dog";
            imgName[7] = "card_animal_dog";
        }else if(card_option == 2){
            imgName[0] = "card_fruit_apple";
            imgName[1] = "card_fruit_apple";
            imgName[2] = "card_fruit_banana";
            imgName[3] = "card_fruit_banana";
            imgName[4] = "card_fruit_blackcurrant";
            imgName[5] = "card_fruit_blackcurrant";
            imgName[6] = "card_fruit_blueberry";
            imgName[7] = "card_fruit_blueberry";
        }else if(card_option == 3){
            imgName[0] = "card_character_1";
            imgName[1] = "card_character_1";
            imgName[2] = "card_character_2";
            imgName[3] = "card_character_2";
            imgName[4] = "card_character_3";
            imgName[5] = "card_character_3";
            imgName[6] = "card_character_4";
            imgName[7] = "card_character_4";
        }

        Collections.shuffle(Arrays.asList(imgName));

        for (int i = 0; i < 8; i++) {
            ibList1[i].setOnClickListener(this);
            //List<ImageButton> randList = Arrays.asList(ibList1);
            //ibList1 = randList.toArray(new ImageButton[randList.size()]);
        }

        timer = new CountDownTimer(seconds, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tv.setText(" " + millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                tv.setText(" " + 0);
                /*int temp;
                String country_temp;
                if(ai1_round < ai2_round) {
                    temp = ai1_round;
                    country_temp = country1.getText().toString();
                    ai1_round = ai2_round;
                    country1.setText("" + country2.getText().toString());
                    ai2_round = temp;
                    country2.setText("" + country_temp);
                }
                if(ai2_round < ai3_round) {
                    temp = ai2_round;
                    country_temp = country2.getText().toString();
                    ai2_round = ai3_round;
                    country2.setText("" + country3.getText().toString());
                    ai3_round = temp;
                    country3.setText("" + country_temp);
                }*/
                if(exitOrNot == false){
                    Intent intent = new Intent(Main8Activity.this, Main9Activity.class);
                    startActivity(intent);
                }
                MainActivity.btn4.setClickable(true);
                overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
                finish();
            }
        };

        int ai1_rand = new Random().nextInt(16);
        ai1_timer = new CountDownTimer(ai_seconds[ai1_rand], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                ai1_round += 1;
                round1.setText("" + ai1_round);
                int ai1_rand = new Random().nextInt(20);
                ai1_timer.start();
            }
        };
        int ai2_rand = new Random().nextInt(20);
        ai2_timer = new CountDownTimer(ai_seconds[ai2_rand], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                ai2_round += 1;
                round2.setText("" + ai2_round);
                int ai2_rand = new Random().nextInt(20);
                ai2_timer.start();
            }
        };
        int ai3_rand = new Random().nextInt(20);
        ai3_timer = new CountDownTimer(ai_seconds[ai3_rand], 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                ai3_round += 1;
                round3.setText("" + ai3_round);
                int ai3_rand = new Random().nextInt(16);
                ai3_timer.start();
            }
        };
        timer.start();
        ai1_timer.start();
        ai2_timer.start();
        ai3_timer.start();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() != R.id.exit) {
            for (i = 0; i < 20; i++) {
                if (v.getId() == ibId[i]) {
                    break;
                }
            }
            if (flipNum < 2) {
                flipNum += 1;
                int card_front = v.getContext().getResources().getIdentifier(imgName[i], "drawable",
                        v.getContext().getPackageName());
                int card_back = v.getContext().getResources().getIdentifier(
                        "card_back1_org", "drawable",
                        v.getContext().getPackageName());
                AnimateFlipCard(0, ibList1[i], 500, card_front, card_back);
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
                                if (match == 4) {
                                    player_round += 1;
                                    round4.setText("" + player_round);
                                    card_option = new Random().nextInt(3) + 1;
                                    if (card_option == 1) {
                                        imgName[0] = "card_animal_cat";
                                        imgName[1] = "card_animal_cat";
                                        imgName[2] = "card_animal_chicken";
                                        imgName[3] = "card_animal_chicken";
                                        imgName[4] = "card_animal_cow";
                                        imgName[5] = "card_animal_cow";
                                        imgName[6] = "card_animal_dog";
                                        imgName[7] = "card_animal_dog";
                                    } else if (card_option == 2) {
                                        imgName[0] = "card_fruit_apple";
                                        imgName[1] = "card_fruit_apple";
                                        imgName[2] = "card_fruit_banana";
                                        imgName[3] = "card_fruit_banana";
                                        imgName[4] = "card_fruit_blackcurrant";
                                        imgName[5] = "card_fruit_blackcurrant";
                                        imgName[6] = "card_fruit_blueberry";
                                        imgName[7] = "card_fruit_blueberry";
                                    } else if (card_option == 3) {
                                        imgName[0] = "card_character_1";
                                        imgName[1] = "card_character_1";
                                        imgName[2] = "card_character_2";
                                        imgName[3] = "card_character_2";
                                        imgName[4] = "card_character_3";
                                        imgName[5] = "card_character_3";
                                        imgName[6] = "card_character_4";
                                        imgName[7] = "card_character_4";
                                    }
                                    Collections.shuffle(Arrays.asList(imgName));
                                    for (i = 0; i < 8; i++) {
                                        ibList1[i].setImageResource(R.drawable.card_back1_org);
                                        ibList1[i].setVisibility(View.VISIBLE);
                                        ibList1[i].setClickable(true);
                                    }
                                    bonus_value += 200;
                                    match = 0;
                                    //MainActivity.moneyText.setText(""+MainActivity.money);
                                    //Intent intent = new Intent(Main8Activity.this, Main7Activity.class);
                                    //startActivity(intent);
                                    //overridePendingTransition(R.anim.pop_enter, R.anim.pop_exit);
                                    //finish();
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
            exitOrNot = true;
            timer.onFinish();
            MainActivity.btn4.setClickable(true);
            finish();
        }
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
                for (int i = 0; i < 8; i++) {
                    ibList1[i].setClickable(false);
                }
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                for (int i = 0; i < 8; i++) {
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
