var Employee = (function () {
    function Employee(name, salary) {
        this.name = name;
        this.salary = salary;
    }
    Employee.prototype.display =
        function () {
            console.log(this.name);
        };
    return Employee;
})();
var emp = new Employee("Jon", 87321);
console.log(emp.salary);











var Employee = new function () {
    function Employee(name, salary) {
        this.name = name;
        this.salary = salary;
    }
    Employee.prototype.display =
        function () {
            console.log(this.name);
        };
    return Employee;
}
var emp = new Employee("Jon", 87321);
console.log(emp.salary);
