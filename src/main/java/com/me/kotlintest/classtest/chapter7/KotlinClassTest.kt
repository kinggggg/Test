package com.me.kotlintest.classtest.chapter7

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2020-11-19
 */
class KotlinClassTest {

    /**
     *
     * [修饰符] class 类名 [constructor 主构造器] {
     *      0到多个次构造器定义...
     *      0到多个属性
     *      0到多个方法
     * }
     *
     * 修饰符 public | internal | private 其中之一; final | open | abstract 其中之一
     * open是final的反义词 修饰类, 方法和属性 表明 类可以被派生子类, 类和方法可以被重写
     *
     * kotlin的类由 类名, 类头(指其泛型声明, 主构造器等)和用花括号包住的类体构成. 其中类头和类体都是可选的
     *
     */

    // Kotlin中的类型由一个或者多个有意义的单词构成, 每个单词的首字母大写, 其余字母小写
    // 单词之间不能有任何分隔符
}

// 只有一个主构造器
// Kotlin中的类可以有0到N个主构造器和0到N个次构造器
// 如果没有为非抽象类定义任何(主次)构造器, 那么系统会为类自动生成一个无参数的主构造器; 一旦人为定义了构造器, 系统就不再自动提供该无参数的主构造器
class User1 constructor(firstName: String) {
}

// 主构造器没有任何修饰的话, 可以省略constructor关键字
class User(firstName: String) {
}
