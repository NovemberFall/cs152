/* 
Write a makeDebugWrapperApply function that takes in a function and returns another function. 
The new function should print out the arguments passed to it, call the original function, 
print out the result, and then return that result. 
Use apply to make this function work. You will likely need to use the built-in arguments object. 
Sample usage is shown below:
*/


function makeDebugWrapperApply(f, thisObj) {
    return function () {
        // YOUR CODE HERE
        console.log("Passing " + x + y);
    }
}

function add(x, y) {
    // console.log("Passing " + x + " " + y);
    return x + y;
}
// Prints 7
console.log(add(3, 4));

add.apply(null, [8, 14]);
var addWrapped = makeDebugWrapperApply(add).apply(null, [8, 14]);
addWrapped.apply(null, [8, 14]);
// First prints "Passing 8 14", 
// then prints "Returning 22", 
// and then prints 22. 
console.log(addWrapped(8, 14));