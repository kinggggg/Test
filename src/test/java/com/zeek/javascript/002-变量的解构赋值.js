// 数组的解构赋值
let [a, b, c] = [1, 2, 3]
console.info(a, b, c);

let [foo, [[bar], baz]] = [1, [[2], 3]];
console.info(foo, bar, baz);

let [x, y, z] = new Set(['a', 'b', 'c']);
console.info(x, y, z);

// 解构赋值允许指定默认值
let [a1, b1 = true] = [false]
console.info(a1, b1);
let [a2, b2 = true] = [false, undefined];
console.info(a2, b2);
let [a3 = 4] = [null];
console.info(a3);

// 对象的解构赋值
let {foo1, bar1} = {foo1: "aaa", bar1: "bbb"};
console.info(foo1, bar1)

// 遍历map数据
let map = new Map();
map.set('first', 'hello');
map.set('second', 'world');
for (let [key, value] of map) {
    console.info(key + " is " + value);
}
