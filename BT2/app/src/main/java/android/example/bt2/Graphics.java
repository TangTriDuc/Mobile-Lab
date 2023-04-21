package android.example.bt2;

import android.app.Activity;
import android.os.Bundle;

public class Graphics extends Activity {
    @Override
    public void onCreate (Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(new GraphicsView(this));
    }
}