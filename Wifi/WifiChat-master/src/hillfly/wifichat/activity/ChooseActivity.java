package hillfly.wifichat.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import hillfly.wifichat.R;

/**
 * Created by Guan on 2017/10/19.
 */

public class ChooseActivity extends Activity{

    private Button btnCall;
    private Button btnChat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_choose);

        btnCall = (Button) findViewById(R.id.btnCall);
        btnChat = (Button) findViewById(R.id.btnChat);


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = getPackageManager().getLaunchIntentForPackage
                        ("com.jkkccall");
                if (intent != null) {
                    startActivity(intent);
                } else {
                    Toast.makeText(ChooseActivity.this, "你还没有集成这个功能", Toast.LENGTH_SHORT).show();
                }

            }
        });

        btnChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(),MainTabActivity.class));
            }
        });



    }


}
