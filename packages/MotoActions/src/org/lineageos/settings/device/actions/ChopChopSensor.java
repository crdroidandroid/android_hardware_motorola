/*
 * SPDX-FileCopyrightText: 2015-2016 The CyanogenMod Project
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.settings.device.actions;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;

import org.lineageos.settings.device.MotoActionsSettings;
import org.lineageos.settings.device.SensorHelper;

public class ChopChopSensor implements SensorEventListener, UpdatedStateNotifier {
    private static final String TAG = "MotoActions-ChopChopSensor";

    private final MotoActionsSettings mMotoActionsSettings;
    private final SensorHelper mSensorHelper;
    private final Sensor mSensor;
    private final Sensor mProx;

    private boolean mIsEnabled;
    private boolean mProxIsCovered;

    public ChopChopSensor(MotoActionsSettings motoActionsSettings, SensorHelper sensorHelper) {
        mMotoActionsSettings = motoActionsSettings;
        mSensorHelper = sensorHelper;
        mSensor = sensorHelper.getChopChopSensor();
        mProx = sensorHelper.getProximitySensor();
    }

    @Override
    public synchronized void updateState() {
        if (mMotoActionsSettings.isChopChopGestureEnabled() && !mIsEnabled) {
            Log.d(TAG, "Enabling");
            mSensorHelper.registerListener(mSensor, this);
            mSensorHelper.registerListener(mProx, mProxListener);
            mIsEnabled = true;
        } else if (!mMotoActionsSettings.isChopChopGestureEnabled() && mIsEnabled) {
            Log.d(TAG, "Disabling");
            mSensorHelper.unregisterListener(this);
            mSensorHelper.unregisterListener(mProxListener);
            mIsEnabled = false;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        Log.d(TAG, "chop chop triggered");
        if (mProxIsCovered) {
            Log.d(TAG, "proximity sensor covered, ignoring chop-chop");
            return;
        }
        mMotoActionsSettings.chopChopAction();
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }

    private final SensorEventListener mProxListener = new SensorEventListener() {
        @Override
        public synchronized void onSensorChanged(SensorEvent event) {
            float maxRange = Math.round(mProx.getMaximumRange() * 10f) / 10f;
            mProxIsCovered = event.values[0] < maxRange;
        }

        @Override
        public void onAccuracyChanged(Sensor mSensor, int accuracy) {
        }
    };
}
