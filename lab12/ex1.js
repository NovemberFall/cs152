function makeListOfAdders(lst) {
    var arr = [];
    for (var i = 0; i < lst.length; i++) {
        (() => {
            var n = lst[i];
            arr[i] = (x) => {
                return n + x;
            }
        })();
    }
    return arr;
}


var adders = makeListOfAdders([1, 5, 22]);
console.log(adders[0](42)); // This function adds 1 t0 42 to get 43
console.log(adders[1](42)); // This function adds 2 t0 42 to get 47
console.log(adders[2](42)); // This function adds 2 t0 42 to get 64
