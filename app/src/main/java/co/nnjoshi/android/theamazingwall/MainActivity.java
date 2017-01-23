package co.nnjoshi.android.theamazingwall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import co.nnjoshi.android.theamazingwall.utils.ImageAPITask;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the handle of the view
        LinearLayout changeNowLinearLayout =  (LinearLayout) findViewById(R.id.linearLayoutChangeNow);

        // listen for clicks on the view
        changeNowLinearLayout.setOnClickListener(new View.OnClickListener() {
            /**
             * Gets executed when the view is clicked
             * @param v
             */
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Viola! Your wallpaper changed.", Toast.LENGTH_SHORT).show();
                new ImageAPITask(MainActivity.this).execute();
            }
        });
    }
}
