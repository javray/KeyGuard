package com.javray.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.CordovaInterface;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.view.WindowManager;
import android.app.KeyguardManager;
import android.os.Bundle;

public class KeyGuard extends CordovaPlugin {

    private KeyguardManager.KeyguardLock k1;

    public KeyGuard() {
    }

    @Override
    public void initialize(CordovaInterface cordova, CordovaWebView webView) {

        super.initialize(cordova, webView);

        cordova.getActivity().getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
        cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN|
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

      if (action.equals("disable")) {

        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
              KeyguardManager km =(KeyguardManager)cordova.getActivity().getSystemService(cordova.getActivity().KEYGUARD_SERVICE);
              k1 = km.newKeyguardLock("IN");
              k1.disableKeyguard();
            };
        });
      }
      else if (action.equals("enable")) {
      }

      return false;
    }
}

