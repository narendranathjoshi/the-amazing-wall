package co.nnjoshi.android.theamazingwall;

import android.app.Application;

import co.nnjoshi.android.theamazingwall.utils.TheAmazingWallAPI;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by narendranathjoshi on 01/07/16.
 */
public class TheAmazingWallApplication extends Application {
    public static final String SHAREDPREFS_RUN_DAILY = "run_daily";

    public static final String API_BASE_URL_PROD = "https://source.unsplash.com/";
    public static final String API_BASE_URL_DEBUG = "https://source.unsplash.com/";

    /**
     * initializes the image API and makes called depending on the environment
     * @return
     */
    public static TheAmazingWallAPI initAPI() {
        if (BuildConfig.DEBUG) {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL_DEBUG)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(TheAmazingWallAPI.class);
        } else {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_BASE_URL_PROD)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            return retrofit.create(TheAmazingWallAPI.class);
        }
    }
}
