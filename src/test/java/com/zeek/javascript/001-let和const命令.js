let a = 10;
var b = 1;

// 暂时性死区
// 通过let定义的变量，在定义之前都不能使用. 否则，会导致 ReferenceError 异常
// console.info(c)
// let c = 1;

// 不允许重复声明
function f1() {
    // let a = 10;
    // var a = 1;
}

// 内层变量覆盖外层变量
var tmp = new Date();
function f2() {
    console.info(tmp);
    if (false) {
        var tmp = 'hello world';
    }
}
f2();

// let实际上为JavaScript新增了块级作用域
function f3() {
    let n = 5;
    if (true) {
        let n = 10;
    }
    console.info(n);
}
f3();

console.info('-------------------------');

