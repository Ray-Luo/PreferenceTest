package com.raystone.ray.preferencehack;

import android.content.Context;
import android.content.pm.PackageManager;
import android.preference.DialogPreference;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Ray on 1/9/2016.
 */
public class AboutDialog extends DialogPreference {

    private Context mContext;
    private String mVersionNumber;

    public AboutDialog(Context context)
    {this(context,null);}

    public AboutDialog(Context context, AttributeSet attrs)
    {this(context,attrs,0);}

    public AboutDialog(Context context, AttributeSet attrs, int defStyle)
    {
        super(context,attrs,defStyle);
        mContext = context;
    }

    @Override
    protected View onCreateDialogView()
    {
        LinearLayout layout = new LinearLayout(mContext);
        layout.setOrientation(LinearLayout.VERTICAL);
        TextView splashText = new TextView(mContext);
        String format = "Version %s<br />" + "<a href = \"https://play.google.com/store/apps/details?id=com.raystone.ray.goplaces\">MoreInfo</a>";

        try {
            String packageName = mContext.getPackageName();
            mVersionNumber = mContext.getPackageManager().getPackageInfo(packageName,0).versionName;
        }catch (PackageManager.NameNotFoundException e)
        {e.printStackTrace();}

        if(mVersionNumber != null)
        {
            String aboutMessage = String.format(format,mVersionNumber);
            splashText.setText(Html.fromHtml(aboutMessage));
            splashText.setMovementMethod(LinkMovementMethod.getInstance());
        }
        layout.addView(splashText);
        return layout;
    }
}
