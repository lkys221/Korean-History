package org.androidtown.myapplication;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    TextView question, choice1, choice2, choice3, choice4, choice5;
    ImageView imageView;


    String[] questionArr = {"1.교사의 질문에대한 답변으로 가장 적절한 것은?", "2. (가), (나) 나라에 대한 설명으로 옳은 것은?"};
    String[][] choiceArr = {{"농경과 목축을 시작하여 식량을 생산하였습니다.", "가락바퀴를 이용하여 실을 뽑기 시작하였습니다.", "쟁기, 쇠스랑 등의 철제 농기구를 사용하였습니다.", "거푸집을 이용하여 비파형 동검을 제작하였습니다.", "정착 생활을 하게 되면서 움집이 처음 만들어졌습니다."},
            {"(가) -남녀가 몸에문신을 새기는 풍습이 있었다.", "(가) -절이 많이생산되어 낙랑괴- 왜에 수출하였다.", "(나) -신성 지역인소도가 존재하였다.", "(나) -읍락 간의 경계를 중시하는 책화가 있었다.", "(가), (나) -물건을 훔친 자는 12배로 배상하게 하였다."}};

    int[] imageArr = {R.drawable.go_39_01, R.drawable.go_39_02};
    int[] answerArr = {4, 3};

    int index = 0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        question = (TextView) findViewById(R.id.question);
        imageView = (ImageView) findViewById(R.id.image);
        choice1 = (TextView) findViewById(R.id.choice1);
        choice2 = (TextView) findViewById(R.id.choice2);
        choice3 = (TextView) findViewById(R.id.choice3);
        choice4 = (TextView) findViewById(R.id.choice4);
        choice5 = (TextView) findViewById(R.id.choice5);

        question.setText(questionArr[0]);

        Drawable d = getResources().getDrawable(imageArr[0]);
        imageView.setImageDrawable(d);

        choice1.setText(choiceArr[0][0]);
        choice2.setText(choiceArr[0][1]);
        choice3.setText(choiceArr[0][2]);
        choice4.setText(choiceArr[0][3]);
        choice5.setText(choiceArr[0][4]);

    }

    public void onNextBtnClicked(View v){
        index++;

        question.setText(questionArr[index]);

        Drawable d = getResources().getDrawable(imageArr[index]);
        imageView.setImageDrawable(d);

        choice1.setText(choiceArr[index][0]);
        choice2.setText(choiceArr[index][1]);
        choice3.setText(choiceArr[index][2]);
        choice4.setText(choiceArr[index][3]);
        choice5.setText(choiceArr[index][4]);
    }







}
