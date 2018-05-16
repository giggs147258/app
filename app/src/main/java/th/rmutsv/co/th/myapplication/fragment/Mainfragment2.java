package th.rmutsv.co.th.myapplication.fragment;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import th.rmutsv.co.th.myapplication.R;

public class Mainfragment2 extends Fragment {
    public ImageButton imageButton;

    public static Mainfragment2 newInstance() {

        Mainfragment2 mainfragment2 = new Mainfragment2();
        Bundle bundle = new Bundle();
        mainfragment2.setArguments(bundle);
        return mainfragment2;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Home();
        Game();
    }

    private void Home() {
        final MediaPlayer sound = MediaPlayer.create(getActivity(),R.raw.track);

        imageButton = getView().findViewById(R.id.backbt);
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

    private void Game() {
        final MediaPlayer sound = MediaPlayer.create(getActivity(),R.raw.track);

        imageButton = getView().findViewById(R.id.gamebt);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sound.start();

                MainMVC mainMVC = new MainMVC();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, MainMVC.newInstance())
                        .commit();
            }
        });
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2_main,container,false);

        return view;
    }
}
