package hillfly.wifichat.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import hillfly.wifichat.R;
import hillfly.wifichat.common.BaseActivity;

public class WelcomeActivity extends BaseActivity implements OnClickListener {

    private static final String TAG = WelcomeActivity.class.getSimpleName();

    private Button mBtnLogin;
    private String pkName;

    private String getAppInfo() {
        try {
            pkName = this.getPackageName();
            String versionName = this.getPackageManager().getPackageInfo(
                    pkName, 0).versionName;
            int versionCode = this.getPackageManager()
                    .getPackageInfo(pkName, 0).versionCode;
            return pkName + "   " + versionName + "  " + versionCode;
        } catch (Exception e) {
        }
        return null;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        String appInfo = getAppInfo();
        Log.d(TAG,"app="+appInfo);

        //检测版本，是否升级
        checkVersion();

        initViews();
        initEvents();
    }

    private void checkVersion() {

//        startActivity(new Intent(getApplicationContext(),UpdateActivity.class));


    }

    @Override
    protected void initViews() {
        mActionBar = getActionBar();
        mActionBar.hide();
        mBtnLogin = (Button) findViewById(R.id.welcome_btn_login);
    }

    @Override
    protected void initEvents() {
        mBtnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

        case R.id.welcome_btn_login:
            startActivity(LoginActivity.class);
            break;

        }
    }

}
