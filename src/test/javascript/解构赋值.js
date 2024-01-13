// 数组的解构赋值
let [a, b, c] = [1, 2, 3];
console.log(a, b, c); // 1 2 3

// set结构，也可以使用数组的解构赋值
let [x, y, z] = new Set(['a', 'b', 'c']);
console.log(x, y, z); // a b c

// 解构赋值允许指定默认值
let [foo = true] = [];
console.log(foo); // true

// === 与 == 的区别 是什么 ？参考有道云笔记总结：https://note.youdao.com/s/UgvwaGf2
console.log('null === undefined: ', null === undefined); // false
console.log('undefined === undefined: ', undefined === undefined); // true
console.log('NaN == NaN: ', NaN == NaN); // false 
console.log('NaN === NaN: ',NaN === NaN); // false 

console.log([1]); // [1]
console.log([1][0]); // 1
console.log([1][1]); // undefined