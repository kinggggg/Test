const s = new Set();
[1, 2, 3].map(item => s.add(item))
console.info(s);
for (let i of s) {
    console.info(i);
}

///////////////////////////////

let s2 = new Set([1, 2, 3]);
console.info(s2);

///////////////////////////////
// Set转换为数组Array

let s3 = new Set([1, 2, 3]);
let array1 = Array.from(s3);
console.info(array1);

///////////////////////////////
// 遍历Set
let s4 = new Set([1, 2, 3]);
for (let i of s4) {
    console.info(i);
}
s4.forEach(item => console.info(item));
