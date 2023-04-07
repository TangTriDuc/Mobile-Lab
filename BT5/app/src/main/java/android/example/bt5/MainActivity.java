package android.example.bt5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_Google, btn_Phone, btn_View, btn_Send, btn_Picture, btn_Music, btn_Map;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Process button Google
        btn_Google = findViewById(R.id.btn_Google);

        btn_Google.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
                startActivity(intent);
            }
        });

        //Process button Phone
        btn_Phone = findViewById(R.id.btn_Phone);

        btn_Phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_CALL, Uri.parse("tel: (+84)123456789"));
                startActivity(intent);
            }
        });

        //Process button View
        btn_View = findViewById(R.id.btn_View);

        btn_View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("content://contacts/people/"));
                startActivity(intent);
            }
        });

        //Process button Send
        btn_Send = findViewById(R.id.btn_Send);

        btn_Send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("sms:5551234"));
                intent.putExtra("sms_body","T7 nay di ra HN ko?");
                startActivity(intent);
            }
        });

        //Process button Picture
        btn_Picture =   findViewById(R.id.btn_Picture);

        btn_Picture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent();
                myIntent.setType("image/pictures/*");
                myIntent.setAction(Intent.ACTION_GET_CONTENT);
                startActivity(myIntent);

            }
        });

        //Process Button Music
        btn_Music = findViewById(R.id.btn_Music);

        btn_Music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myActivity2 = new Intent("android.intent.action.MUSIC_PLAYER");
                startActivity(myActivity2);
            }
        });

        //Process button Map
        btn_Map = findViewById(R.id.btn_Map);

        btn_Map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String url = "http://maps.google.com/maps?"+"saddr=9.938083,-84.054430&daddr=9.926392,-84.055964";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        });

    }

}
