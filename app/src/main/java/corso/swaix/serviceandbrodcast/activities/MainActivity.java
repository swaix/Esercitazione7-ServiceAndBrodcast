package corso.swaix.serviceandbrodcast.activities;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import corso.swaix.serviceandbrodcast.MyApplication;
import corso.swaix.serviceandbrodcast.R;
import corso.swaix.serviceandbrodcast.receivers.MyReceiver;
import corso.swaix.serviceandbrodcast.services.MyIntentService;


public class MainActivity extends Activity implements View.OnClickListener {

    public TextView etReceivedBroadcast;
    MyReceiver myReceiver;
    Button btnSendBroadcast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etReceivedBroadcast = (TextView) findViewById(R.id.etReceivedBroadcast);
        btnSendBroadcast = (Button) findViewById(R.id.btnSendBroadcast);

        MyApplication.setMainActivity(this);
        btnSendBroadcast.setOnClickListener(this);
        myReceiver = new MyReceiver();
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(myReceiver, new IntentFilter(MyIntentService.NOTIFICATION));

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(myReceiver);
    }


    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, MyIntentService.class);
        intent.putExtra("AZIONE","extra AZIONE");
        startService(intent);
        etReceivedBroadcast.setText("servizio inizato");
    }

}