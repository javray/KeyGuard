var exec = require('cordova/exec');

function KeyGuard() {
}

KeyGuard.prototype.disable = function(success, error) {
    exec(success, error, "KeyGuard", "disable", []);
};

KeyGuard.prototype.enable = function(success, error) {
    exec(success, error, "KeyGuard", "enable", []);
};


module.exports = new KeyGuard();
