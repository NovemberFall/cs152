console.log("Part 2: ");


function makeListOfAdders(lst) {
    var arr = [];
    for (var i = 0; i < lst.length; i++) {
        ((lst) => {
            arr[i] = (x) => {
                return x + lst[i];
            }
        })();
    }
    return arr;
}

var adders = makeListOfAdders([1, 3, 99, 21]);
adders.forEach((adder) => {
    console.log(adder(100));
});