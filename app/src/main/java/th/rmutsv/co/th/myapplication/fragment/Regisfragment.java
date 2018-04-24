package th.rmutsv.co.th.myapplication.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import th.rmutsv.co.th.myapplication.R;

public class Regisfragment extends Fragment {

    public ImageButton imageButton;

    public static Regisfragment newInstance() {

        Regisfragment regisfragment = new Regisfragment();
        Bundle bundle = new Bundle();
        regisfragment.setArguments(bundle);
        return regisfragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Home();
    }

    private void Home() {
        final MediaPlayer sound = MediaPlayer.create(getActivity(),R.raw.track);

        imageButton = getView().findViewById(R.id.homebt);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.start();
                Regisfragment regisfragment = new Regisfragment();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, Mainfragment.newInstance())
                        .commit();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.regis_main, container,false);

        return view;
    }

}

