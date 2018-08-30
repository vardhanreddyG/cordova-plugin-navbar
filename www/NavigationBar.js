var exec = require("cordova/exec");

// exports.coolMethod = function(arg0, success, error) {
//   exec(success, error, "NavigationBar", "coolMethod", [arg0]);
// };

var NavigationBar = {
  setColorByHexString: function(sucessCallback, error, argument) {
    exec(sucessCallback, error, "NavigatioBar", "setColorByHexString", [
      argument
    ]);
  }
};

module.exports = NavigationBar;
