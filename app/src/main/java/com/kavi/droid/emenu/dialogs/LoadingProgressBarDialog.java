package com.kavi.droid.emenu.dialogs;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.WindowManager;

import com.kavi.droid.emenu.R;

/**
 * Created by kavi707 on 11/15/15.
 * @author Kavimal Wijewardana <kavi707@gmail.com>
 */
public class LoadingProgressBarDialog {

    public static ProgressDialog createProgressDialog(Context mContext) {
        ProgressDialog dialog = new ProgressDialog(mContext);
        try {
            dialog.show();
        } catch (WindowManager.BadTokenException e) {

        }
        dialog.setCancelable(false);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.setContentView(R.layout.dialog_progress);
        // dialog.setMessage(Message);
        return dialog;
    }
}
