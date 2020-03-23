x = 3;
function foo(y) {
    console.log(this.x + y);
};
foo(100);

foo.apply(null, [100]); // Array passed for args 
foo.apply({ x: 4 }, [100]);

foo.call({ x: 4 }, 100); // No array needed
var bf = foo.bind({ x: 5 }); // Create a new function 
bf(100);