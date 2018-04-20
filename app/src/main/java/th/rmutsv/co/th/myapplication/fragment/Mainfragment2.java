package th.rmutsv.co.th.myapplication.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import th.rmutsv.co.th.myapplication.R;

/**
 * Created by RTP-10305 on 20/4/2561.
 */

public class Mainfragment2 extends Fragment{

    public ImageButton back;

    public static Mainfragment2 newInstence() {
        Mainfragment2 mainfragment2 = new Mainfragment2();
        Bundle bundle = new Bundle();
        mainfragment2.setArguments(bundle);
        return mainfragment2;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Home();
    }

    private void Home() {
        back = getView().findViewById(R.id.backbt);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().getSupportFragmentManager().popBackStack();
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
