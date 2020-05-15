function Adder(amount) {
    this.amount = amount;
    // this.add = function () {
    //     console.log("Add...");
    // }
}

Adder.prototype.add = function (x) {
    return this.amount + x;
}

var myAdder = new Adder(1);
// var y = myAdder.add(7);

var tmp = myAdder.add(5);
console.log(tmp)
