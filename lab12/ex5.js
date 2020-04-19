var Employee = (function () {
    function Employee(name, salary) {
        this.name = name;
        this.salary = salary;
    }

    Employee.prototype.displayWages = function (bonus = 0) {
        console.log(`Annual wages for ${this.name}: ${this.salary + bonus}`);
    }
    return Employee;
})();

var emp1 = new Employee("Nellanus Glacanus", 100000);
var emp2 = new Employee("Joe Bob Briggs", "$20 and half a case of Budweiser ");


var wages1 = makeDebugWrapperApply(emp1.displayWages, emp1);
var wages2 = makeDebugWrapperApply(emp2.displayWages, emp2);


//First prints "Passing 5000",
//then prints "Annual wages for Nellanus Glacanus: 105000",
//then prints "No return value".
wages1(5000);

//First prints "No arguments passed",
//then prints "Annual wages for Nellanus Glacanus: 10000",
//then prints "No return value"
wages1();


