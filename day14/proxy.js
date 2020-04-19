var target = {};
var p = new Proxy(target, {});
p.a = 37; // op forwarded 
console.log(target.a); // 37.




