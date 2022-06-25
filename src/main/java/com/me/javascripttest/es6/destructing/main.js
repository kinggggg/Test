let [a, b, c] = [1, 2, 3]
console.info(a, b, c)

// 交换两个变量的值
let x = 1;
let y = 2;
[x, y] = [y, x];
console.info(x, y)

// 提取json数据
let jsonData = {
    name: 'zhangsan',
    age: 18
};
let {name, age} = jsonData;
console.info(name, age)

// 遍历Map结构
var map = new Map();
map.set('name', 'zhangsan');
map.set('age', 18);
for (let [name, age] of map) {
    console.info(name, age)
}
