package cordova.plugin.navbar;

import android.view.Window;
import android.view.WindowManager;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaWebView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NavigationBar extends CordovaPlugin {

    @Override
    public void initialize(final CordovaInterface cordova, CordovaWebView webView) {
        LOG.v(TAG, "StatusBar: initialization");
        super.initialize(cordova, webView);

        this.cordova.getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                // Clear flag FLAG_FORCE_NOT_FULLSCREEN which is set initially
                // by the Cordova.
                Window window = cordova.getActivity().getWindow();
                window.clearFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
            }
        });
    }

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("setColorByHexString")) {
            String color = args.getString(0);
            this.cordova.getActivity().runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    setColorByHexString(color, callbackContext);
                }
            });
            return true;
        }
        return false;
    }

    private void setColorByHexString(String hexColor, CallbackContext callbackContext) {
        if (Build.VERSION.SDK_INT >= 21) {
            if (hexColor != null && hexColor.length() > 0) {

                final Window window = cordova.getActivity().getWindow();

                try {

                    window.setNavigationBarColor(Color.parseColor(hexColor));

                } catch (Exception e) {
                    callbackContext.error("unable to set navbar color");
                }

            }
        }
    }
}
