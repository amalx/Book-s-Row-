package com.example.med.test.fragments;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;

public class ProgressDialogFrag extends DialogFragment {
    public ProgressDialog mProgressDialog = null;
    public int            mMax            = 100;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, 0);
        setRetainInstance(true);
    }

    // there seems to be a bug in the compat library - if I don't do the following - the dialog is not show after an orientation switch
    @Override
    public void onDestroyView() {
        if (getDialog() != null && getRetainInstance())
            getDialog().setDismissMessage(null);
        super.onDestroyView();
    }

    public void setMax(int arg1) {
        mProgressDialog.setMax(arg1);
        mMax = arg1;
    }

    public void setProgress(int arg1) {
        mProgressDialog.setProgress(arg1);
    }
}
