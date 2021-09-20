package ca.bcit.comp3717.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Lab02 Home");
    }


    public void handleChangeColor(View view) {
        Random random = new Random();
        view.getRootView().setBackgroundColor(Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256)));
    }

    public void handleSpeak(View view) {
        Intent intent = new Intent(this, SpeakActivity.class);
        startActivity(intent);
    }

    public void handleApiVersion(View view) {
        String manufacturer = android.os.Build.MANUFACTURER;
        String model = android.os.Build.MODEL;
        int version = android.os.Build.VERSION.SDK_INT;
        String versionRelease = android.os.Build.VERSION.RELEASE;

        String messageText = " manufacturer " + manufacturer
                + " \n model " + model
                + " \n version " + version
                + " \n versionRelease " + versionRelease;

        Toast.makeText(getApplicationContext(), messageText,Toast.LENGTH_SHORT).show();

    }

    public void handleShareSerial(View view) {
        String deviceId = Settings.System.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        Intent callIntent = new Intent(Intent.ACTION_SEND);
        callIntent.setType("text/plain");
        callIntent.putExtra(Intent.EXTRA_TEXT, deviceId);
        startActivity(callIntent);
    }
}