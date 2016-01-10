package com.raystone.ray.preferencehack;

import android.content.Context;
import android.content.DialogInterface;
import android.preference.DialogPreference;
import android.util.AttributeSet;

/**
 * Created by Ray on 1/9/2016.
 */
public class EmailDialog extends DialogPreference {

    Context mContext;

    public EmailDialog(Context context)
    {this(context,null);}

    public EmailDialog(Context context, AttributeSet attrs)
    {
        this(context,attrs,0);
    }

    public EmailDialog(Context context,AttributeSet attrs, int defStyle)
    {
        super(context,attrs,defStyle);
        mContext = context;
    }

    @Override
    public void onClick(DialogInterface dialogInterface, int which)
    {
        super.onClick(dialogInterface,which);
        if(DialogInterface.BUTTON_POSITIVE == which)
        {
            LaunchEmailUtil.launchEmailToIntent(mContext);
        }
    }
}
