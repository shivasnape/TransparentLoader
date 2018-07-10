package com.lab.android.transprentprogressloading.customloader;

/*
Created by Shivichu on 6/7/18
*/

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.widget.CardView;
import android.widget.TextView;

import com.lab.android.transprentprogressloading.R;


public class CustomProgressLoader {

    Context mContext;
    Dialog openDialog;
    String sMessage = null;
    boolean bIsCancelable = true;

    int iCornerRadius = 4, iCardElevation = 4;


    public CustomProgressLoader(Context context) {
        this.mContext = context;

    }

    public CustomProgressLoader(Context context, String message, boolean isCancelable, int cornerRadius, int cardElevation) {
        this.mContext = context;
        this.sMessage = message;
        this.bIsCancelable = isCancelable;
        this.iCornerRadius = cornerRadius;
        this.iCardElevation = cardElevation;

    }


    public void showLoadingDialog() {

        openDialog = new Dialog(mContext);
        openDialog.setContentView(R.layout.custom_progress_dialog);
        openDialog.setCanceledOnTouchOutside(bIsCancelable);
        openDialog.setCancelable(bIsCancelable);
        //making transparent Background
        openDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        openDialog.show();

        TextView tMesssage;
        CardView cardView;

        tMesssage = (TextView) openDialog.findViewById(R.id.txt_custom_progress_message);
        cardView = (CardView) openDialog.findViewById(R.id.card_view_custom_progress);

//        cardView.setRadius(iCornerRadius);
//        cardView.setCardElevation(iCardElevation);
//        cardView.setMaxCardElevation(iCardElevation);

        if (sMessage != null) {
            tMesssage.setText(sMessage);
        }


    }

    public Context getmContext() {
        return mContext;
    }

    public void setmContext(Context mContext) {
        this.mContext = mContext;
    }

    public Dialog getOpenDialog() {
        return openDialog;
    }

    public String getMessage() {
        return sMessage;
    }

    public void setMessage(String sMessage) {
        this.sMessage = sMessage;
    }


    public void setIsCancelable(boolean bIsCancelable) {
        this.bIsCancelable = bIsCancelable;
    }

    public void setCardElevation(int iCardElevation) {
        this.iCardElevation = iCardElevation;
    }

    public void setCornerRadius(int iCornerRadius) {
        this.iCornerRadius = iCornerRadius;
    }

    public boolean isShowing() {
        boolean status = true;
        if (openDialog.isShowing()) {
            status = true;
        } else {
            status = false;
        }

        return status;
    }

    public void dismissDialog() {

        if (openDialog != null) {
            if (openDialog.isShowing()) {
                openDialog.dismiss();
            }
        }
    }
}
