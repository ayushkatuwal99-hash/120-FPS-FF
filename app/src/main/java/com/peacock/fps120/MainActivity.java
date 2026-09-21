package com.peacock.fps120;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_main);

        TextView status = findViewById(R.id.status);
        Button launch = findViewById(R.id.launch);

        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.M) {
            status.setText("Android 6.0+ is required");
            launch.setEnabled(false);
        } else {
            status.setText(
                "Android " + Build.VERSION.RELEASE + " • 120 FPS READY"
            );
        }

        launch.setOnClickListener(v -> {
            try {
                Intent intent = getPackageManager()
                        .getLaunchIntentForPackage("com.dts.freefireth");

                if (intent == null) {
                    intent = getPackageManager()
                            .getLaunchIntentForPackage("com.dts.freefiremax");
                }

                if (intent != null) {
                    startActivity(intent);
                } else {
                    status.setText("Free Fire is not installed");
                }

            } catch (Exception e) {
                status.setText("Unable to open Free Fire");
            }
        });
    }
}
