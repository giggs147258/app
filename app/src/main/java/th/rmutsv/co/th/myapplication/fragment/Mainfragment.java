package th.rmutsv.co.th.myapplication.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.ImageButton;

import th.rmutsv.co.th.myapplication.R;

/**
 * Created by RTP-10305 on 18/4/2561.
 */

public class Mainfragment extends Fragment{

    public ImageButton login,regis;

    public static Mainfragment newInstance() {
        Mainfragment mainfragment = new Mainfragment();
        Bundle bundle = new Bundle();
        mainfragment.setArguments(bundle);
        return mainfragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Regis();
        Login();

    }

    private void Regis(){
            final MediaPlayer sound = MediaPlayer.create(getActivity(),R.raw.track);

            regis = getView().findViewById(R.id.regisbt);
            regis.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    sound.start();

                    Regisfragment regisfragment = new Regisfragment();
                    getActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment, Regisfragment.newInstance())
                            .commit();
                }
            });
    }

    private void Login(){
        final MediaPlayer sound = MediaPlayer.create(getActivity(),R.raw.track);

        login = getView().findViewById(R.id.loginbt);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.start();

                Mainfragment2 mainfragment2 = new Mainfragment2();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, Mainfragment2.newInstance())
                        .commit();
            }
        });
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);



        return view;
    }
}
