package co.nnjoshi.android.theamazingwall.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by narendranathjoshi on 01/07/16.
 */
public class AppSharedPreferences {
    private static String inquestPreferences = "theAmazingWallPreferences";

    public static SharedPreferences.Editor editor(Context context) {
        SharedPreferences sharedpreferences = context.getSharedPreferences(inquestPreferences, Context.MODE_PRIVATE);

        return sharedpreferences.edit();
    }

    public static SharedPreferences getSharedPreferences(Context context) {

        return context.getSharedPreferences(inquestPreferences, Context.MODE_PRIVATE);
    }
}
