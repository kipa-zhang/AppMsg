package com.kipa.test.appmsg;

import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.devspark.appmsg.AppMsg;

public class MainActivity extends AppCompatActivity {

    CoordinatorLayout container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        container = (CoordinatorLayout) findViewById(R.id.container);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void createSnackbar(View v){
        Snackbar.make(container, "connection error", Snackbar.LENGTH_LONG)
                .setAction("retry", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        System.out.println("Doing something background!");
                    }
                })
                .show();
    }

    /**
     * Button onClick listener.
     *
     * @param v
     */
    public void showAppMsg(View v) {
        final CharSequence msg = ((Button) v).getText();
        final AppMsg.Style style;
        switch (v.getId()) {
            case R.id.alert:
                style = AppMsg.STYLE_ALERT;
                break;
            case R.id.confirm:
                style = AppMsg.STYLE_CONFIRM;
                break;
            case R.id.info:
                style = AppMsg.STYLE_INFO;
                break;
            case R.id.custom:
                style = new AppMsg.Style(AppMsg.LENGTH_SHORT, R.color.custom);
                break;

            default:
                return;
        }

        // create {@link AppMsg} with specify type
        AppMsg appMsg = AppMsg.makeText(this, msg, style);
        if (((CheckBox) (findViewById(R.id.bottom))).isChecked()) {
            appMsg.setLayoutGravity(Gravity.BOTTOM);
        }
        appMsg.show();
    }
}
