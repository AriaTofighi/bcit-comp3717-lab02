package ca.bcit.comp3717.lab02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class SpeakActivity extends AppCompatActivity {
    private TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speak);
        tts = new TextToSpeech(getApplicationContext(), status -> {
            tts.setLanguage(Locale.UK);
        });
        setTitle("Speak");
    }

    // Says text
    public void handleSayText(View view) {
        EditText textToSay = findViewById(R.id.et_text_to_say);
        String textToSayText = textToSay.getText().toString();
        if (textToSayText.equals("")) {
            Toast.makeText(getApplicationContext(), "Must enter something to speak.",Toast.LENGTH_SHORT).show();
        }

        tts.speak(textToSay.getText().toString(), TextToSpeech.QUEUE_FLUSH, null);
    }

    public void handleBack(View view) {
        finish();
    }
}