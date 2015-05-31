package corso.swaix.serviceandbrodcast;

import android.app.Application;

import corso.swaix.serviceandbrodcast.activities.MainActivity;

public class MyApplication extends Application {

    private static MainActivity mainActivity;

    public static MainActivity getMainActivity() {
        return mainActivity;
    }

    public static void setMainActivity(MainActivity activity) {
        mainActivity = activity;
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

}