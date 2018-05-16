package th.rmutsv.co.th.myapplication.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import th.rmutsv.co.th.myapplication.R;

public class MainMVC extends Fragment{

    public static MainMVC newInstance() {

        MainMVC mainMVC = new MainMVC();
        Bundle bundle = new Bundle();
        mainMVC.setArguments(bundle);
        return mainMVC;
    }

    public Button answer;

    ImageView imvAnimal;
    RadioGroup radAnswer;
    private String strAnswer;
    private MyAlertDialog objMyAlert;
    private Question objQuestion;
    private MyAlertDialog objMyAlertDialog;
    public MediaPlayer objMediaPlayerButton,objMediaPlayerRadioButton,soundbee,soundbird,
            soundcat,soundcow,sounddog,soundelephant,soundhorse,soundlion,soundpig,soundsheep;
    //Button answer;
    int intTime = 1,userChoose,userScore;
    int userChooseArray[],trueAnswer[];
    RadioButton rad1,rad2,rad3,rad4;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.mvc_main, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        //setContentView(R.layout.mvc_main);
        initialWidget();
        answer = getView().findViewById(R.id.btanswer);
        userChooseArray = new int[11];
        trueAnswer = new int[11];
        setValueTrueAnswer();
        final MediaPlayer soundbee = MediaPlayer.create(getActivity(),R.raw.bee);
        final MediaPlayer soundbird = MediaPlayer.create(getActivity(),R.raw.bird);
        final MediaPlayer soundcat = MediaPlayer.create(getActivity(),R.raw.cat);
        final MediaPlayer soundcow = MediaPlayer.create(getActivity(),R.raw.cow);
        final MediaPlayer sounddog = MediaPlayer.create(getActivity(),R.raw.dog);
        final MediaPlayer soundelephant = MediaPlayer.create(getActivity(),R.raw.elephant);
        final MediaPlayer soundhorse = MediaPlayer.create(getActivity(),R.raw.horse);
        final MediaPlayer soundlion = MediaPlayer.create(getActivity(),R.raw.lion);
        final MediaPlayer soundpig = MediaPlayer.create(getActivity(),R.raw.pig);
        final MediaPlayer soundsheep = MediaPlayer.create(getActivity(),R.raw.sheep);
        soundbee.start();
        //soundbee.setLooping(true);
        rad1 = getView().findViewById(R.id.rad1);
        rad2 = getView().findViewById(R.id.rad2);
        rad3 = getView().findViewById(R.id.rad3);
        rad4 = getView().findViewById(R.id.rad4);

        objQuestion = new Question();
        objQuestion.setOnQuestionChangeListener(new Question.OnQuestionChangeListener() {
            @Override
            public void onQuestionChangeListener(Question question) {
                switch (question.getIntQuestion()) {
                    case 1:
                        imvAnimal.setImageResource(R.drawable.bee);
                        rad1.setText(MainMVC.this.getString(R.string.elephant));
                        rad2.setText(MainMVC.this.getString(R.string.bird));
                        rad3.setText(MainMVC.this.getString(R.string.bee));
                        rad4.setText(MainMVC.this.getString(R.string.lion));
                        radAnswer.clearCheck();
                        break;
                    case 2:
                        imvAnimal.setImageResource(R.drawable.bird);
                        rad1.setText(MainMVC.this.getString(R.string.cat));
                        rad2.setText(MainMVC.this.getString(R.string.bird));
                        rad3.setText(MainMVC.this.getString(R.string.dog));
                        rad4.setText(MainMVC.this.getString(R.string.lion));
                        soundbee.stop();
                        soundbird.start();
                        radAnswer.clearCheck();
                        break;
                    case 3:
                        imvAnimal.setImageResource(R.drawable.cat);
                        rad1.setText(MainMVC.this.getString(R.string.dog));
                        rad2.setText(MainMVC.this.getString(R.string.cow));
                        rad3.setText(MainMVC.this.getString(R.string.horse));
                        rad4.setText(MainMVC.this.getString(R.string.cat));
                        soundbird.stop();
                        soundcat.start();
                        radAnswer.clearCheck();
                        break;
                    case 4:
                        imvAnimal.setImageResource(R.drawable.cow);
                        rad1.setText(MainMVC.this.getString(R.string.sheep));
                        rad2.setText(MainMVC.this.getString(R.string.pig));
                        rad3.setText(MainMVC.this.getString(R.string.cow));
                        rad4.setText(MainMVC.this.getString(R.string.bee));
                        soundcat.stop();
                        soundcow.start();
                        radAnswer.clearCheck();
                        break;
                    case 5:
                        imvAnimal.setImageResource(R.drawable.dog);
                        rad1.setText(MainMVC.this.getString(R.string.dog));
                        rad2.setText(MainMVC.this.getString(R.string.elephant));
                        rad3.setText(MainMVC.this.getString(R.string.horse));
                        rad4.setText(MainMVC.this.getString(R.string.lion));
                        soundcow.stop();
                        sounddog.start();
                        radAnswer.clearCheck();
                        break;
                    case 6:
                        imvAnimal.setImageResource(R.drawable.elephant);
                        rad1.setText(MainMVC.this.getString(R.string.sheep));
                        rad2.setText(MainMVC.this.getString(R.string.lion));
                        rad3.setText(MainMVC.this.getString(R.string.bird));
                        rad4.setText(MainMVC.this.getString(R.string.elephant));
                        sounddog.stop();
                        soundelephant.start();
                        radAnswer.clearCheck();
                        break;
                    case 7:
                        imvAnimal.setImageResource(R.drawable.horse);
                        rad1.setText(MainMVC.this.getString(R.string.dog));
                        rad2.setText(MainMVC.this.getString(R.string.cow));
                        rad3.setText(MainMVC.this.getString(R.string.horse));
                        rad4.setText(MainMVC.this.getString(R.string.cat));
                        soundelephant.stop();
                        soundhorse.start();
                        radAnswer.clearCheck();
                        break;
                    case 8:
                        imvAnimal.setImageResource(R.drawable.lion);
                        rad1.setText(MainMVC.this.getString(R.string.lion));
                        rad2.setText(MainMVC.this.getString(R.string.pig));
                        rad3.setText(MainMVC.this.getString(R.string.sheep));
                        rad4.setText(MainMVC.this.getString(R.string.bee));
                        soundhorse.stop();
                        soundlion.start();
                        radAnswer.clearCheck();
                        break;
                    case 9:
                        imvAnimal.setImageResource(R.drawable.pig);
                        rad1.setText(MainMVC.this.getString(R.string.pig));
                        rad2.setText(MainMVC.this.getString(R.string.horse));
                        rad3.setText(MainMVC.this.getString(R.string.elephant));
                        rad4.setText(MainMVC.this.getString(R.string.cat));
                        soundlion.stop();
                        soundpig.start();
                        radAnswer.clearCheck();
                        break;
                    case 10:
                        imvAnimal.setImageResource(R.drawable.sheep);
                        rad1.setText(MainMVC.this.getString(R.string.lion));
                        rad2.setText(MainMVC.this.getString(R.string.pig));
                        rad3.setText(MainMVC.this.getString(R.string.sheep));
                        rad4.setText(MainMVC.this.getString(R.string.bee));
                        soundpig.stop();
                        soundsheep.start();
                        radAnswer.clearCheck();
                        break;
                }
                soundButton();
            }
        });

        radAnswer.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rad1:
                        strAnswer = "1";
                        userChoose = 1;
                        break;
                    case R.id.rad2:
                        userChoose = 2;
                        strAnswer = "1";
                        break;
                    case R.id.rad3:
                        userChoose = 3;
                        strAnswer = "1";
                        break;
                    case R.id.rad4:
                        userChoose = 4;
                        strAnswer = "1";
                        break;
                    default:
                        strAnswer = null;
                        break;
                }
                soundRadioButton();
            }
        });

        answer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkChooseAnswer();
            }
        });
    }

    private void soundRadioButton() {
        objMediaPlayerRadioButton = MediaPlayer.create(getActivity(), R.raw.soundbt);
        objMediaPlayerRadioButton.start();
    }

    private void initialWidget() {
        imvAnimal = getView().findViewById(R.id.imvAnimal);
        radAnswer = getView().findViewById(R.id.radAnswer);
    }

    private void checkChooseAnswer() {
        if (strAnswer != null) {
            Log.d("Answer", "IntTime = " + strAnswer);
            checkScore();
            intTime++;
        }
        else {
            Log.d("Answer", "Please Choose Something");
            objMyAlertDialog = new MyAlertDialog();
            objMyAlertDialog.NoChooseEveryThing(MainMVC.this);
        }
    }

    private void soundButton() {
        objMediaPlayerButton = MediaPlayer.create(getActivity(), R.raw.soundbt);
        objMediaPlayerButton.start();
    }

    private void setValueTrueAnswer() {

        trueAnswer[1] = 3;
        trueAnswer[2] = 2;
        trueAnswer[3] = 4;
        trueAnswer[4] = 3;
        trueAnswer[5] = 1;
        trueAnswer[6] = 4;
        trueAnswer[7] = 3;
        trueAnswer[8] = 1;
        trueAnswer[9] = 1;
        trueAnswer[10] = 3;
    }

    private void checkScore(){
        userChooseArray[intTime] = userChoose;
        Log.d("ChooseArray","userChooseArray["+String.valueOf(intTime)+"] = "+String.valueOf(userChoose));
        if (userChooseArray[intTime]==trueAnswer[intTime]){
            userScore++;
        }Log.d("Score","userScore  = "+String.valueOf(userScore));
        sentValueToQuestion();
    }

    private void sentValueToQuestion() {
        if (intTime == 10) {
            //Answer answer = new Answer();
            getActivity().getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment, Answer.newInstance())
                    .commit();

            /*Intent showScore = new Intent();
            showScore.setClass(getActivity(),Answer.class);
            showScore.putExtra("Score",userScore);
            startActivity(showScore);
            soundsheep.stop();
            //finish();*/
        }

        objQuestion.setIntQuestion(intTime+1);

    }

}
