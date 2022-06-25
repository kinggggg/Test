let map1 = new Map([
    ['name', 'zhangsan'],
    ['age', 18]
]);
console.info(map1);

// 遍历key
for(let key of map1.keys()) {
    console.info(key);
}

// 遍历value
for (let value of map1.values()) {
    console.info(value);
}

// 遍历实体对
for (let entry of map1.entries()) {
    console.info(entry[0], entry[1]);
}

