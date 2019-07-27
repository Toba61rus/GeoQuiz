package com.example.geoquiz;

public class Question {

    private int mQuestionResId;

    public int getQuestionResId() {
        return mQuestionResId;
    }

    public void setQuestionResId(int questionResId) {
        mQuestionResId = questionResId;
    }

    public boolean isAnswerTrue() {
        return mIsAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mIsAnswerTrue = answerTrue;
    }

    private boolean mIsAnswerTrue;

    public Question(int questionResId,boolean isAnswerTrue){

        mQuestionResId=questionResId;
        mIsAnswerTrue=isAnswerTrue;

    }
}
