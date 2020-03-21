function foo() {
    console.log('.call() executing...');
}
foo();
foo.call(); //this statement is equal to foo()
console.log('\n')


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

john.presentation('formal', 'morning');
/*  output:
Good morning ,Ladies gentlemen! I'm John, I'm a teacher and I'm 25 years old.
 */
john.presentation.call(emily, 'friendly', 'afternoon');
/* output:
Hey! What's up? I'm Emily, I'm a designer and I'm 35 years old. Have a nice afternoon.
 */



/* the above piece of codes:
we called it———— method borrowing,
because we actually borrowed the method from John,
to use it here on the Emily object.
Since we use John's presentation method, but setting the this variable to "emily"
*/








//the other method is called Apply method
/*
the only different way is that this one accepts the arguments as an array
so that's only two arguments,
1. first this variable, and then 2. an array where all the other arguments go.
 */

john.presentation.apply(emily, ['friendly', 'afternoon']);
/*  output:
Hey! What's up? I'm Emily, I'm a designer and I'm 35 years old. Have a nice afternoon.
 */