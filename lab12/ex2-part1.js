console.log("Part 1: ");
function makeListOfAdders(lst) {
    var arr = [];
    for (var i = 0; i < lst.length; i++) {
        (() => {
            var n = lst[i];
            arr[i] = (x) => {
                return x + n;
            }
        })();
    }
    return arr;
}

var adders = makeListOfAdders([1, 3, 99, 21]);
adders.forEach((adder) => {
    console.log(adder(100));
});

/**
 * ouptu:
 *  101
 *  103
 *  199
 *  121
 */
