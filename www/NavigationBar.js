var exec = require("cordova/exec");

// exports.coolMethod = function(arg0, success, error) {
//   exec(success, error, "NavigationBar", "coolMethod", [arg0]);
// };

var NavigationBar = {
  setColorByHexString: function(arg0, success, error) {
    exec(success, error, "NavigationBar", "setColorByHexString", [arg0]);
  }
};

module.exports = NavigationBar;
