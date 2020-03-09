var print = console.log;

function Student(firstName, lastName, studentID) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.studentID = studentID;
    this.display = function () {
        print(this.firstName + " " + this.lastName
            + " " + this.studentID);
    }
}

var studentsArr = [];

studentsArr.push(new Student("Tom", "Zheng", 11111));
studentsArr.push(new Student("Nancy", "Rose", 22222));

var james = new Student("James", "Ding", 33333);
james.graduated = true;
studentsArr.push(james);

let s = {
    firstName: "Tim",
    lastName: "Cook",
    studentID: 44444,
    __proto__: new Student
};

studentsArr.push(s);

for (var i = 0; i < studentsArr.length; i++) {
    studentsArr[i].display();
}




