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


/*   bind method
It is very similar to the call method as well, so it also allows us to set the this variable explicitly.
However, the difference here is that bind doesn't immediately call the function,
but instead it generates a copy of the function so that we can store it somewwhere
*/

var johnFriendly = john.presentation.bind(john, 'friendly');
johnFriendly('morning');
johnFriendly('night');

