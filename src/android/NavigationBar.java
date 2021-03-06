package cordova.plugin.navbar;

import android.view.Window;
import android.app.Activity;
import android.graphics.Color;
import android.os.Build;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class NavigationBar extends CordovaPlugin {

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
                    int color = Color.parseColor(hexColor);
                    window.setNavigationBarColor(color);
                } catch (Exception e) {
                    callbackContext.error("unable to set navbar color" + e + hexColor);
                }
            }
        }
    }
}
