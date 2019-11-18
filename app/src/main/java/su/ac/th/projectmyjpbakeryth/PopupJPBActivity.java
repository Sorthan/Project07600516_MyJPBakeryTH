package su.ac.th.projectmyjpbakeryth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class PopupJPBActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jpbakerypopup);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(PopupJPBActivity.this, LoginPersonalActivity.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
