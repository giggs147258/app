package th.rmutsv.co.th.myapplication;

import android.media.MediaPlayer;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageButton;

import th.rmutsv.co.th.myapplication.fragment.Mainfragment;
import th.rmutsv.co.th.myapplication.fragment.Mainfragment2;
import th.rmutsv.co.th.myapplication.fragment.Regisfragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if (savedInstanceState==null) {
            Mainfragment mainfragment = new Mainfragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment,mainfragment)
                    .add(R.id.fragment,new Mainfragment())
                    .commit();
        }
    }
}
