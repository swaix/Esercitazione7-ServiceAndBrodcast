package corso.swaix.serviceandbrodcast.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import corso.swaix.serviceandbrodcast.MyApplication;
import corso.swaix.serviceandbrodcast.activities.MainActivity;

public class MyReceiver extends BroadcastReceiver {
 
    @Override
    public void onReceive(Context context, Intent intent) {
         MainActivity mainActivity = MyApplication.getMainActivity();
         mainActivity.etReceivedBroadcast.append("broadcast: "+intent.getAction()+"\n");
    }
     
}