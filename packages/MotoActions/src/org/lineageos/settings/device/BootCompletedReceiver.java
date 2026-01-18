/*
 * SPDX-FileCopyrightText: 2015 The CyanogenMod Project
 * SPDX-FileCopyrightText: The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package org.lineageos.settings.device;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.UserHandle;
import android.util.Log;

public class BootCompletedReceiver extends BroadcastReceiver {
    private static final String TAG = "MotoActions";

    @Override
    public void onReceive(final Context context, Intent intent) {
        Log.i(TAG, "Booting");
        context.startServiceAsUser(new Intent(context, MotoActionsService.class),
                UserHandle.CURRENT);
    }
}
