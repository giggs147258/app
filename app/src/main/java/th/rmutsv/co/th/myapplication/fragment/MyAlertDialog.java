package th.rmutsv.co.th.myapplication.fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import th.rmutsv.co.th.myapplication.R;

public class MyAlertDialog {

    private AlertDialog.Builder objAlert;

    public void NoChooseEveryThing(MainMVC context) {
        objAlert = new AlertDialog.Builder(context.getActivity());
        objAlert.setIcon(R.drawable.danger);
        objAlert.setTitle("Please Choose Answer?");
        objAlert.setMessage("Please Choose Answer on Radiobutton");
        objAlert.setCancelable(false);
        objAlert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });

        objAlert.show();
    }
}
