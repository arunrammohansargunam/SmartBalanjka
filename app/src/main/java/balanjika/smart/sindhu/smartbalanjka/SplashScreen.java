package balanjika.smart.sindhu.smartbalanjka;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreen extends Activity {

    private static final int TIME = 4 * 100;// 4 seconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_sceen);

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, LogIn.class);
                startActivity(intent);

                SplashScreen.this.finish();

                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);

            }
        }, TIME);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
            }
        }, TIME);

    }

    @Override
    public void onBackPressed() {
        this.finish();
        super.onBackPressed();
    }
}
