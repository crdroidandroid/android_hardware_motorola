/*
 * SPDX-FileCopyrightText: 2015 The CyanogenMod Project
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.settings.device.doze;

import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.util.Log;

import org.lineageos.settings.device.SensorAction;

public class DozePulseAction implements SensorAction, ScreenStateNotifier {
    private static final String TAG = "MotoActions";

    private static final int DELAY_BETWEEN_DOZES_IN_MS = 1500;

    private final Context mContext;

    private long mLastDoze;

    public DozePulseAction(Context context) {
        mContext = context;
    }

    @Override
    public void screenTurnedOn() {
    }

    @Override
    public void screenTurnedOff() {
        mLastDoze = System.currentTimeMillis();
    }

    public void action() {
        if (mayDoze()) {
            Log.d(TAG, "Sending doze.pulse intent");
            Intent pulseIntent = new Intent("com.android.systemui.doze.pulse");
            mContext.sendBroadcastAsUser(pulseIntent, UserHandle.CURRENT);
        }
    }

    public synchronized boolean mayDoze() {
        long now = System.currentTimeMillis();
        if (now - mLastDoze > DELAY_BETWEEN_DOZES_IN_MS) {
            Log.d(TAG, "Allowing doze");
            mLastDoze = now;
            return true;
        } else {
            Log.d(TAG, "Denying doze");
            return false;
        }
    }
}
