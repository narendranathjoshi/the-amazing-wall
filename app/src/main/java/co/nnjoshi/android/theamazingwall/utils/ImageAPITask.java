package co.nnjoshi.android.theamazingwall.utils;

import android.app.WallpaperManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.util.Log;

import java.io.IOException;
import java.util.Objects;

import co.nnjoshi.android.theamazingwall.TheAmazingWallApplication;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by narendranathjoshi on 01/07/16.
 */
public class ImageAPITask extends AsyncTask {
    private Context context;
    private TheAmazingWallAPI api;

    public ImageAPITask(Context context) {
        this.context = context;
    }

    @Override
    protected void onPreExecute() {
        api = TheAmazingWallApplication.initAPI();
        super.onPreExecute();
    }

    @Override
    protected Object doInBackground(Object[] params) {
        // TODO make HTTP GET request to http://nnjoshi.co/the-amazing-wall/api/v1/wallpaper
        try {
            Response<ResponseBody> response = api.getWallpaper().execute();
            WallpaperManager myWallpaperManager
                    = WallpaperManager.getInstance(context);
            try {
                myWallpaperManager.setBitmap(BitmapFactory.decodeStream(response.body().byteStream()));
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } catch (IOException e) {
            Log.e("API", e.getMessage());
        }
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
    }

}
