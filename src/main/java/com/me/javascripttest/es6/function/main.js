// 函数形参默认值
function log(x, y = 'hello') {
    console.log(x, y);
}

// 箭头函数
var f1 = v => v;
var f2 = f1(3);
console.log(f2)

var f3 = () => 5;
//  等同于
var f4 = function () {
    return 5;
}

var f5 = (num1, num2) => num1 + num2;
console.log(f5(1, 3))

// 如果箭头函数代码块部分多于一条语句, 需要使用大括号括起来
var f6 = (num1, num2) => {
    const r = num1 + num2;
    return r;
};
console.log(f6(1, 5))

// 如果返回的是一个对象, 必须在对象外加上小括号
var f7 = () => ({name: 'zhangsan', age: 18})
console.log(f7())

let objs = [1, 2, 3].map((item) => ({age: item}));
console.info(objs)
