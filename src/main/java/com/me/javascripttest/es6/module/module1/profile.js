// export 第一种形式
// export var firstName = 'Michael';
// export var lastName = 'Jackson';
// export var year = 1958;

// export 第二种形式
var firstName = 'Michael';
var lastName = 'Jackson';
var year = 1958;

function v1() {

}

function v2() {

}

export {
    firstName, lastName, year,
    v1 as func1,
    v2 as func2
};

export var m = 1;

var n = 1;
export {n};

export function f1() {}

function f2() {}

export {f2};





