package co.nnjoshi.android.theamazingwall.utils;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by narendranathjoshi on 01/07/16.
 */
public interface TheAmazingWallAPI {
    @GET("random")
    Call<ResponseBody> getWallpaper();
}
