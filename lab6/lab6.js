let x = 42;

const foo = () => {
    console.log(x);
}

const bar = () => {
    x = 666;
    foo();
}

bar();
