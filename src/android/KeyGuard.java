package com.javray.cordova.plugin;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.view.WindowManager;

public class KeyGuard extends CordovaPlugin {

    public KeyGuard() {
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {

      if (action.equals("disable")) {
        cordova.getActivity().runOnUiThread(new Runnable() {
            public void run() {
               cordova.getActivity().getWindow().setType(WindowManager.LayoutParams.TYPE_KEYGUARD_DIALOG);
               cordova.getActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED|WindowManager.LayoutParams.FLAG_FULLSCREEN|
                WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
            };
        });
      }
      else if (action.equals("enable")) {
        cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DISMISS_KEYGUARD);
        cordova.getActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED);
      }

      return false;
    }
}

