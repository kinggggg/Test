package com.me.kotlintest

class Person {

    constructor() {

    }

    constructor(name: String, isMarried: Boolean) {
        this.name = name
        this.isMarried = isMarried
    }

    var name: String? = null

    var isMarried: Boolean = false
}