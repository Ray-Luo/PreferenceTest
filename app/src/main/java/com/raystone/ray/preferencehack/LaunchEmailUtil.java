package com.raystone.ray.preferencehack;

import android.content.Context;
import android.content.Intent;

/**
 * Created by Ray on 1/9/2016.
 */
public class LaunchEmailUtil {

    public static void launchEmailToIntent(Context context)
    {
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("message/rfc822");
        intent.putExtra(Intent.EXTRA_EMAIL,new String[]{"leiluo.ray@gmail.com"});
        intent.putExtra(Intent.EXTRA_SUBJECT,"Feedback");
        intent.putExtra(Intent.EXTRA_TEXT,"In two and half years");
        context.startActivity(Intent.createChooser(intent,"Send feedback"));
    }
}
