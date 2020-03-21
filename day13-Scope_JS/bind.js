// Bind, call and apply
var john = {
    name: 'John',
    age: 25,
    job: 'teacher',
    presentation: function (style, timeOfDay) {
        if (style === 'formal') {
            console.log('Good ' + timeOfDay + ' ,Ladies ' +
                'gentlemen! I\'m ' + this.name +
                ', I\'m a ' + this.job + ' and I\'m ' +
                this.age + ' years old.');
        } else if (style === 'friendly') {
            console.log('Hey! What\'s up? I\'m ' + this.name +
                ', I\'m a ' + this.job + ' and I\'m ' +
                this.age + ' years old. Have a nice ' +
                timeOfDay + '.');
        }
    }
};

var emily = {
    name: 'Emily',
    age: 35,
    job: 'designer'
};


/*   bind method
It is very similar to the call method as well, so it also allows us to set the this variable explicitly.
However, the difference here is that bind doesn't immediately call the function,
but instead it generates a copy of the function so that we can store it somewwhere
*/

var johnFriendly = john.presentation.bind(john, 'friendly');
johnFriendly('morning');
johnFriendly('night');


var emilyFormal = john.presentation.bind(emily, 'formal');
emilyFormal('afternoon');




/* function as arguments; bind method */
var years = [1990, 1965, 1937, 2005, 1998];
function arrayCalc(arr, fn) {
    var arrRes = [];
    for (var i = 0; i < arr.length; i++) {
        arrRes.push(fn(arr[i]));
    }
    return arrRes;
}

function calculateAge(el) {
    return 2019 - el;
}

function isFullAge(limit, el) {
    return el >= limit;
}

var ages = arrayCalc(years, calculateAge);
var fullJapan = arrayCalc(ages, isFullAge.bind(this, 20));
console.log(ages);
console.log(fullJapan);