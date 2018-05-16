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
import android.widget.TextView;
import android.widget.Toast;
import th.rmutsv.co.th.myapplication.R;

public class Answer extends Fragment {

    public Button again;
    TextView score;

    public static Answer newInstance() {
        Answer answer = new Answer();
        Bundle bundle = new Bundle();
        answer.setArguments(bundle);
        return answer;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        score = getView().findViewById(R.id.textScore);
        score.setText(String.valueOf(("Score")));
        Again();
        Home();
    }

    private void Again(){
        again = getView().findViewById(R.id.againbt);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MainMVC mainMVC = new MainMVC();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, MainMVC.newInstance())
                        .commit();
            }
        });
    }

    private void Home(){
        again = getView().findViewById(R.id.exitbt);
        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mainfragment mainfragment = new Mainfragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, Mainfragment.newInstance())
                        .commit();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.answer_main, container, false);
    }

}
