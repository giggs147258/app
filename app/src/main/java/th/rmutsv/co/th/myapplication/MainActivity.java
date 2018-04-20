package th.rmutsv.co.th.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import th.rmutsv.co.th.myapplication.fragment.Mainfragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (savedInstanceState == null) {
            Mainfragment mainfragment = new Mainfragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment,mainfragment)
                    .add(R.id.fragment,new Mainfragment())
                    .commit();
        }
    }
}
