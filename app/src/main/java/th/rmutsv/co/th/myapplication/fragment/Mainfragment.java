package th.rmutsv.co.th.myapplication.fragment;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.content.Intent;

import th.rmutsv.co.th.myapplication.R;

/**
 * Created by RTP-10305 on 18/4/2561.
 */

public class Mainfragment extends android.support.v4.app.Fragment{

    public ImageButton login,regis;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Login();

    }

    private void Login(){
        login = getView().findViewById(R.id.loginbt);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Mainfragment2 mainfragment2 = new Mainfragment2();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, Mainfragment2.newInstence())
                        .commit();
            }
        });
    }

    @Nullable
    @Override

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main,container,false);
        return view;
    }
}
