package com.vij.vijaidlservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;

import com.vij.vijaidlservice.Preferences.preferences;

public class CalcService extends Service {

    private preferences mPreferences;

    @Override
    public void onCreate() {
        super.onCreate();

        mPreferences = new preferences(this);
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return mBinder;
    }

    /**
     * AIDL Definition's
     */

    private final ICalculator.Stub mBinder = new ICalculator.Stub() {

        @Override
        public int add(int x, int y) throws RemoteException {
            return x + y;
        }

        @Override
        public int sub(int x, int y) throws RemoteException {
            return x - y;
        }

        @Override
        public int mul(int x, int y) throws RemoteException {
            return x * y;
        }

        @Override
        public String LoginDetails() {

            return mPreferences.getUserName() + "-" + mPreferences.getPasswd();

        }
    };
}
