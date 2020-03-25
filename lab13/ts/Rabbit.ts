class Rabbit {
	name: string;
	constructor(name: string) {
		this.name = name;
	}
}
	
var theName: string = "Monty";
var r = new Rabbit("Python");

console.log(r.name);
console.log(theName);
