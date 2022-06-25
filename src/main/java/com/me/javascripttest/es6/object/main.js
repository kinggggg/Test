// 直接通过变量定义对象
var foo = 'bar';
var baz = {foo}
console.info(baz);

///////////////////////////////

function f1(x, y) {
    return {x, y};
}
console.info(f1(1, 2));
// 等同于
function f2(x, y) {
    return {x : x, y : y};
}
console.info(f2(1, 2));

///////////////////////////////

var o1 = {
    method() {
        return 'hello';
    }
}
console.info(o1.method());
// 等同于
var o2 = {
    method: function() {
        return 'hello';
    }
}
console.info(o2.method());

///////////////////////////////












