function Car(make, model, year) {
    this.make = make;
    this.model = model;
    this.year = year;
    this.honk = function () {
        console.log("honk!");
    } //假设构造函数里有 honk, 即使外面创建一个prototype.honk, 也没用！
}

Car.prototype.honk = function () {
    console.log("Meep!");
}

var car1 = new Car("Chevy", "Nova");
var car2 = new Car("Tesla", "Model S", 2014);
var car2 = Car("Ford", "Explorer", 2001);   //Forgot to call "new"

car1.honk();
delete car2.honk;