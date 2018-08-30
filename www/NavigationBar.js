var exec = require("cordova/exec");

// exports.coolMethod = function(arg0, success, error) {
//   exec(success, error, "NavigationBar", "coolMethod", [arg0]);
// };

var NavigationBar = {
  setColorByHexString: function(color, error) {
    exec(null, error, "NavigationBar", "setColorByHexString", [color]);
  }
};

module.exports = NavigationBar;
