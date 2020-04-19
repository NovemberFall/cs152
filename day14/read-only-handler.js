let roHandler = {
    deleteProperty: function (t, prop) {
        return false;
    },
    set: function (t, prop, val, rcvr) {
        return false;
    },
    setPrototypeOf: function (t, p) {
        return false;
    }
};
var constantVals = {
    pi: 3.14,
    e: 2.718,
    goldenRatio: 1.30357
};
var p = new Proxy(constantVals, roHandler);
console.log(p.pi);
delete p.pi;
console.log(p.pi);
p.pi = 3;
console.log(p.pi);