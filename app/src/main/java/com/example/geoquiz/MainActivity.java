package com.example.geoquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String INDEX_QUESTION ="index" ;
    private Button mButtonFalse,mButtonTrue,mButtonCheckAnswer,mButtonNext;
    private TextView mTextQuestion;

//Создание массива вопросов на основе класса моедли Question.
    private Question [] mQuestionBank=new Question[]{
            new Question(R.string.question_climate_rostov_on_don,false),
            new Question(R.string.question_novoshahtinsk,true),
            new Question(R.string.question_rostov_on_don_population,true),
            new Question(R.string.question_south_mountainous,false),
            new Question(R.string.question_time_zone_rostov_region,false),
            new Question(R.string.question_largest_Rostov_on_don,true),
    };

    private int mCurrentIndex=0;//Наш первый эллемент массива вопросов,который будет использоваться в коде в дальнейшем.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
//Метод для сохранения индекса вопроса, при уничтожении жизненного цикла активити.
        if (savedInstanceState!=null){
            mCurrentIndex=savedInstanceState.getInt(INDEX_QUESTION,0);
        }
//Иницилизация наших вью элементов.
        mButtonTrue=findViewById(R.id.button_true);
        mButtonTrue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkAnswer(true);
            }
        });
        mButtonFalse=findViewById(R.id.button_false);
        mButtonFalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
        mButtonCheckAnswer=findViewById(R.id.button_check_answer);
        mButtonCheckAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean answerTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();//Создаём переменную, содержащию правильный ответ данного элемента массива.

                Intent intent=CheateActivity.newIntent(MainActivity.this,answerTrue);//Передача переменной в статический интент CheateActivity.
                        startActivity(intent);
            }
        });
        mButtonNext=findViewById(R.id.next_question);
        mButtonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex=(mCurrentIndex+1)%mQuestionBank.length;//Метод для переходу по массиву вопросов на +1.
                updateQuestion();//Метод для отображения очередного вопроса,после перехода по массиву.
            }
        });

        mTextQuestion=findViewById(R.id.question_text_view);
        updateQuestion();//Метод для отображения вопросов при входе в приложение.
    }

    private void updateQuestion() {

        int question=mQuestionBank[mCurrentIndex].getQuestionResId();
        mTextQuestion.setText(question);

    }
//Метод для отображения нажатий кнопок True и False.
    private void checkAnswer(boolean userPressed) {

        boolean answerTrue=mQuestionBank[mCurrentIndex].isAnswerTrue();//Создаём переменную, которая равна верному ответу данного элемента массива.
        int messageResId=0;//Создаём переменную, которая в дальнейшем понадобится для вывода сообщения о правильности или не правильности ответа. Т.к.

        if (userPressed==answerTrue){//Если мы нажимаем кнопку, метод которой имеет логику True((checkAnswer(true)), и нажатая кнопка соответствует правильному ответу элемента массива вопроса(mQuestionBank[mCurrentIndex].isAnswerTrue), то выведится уведомелние о правильности ответа.
            messageResId=R.string.answer_true;
        }
        else {
            messageResId=R.string.answer_false;
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_LONG).show();
    }

//Методы жизненного цикла активити.
    @Override
    public void onStart(){
        super.onStart();
    }
    @Override
    public void onResume(){
        super.onResume();
    }
    @Override
    public void onPause(){
        super.onPause();
    }
//    Метод для сохранения индекса массива и восстановления вью с данным индексом вопроса.
    @Override
    public void onSaveInstanceState(Bundle savedStateInstance){
        super.onSaveInstanceState(savedStateInstance);
        savedStateInstance.putInt(INDEX_QUESTION,mCurrentIndex);
    }
    @Override
    public void onStop(){
        super.onStop();
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
    }
}
