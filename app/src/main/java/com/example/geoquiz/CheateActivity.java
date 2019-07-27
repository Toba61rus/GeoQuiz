package com.example.geoquiz;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

//Класс, предназначенный, для приёма от активити правильного ответа и отображения его(подсказка).

public class CheateActivity extends AppCompatActivity {

    private Button mButtonCheckAnswer;
    private TextView mAnswerTextView;
    private boolean answerTrue;

    private static final String EXTRA_ANSWER="com.example.geoquiz.answer";

//    Cтатический интент,для приёма дополнения из другого активити и сохранении данного дополнения в строке.
    public static Intent newIntent(Context packageContect,boolean answerTrue){
        Intent intent=new Intent(packageContect,CheateActivity.class);
        intent.putExtra(EXTRA_ANSWER,answerTrue);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheate);

        answerTrue=getIntent().getBooleanExtra(EXTRA_ANSWER,false);//Инициилизация принятого дополнения.

//        Инициилизация вью элементов.
        mAnswerTextView=(TextView)findViewById(R.id.answer_show_text_view);
        mButtonCheckAnswer=(Button)findViewById(R.id.show_answer_button);
        mButtonCheckAnswer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {//Вывод подсказки по нажатии на кнопку.

                if (answerTrue==true){
                    mAnswerTextView.setText(R.string.button_true);
                }
                else {
                    mAnswerTextView.setText(R.string.button_false);
                }

            }
        });
    }
}
