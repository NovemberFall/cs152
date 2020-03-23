// function outputNumbers(count) {
//     for (var i = 0; i < count; i++) {
//         console.log(i);
//     }

//     console.log("************total:");
//     console.log(i);   //计数
// }


// outputNumbers(10);



////////////////

















// function outputNumbers(count) {
//     for (var i = 0; i < count; i++) {
//         console.log(i);
//     }

//     var i;         //重新声明变量

//     console.log("************total:");
//     console.log(i);      //计数
// }

// outputNumbers(10);


















function outputNumbers(count) {
    (function () {
        for (var i = 0; i < count; i++) {
            console.log(i);
        }
    })();

    console.log(i);   //导致一个错误！
}

outputNumbers(10);