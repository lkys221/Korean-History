package org.androidtown.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    TextView question, choice1, choice2, choice3, choice4, choice5;
    ImageView imageView;
    ViewGroup layout_choice1, layout_choice2, layout_choice3, layout_choice4, layout_choice5;
    ScrollView scrollView;

    SharedPreferences pref;
    SharedPreferences.Editor editor;


    String[] questionArr = {"1.교사의 질문에대한 답변으로 가장 적절한 것은?", "2. (가), (나) 나라에 대한 설명으로 옳은 것은?", "3. 다음 법을 시행하였던 나라에 대한 설명으로 옳은 것은?", "4. 밑줄 그은 ‘대책’으로 옳은 것은?", "5.다음 사건이 일어난 이후의 시실로 옳은 것은?", "6.(개, (나) 사이의 시기에 있었던 사실로 옳은 것은? ", "7.다음 자료에 나타난 시기의사실로 옳은 것은?", "8.(가) 왕에 대한 설명으로 옳은 것은?", "9. (가) 국가의 경제 싱황에 대한 설명으로 옳은 것은?",
            "10. (가), (나) 왕이 실시한 정책으로 옳은 것은?", "11. (가) 에 들어갈 문화유산으로 옳은 것은?", "12.(개인물에대한 설명으로 옳은 것은?", "13.다음 상황이 전개된 이후의 사실로 옳은 것은?", "14. 밑줄 그은 ‘정책’으로 옳은 것을 〈보기〉에서 고른 것은?", "15. (개인물에대한 설명으로 옳은 것은?"};

    String[][] choiceArr = {{"농경과 목축을 시작하여 식량을 생산하였습니다.", "가락바퀴를 이용하여 실을 뽑기 시작하였습니다.", "쟁기, 쇠스랑 등의 철제 농기구를 사용하였습니다.", "거푸집을 이용하여 비파형 동검을 제작하였습니다.", "정착 생활을 하게 되면서 움집이 처음 만들어졌습니다."},
            {"(가) -남녀가 몸에문신을 새기는 풍습이 있었다.", "(가) 철이 많이생산되어 낙랑과 왜에 수출하였다.", "(나) -신성 지역인소도가 존재하였다.", "(나) -읍락 간의 경계를 중시하는 책화가 있었다.", "(가), (나) -물건을 훔친 자는 12배로 배상하게 하였다."},
            {"신지,읍차 등의 지배자가 있었다.", "골품제라는 신분 제도를 마련하였다.", "제가 회의에서 국가 중대사를 결정하였다.", "왕 아래상, 대부‘ 장군 등의 관직을 두었다.", "여러 가(加)들이 별도로 사출도를 주관하였다."},
            {"진대법을 실시하여 빈민을 구제하였다.", "상평창을 설치하여 물기를 조절하였다.", "구황촬요를 간행하여 기근에 대비하였다.", "구제도감을 설립하여 백성을 구호하였다.", "혜민국을 마련하여 병자에게 익뇨을 지급하였다."},
            {"고구려가 옥저를 복속시켰다.", "백제가 고구려의 평양성을 공격하였다.", "가야 연맹이 대가야를 중심으로 재편되었다.", "신라 지배자의 칭호가 차치-웅으로 바뀌었다.", "고구려가 대빙-군을 축출하고 영토를 확장하였다."},
            {"무령왕이 22담로에 왕족을 파견히-였다." ,"침류왕이 동진으로부터 불교를 수용하였다.", "의자왕이 신리를 공격하여 대야성을 함락하였다.", "고이왕이 좌평과 관등제의 기본 골격을 마련하였다.", "성왕이고구려를 공격하여한강 유역을 수복하였다."},
            {"복신과 도침 등이주류성에서 군사를 일으켰다.", "묘청 등이중심이 되어 서경 천도를 주장하였다.", "신리-군이 당의 군대에 맞서 매소성에서 승리하였다.", "지방에서 호족들이반독립적인 세력으로 성장하였다.", "요세가 법화 신앙에중점을 둔 백련 결사를 주도하였다."},
            {"화랑도를 국가 조직으로 개편하였다.", "이사부를 보내 우산국을 복속시켰다.", "건원이라는 독자적인 연호를 시용하였다.", "관리에게 관료전을 지급하고 녹읍을 폐지하였다.", "호국의 염원을 담아 황룡사 구층 목탑을 건립하였다."},
            {"울산항이국제 무역헝-으로 번성하였다.", "특산품으로 솔빈부의 말이유명하였다.", "청해진을 설치하여해상 무역을 전개하였다.", "건원중보를 발행하여 화폐 유통을 추진하였다.", "시장을 관리하는 관청인 동시전을 설치하였다."},
            {"(가) -흑창을 설치하여 민생을 안정시켰다.", "(가) -광덕, 준풍 등의 독자적인 연호를 시용하였다.", "(나) - 12목을 설치하고 지방관을 파견하였다." ,"(나) -상수리 제도를 실시하여 지방 세력을통제하였다.", "(가), (나) -현직 관리에게 전지와 시지를 지급하였다."},
            {"go_39_11_01", "go_39_11_02", "go_39_11_03", "go_39_11_04", "go_39_11_05"},
            {"권수정혜결사문을 작성하여 정혜쌍수를 강조하였다.", "해동고승전을 집필하여승려들의 전기를 기록하였다", "보현십원가를 지어 불교 교리를 대중에게 전피-하였다.", "교관겸수를 내세워 이론 연마와 실천을 함께중시하였다.", "삼국유사를 저술하여 불교 중심의 민간 설회를 정리하였다."},
            {"광군을 창설하여외침에대비하였다.", "거란의 침략을 피해 왕이나주로 피난하였다.", "서희가 외교 담판을 벌여강동 6주를 획득하였다.", "만부교 사건이 일어나 거란과의관계가 악화되었다.", "후주와 사신을 교환히·여 대외 관계의 안정을 꾀하였다."},
            {"ㄱ, ㄴ", "ㄱ, ㄷ", "ㄴ, ㄷ", "ㄴ, ㄹ", "ㄷ, ㄹ"},
            {"칭제 건원과 금국 정벌을 주장하였다.", "봉사 10조를 올려 시정 개혁을 제안하였다.", "보현원에서 정변을 일으켜 정권을 장악하였다.", "강화도로 도읍을 옮겨 몽골의 침략에 대비하였다.", "전민변정도감의 판사가 되어 권문세족을 견제하였다."}};

    int[] imageArr = {R.drawable.go_39_01, R.drawable.go_39_02, R.drawable.go_39_03, R.drawable.go_39_04, R.drawable.go_39_05, R.drawable.go_39_06, R.drawable.go_39_07, R.drawable.go_39_08, R.drawable.go_39_09, R.drawable.go_39_10, R.drawable.go_39_11, R.drawable.go_39_12, R.drawable.go_39_13, R.drawable.go_39_14, R.drawable.go_39_15};
    int[] answerArr = {4, 3, 4, 1, 3, 1, 4, 4, 2, 1, 1, 1, 2, 3, 4};

    int index = 0;
    int choice = 0;
    int score = 0;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        pref = getSharedPreferences("Choices", Context.MODE_PRIVATE);
        editor = pref.edit();


        //Bottom Navigation Bar
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_previous:
                        onPreviousBtnClicked();
                        break;
                    case R.id.action_middle:
                        Toast.makeText(QuizActivity.this, "Back to Main Menu", Toast.LENGTH_SHORT).show();
                        finish();
                        break;
                    case R.id.action_next:
                        onNextBtnClicked();
                        break;
                }
                return true;
            }
        });

        scrollView = (ScrollView) findViewById(R.id.scrollView);
        //Initiate the first question
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


        //Choices related
        layout_choice1 = (ViewGroup) findViewById(R.id.layout_choice1);
        layout_choice2 = (ViewGroup) findViewById(R.id.layout_choice2);
        layout_choice3 = (ViewGroup) findViewById(R.id.layout_choice3);
        layout_choice4 = (ViewGroup) findViewById(R.id.layout_choice4);
        layout_choice5 = (ViewGroup) findViewById(R.id.layout_choice5);

        layout_choice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChoice(layout_choice1);
                choice = 1;
            }
        });
        layout_choice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChoice(layout_choice2);
                choice = 2;
            }
        });
        layout_choice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChoice(layout_choice3);
                choice = 3;
            }
        });
        layout_choice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChoice(layout_choice4);
                choice = 4;
            }
        });
        layout_choice5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickChoice(layout_choice5);
                choice = 5;
            }
        });

    }

    public boolean onNextBtnClicked(){
        //save current question's choice
        if(choice != 0)
            saveChoices(index, choice);

        //to next question
        index++;
        choice = 0;

        if(index > questionArr.length - 1){
            checkAnswer();
            Toast.makeText(getApplicationContext(), "Your score is " + score + "/" + questionArr.length, Toast.LENGTH_LONG).show();
            finish();
            return false;
        }
        else {
            //scroll up
            scrollView.fullScroll(ScrollView.FOCUS_UP);
            //next question
            question.setText(questionArr[index]);
            //next image
            Drawable d = getResources().getDrawable(imageArr[index]);
            imageView.setImageDrawable(d);
            //next choices
            setChoicesText(index);

            //marking saved choices
            int finalChoice = loadChoice(index);

            switch (finalChoice){
                case 0: emptyChoices();
                    choice = 0;
                    break;
                case 1: clickChoice(layout_choice1);
                    break;
                case 2: clickChoice(layout_choice2);
                    break;
                case 3: clickChoice(layout_choice3);
                    break;
                case 4: clickChoice(layout_choice4);
                    break;
                case 5: clickChoice(layout_choice5);
                    break;
            }
        }

                return true;
    }


    public boolean onPreviousBtnClicked(){
        //save current question's choice
        if(choice != 0)
            saveChoices(index, choice);

        index--;
        choice = 0;

        if(index < 0){
            Toast.makeText(getApplicationContext(), "This is the first question", Toast.LENGTH_LONG).show();
            index++;
            return false;
        }
        //scroll up
        scrollView.fullScroll(ScrollView.FOCUS_UP);
        //next questions
        question.setText(questionArr[index]);
        //next images
        Drawable d = getResources().getDrawable(imageArr[index]);
        imageView.setImageDrawable(d);
        //next choices
        setChoicesText(index);

        //marking saved choices
        int finalChoice = loadChoice(index);

        switch (finalChoice){
            case 0: emptyChoices();
                break;
            case 1: clickChoice(layout_choice1);
                break;
            case 2: clickChoice(layout_choice2);
                break;
            case 3: clickChoice(layout_choice3);
                break;
            case 4: clickChoice(layout_choice4);
                break;
            case 5: clickChoice(layout_choice5);
                break;
        }

        return true;
    }


    //choices 관련 method
    private boolean setChoicesText(int index) {
        if(choiceArr[index][0].startsWith("go")){

            String imageName = choiceArr[index][0];
            int resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            choice1.setCompoundDrawablesWithIntrinsicBounds(resID, 0, 0, 0);

            imageName = choiceArr[index][1];
            resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            choice2.setCompoundDrawablesWithIntrinsicBounds(resID, 0, 0, 0);

            imageName = choiceArr[index][2];
            resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            choice3.setCompoundDrawablesWithIntrinsicBounds(resID, 0, 0, 0);

            imageName = choiceArr[index][3];
            resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            choice4.setCompoundDrawablesWithIntrinsicBounds(resID, 0, 0, 0);

            imageName = choiceArr[index][4];
            resID = getResources().getIdentifier(imageName, "drawable", getPackageName());
            choice5.setCompoundDrawablesWithIntrinsicBounds(resID, 0, 0, 0);

            return true;
        }
        else {
            clearImageChoices();

            choice1.setText(choiceArr[index][0]);
            choice2.setText(choiceArr[index][1]);
            choice3.setText(choiceArr[index][2]);
            choice4.setText(choiceArr[index][3]);
            choice5.setText(choiceArr[index][4]);

            return false;
        }
    }

    public void clickChoice(ViewGroup v){
            emptyChoices();
            v.setBackgroundResource(R.drawable.layout_clicked);
    }

    public void emptyChoices(){
        layout_choice1.setBackgroundResource(R.drawable.layout_rc);
        layout_choice2.setBackgroundResource(R.drawable.layout_rc);
        layout_choice3.setBackgroundResource(R.drawable.layout_rc);
        layout_choice4.setBackgroundResource(R.drawable.layout_rc);
        layout_choice5.setBackgroundResource(R.drawable.layout_rc);
    }

    private void saveChoices(int index, int choiceNum){
        editor.putInt(""+index, choiceNum);
        editor.commit();
    }

    private int loadChoice(int index){
        int finalChoice = pref.getInt(""+index, 0);
        return finalChoice;
    }

    private void deleteData(){
        editor.clear();
    }

    private void checkAnswer(){
        int userAns;

        for (int i = 0; i < questionArr.length; i++) {
            userAns = loadChoice(i);
            if(userAns == answerArr[i])
                score++;
        }

    }

    private void clearImageChoices(){
        choice1.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        choice2.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        choice3.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        choice4.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
        choice5.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

    }

}
