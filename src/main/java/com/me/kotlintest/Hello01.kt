package com.me.kotlintest

import java.util.*

fun main(args: Array<String>) {
    println("Hello World!")

    var af1 = 5.2123123123f;
    println("af1的值为:${af1}");
    println("af1的类型为:${af1.javaClass}");

    var af2 = 5.2123123123;
    println("af2的值为:${af2}");
    println("af2的类型为:${af2.javaClass}");

    print("\n")
    println("aaaaaa")

    println("========================")
    var bookPrice : Byte = 10;
    var itemPrice : Short = 20;
    var total = bookPrice + itemPrice;

    println("表达式可以进行自动类型转换${total.javaClass}")

    println("========================")
    var i : Int = 97;
    println(i.toChar()); //int可以转换为字符输出

    println("========================类型转换")
    var sValue : Short = 5;
    println("sValue类型为${sValue.javaClass}")

    var iValeu : Int = 6;
    //sValue = iValeu; //只要在表达式中才能自动进行类型转换

    var str = "abc"
    //var num : Int = str.toIntOrNull(); //转换完成后的值有肯能为null或者整数值，因此num必须定义成Int?
    //var num2 : Int? = str.toIntOrNull(); //没有此方法？？？？

    println("========================编译器NPE检查")
    var aStr : String? = "abc"
    aStr = null;
    //println(aStr.length) //不能编译通过，编辑自动推断aStr有可能为null，可能出现NPE空指针异常

    println("========================安全调用")
    var b : String? = "abc"
    println(b?.length)
    b = null;
    println(b?.length);

    println("========================字符串测试")
    var str2 = "abc\n123" ;
    println(str2);  //abc和123不在同一行

    var str3 = """
        | 1 \n
        | 2
    """.trimIndent()
    println(str3) //\n字符原样输出

    println("========================运算符和表达式")

    var str4 = "abc.org" ;
    println(str4.contains("abc"))
    println("abc" in str4)
    println(!str4.contains("abc"));

    var list = java.util.ArrayList<String>()
    list.add("a")
    list.add("b")
    println(list.get(0)) //方法获取元素
    println(list[0]) //下标获取元素

    println("========================区间运算符")
    var rang1 = 2..6 //包含边界
    for(num in rang1) {
        println(num)
    }

    println("========================if分支结构")
    var ifTest : Int = 30;
    if(ifTest > 10) {
        println("if")
    }else {
        println("else")
    }

    if(ifTest < 10) {
        println("if")
    }else if(ifTest >= 10 && ifTest < 20) {
        println("else if")
    }else {
        println("else")
    }

    println("========================if语句可以作为表达式")
    var res = if(ifTest > 20) {
        "ifTest 大于20"
    }else {
        "ifTest 小于20"
    }
    println(res);

    println("========================when分支结构========================" +
            "when分支结构代替了java中的switch语句")
    var score = 'B'
    when (score) {
        'A' -> println("优秀")
        'B' -> println("良好")
        'C' -> println("中")
        'D' -> println("及格")
        else -> println("不及格")
    }

    println("========================when分支结构========================" +
            "when分支可以作为表达式的一部分")
    var whenStr = when(score) {
        'A' -> {
            println("优秀")
            "优秀"
        }
        'B' -> {
            println("良好")
            "良好"
        }
        'C' -> {
            println("中")
            "中"
        }
        'D' -> {
            println("及格")
            "及格"
        }
        else -> {
            println("不及格")
            "不及格"
        }
    }
    println(whenStr)

    println("========================when分支结构========================" +
            "when分支结合in,!in使用")
    val age = java.util.Random().nextInt(100);
    println(age)
    var inStr = when(age) {
        in 10..25 -> "当时年少青衫薄"
        in 26..50 -> "风景依稀似去年"
        in 51..100 -> "醉听清吟胜管弦"
        else -> "其他"
    }
    println(inStr)

    println("========================when分支结构========================" +
            "when分支处理类型")
    var inputPrice = 26
    println(realPrice(inputPrice))

    println("========================when分支结构========================" +
            "when分支可以替代if分支")
    println(age)
    var whenIf = when {
        age < 25 -> "当时年少青衫薄"
        age >= 25 && age < 50 -> "风景依稀似去年"
        age >= 51 -> "醉听清吟胜管弦"
        else -> "其他"
    }
    println(inStr)

    println("========================循环结构========================" +
            "while循环结构")
    var count = 0;
    while (count < 10) {
        println("count : ${count}")
        count++
    }
    println("while循环结束")

    println("========================循环结构========================" +
            "do-while循环结构")
    var doWhileCount = 0;
    do {
        println("count : ${count}")
        doWhileCount++;
    }while (doWhileCount < 10)

    println("doWhile循环结束")

    println("========================循环结构========================" +
            "for-in循环结构")
    var max = 7
    var result = 1
    for (num in 1..max) {
        result *= num
    }
    println(result)
    println("for-in循环结束")

    println("========================控制循环结构========================" +
            "break控制")

    for(i in 0..10) {
        println("i : ${i}")
        if(i == 2) {
            break; //遇到break立即跳出循环结构
        }
    }
    println("遇到break立即跳出循环")

    for(j in 5..10) {
        println("j : ${j}")

        for(i in 0..10) {
            println("i : ${i}")
            if(i == 2) {
                break; //遇到break立即跳出循环结构，只能跳出当前循环，不能跳出外层循环
            }
        }
    }
    println("遇到break立即跳出循环结构，只能跳出当前循环，不能跳出外层循环")

    outer@ for(j in 5..10) {
        println("j : ${j}")

        for(i in 0..10) {
            println("i : ${i}")
            if(i == 2) {
                break@outer; //带标号的break可以跳出外层循环
            }
        }
    }
    println("带标号的break可以跳出外层循环")

    println("========================控制循环结构========================" +
            "break控制")

    println("continue跳过本次循环继续进行下一次循环")
    for(i in 0..5) {
        println("i : ${i}")
        if(i == 2) {
            continue;
        }
        println("continue : ${i}")
    }

    println("continue跳过本次循环继续进行下一次循环")
    outer@ for(j in 1..5) {
        println("j : ${j}")

        for(i in 5..6) {
            println("i : ${i}")
            if(i == 6) {
                continue@outer;
            }
            println("continue : ${i}")
        }
    }


    println("========================控制循环结构========================" +
            "return控制")
    returnTest();
    println("遇到return 直接结束整个函数或方法，而不管return处于多少层循环之内")

    println("=============================================================")
    println("========================第5章 数组和集合========================")
    println("=============================================================")

    println("===========================5.1 数组===========================")
    println("===========================5.1.1 创建数组==========================")

    println("创建包含指定元素的数组，相当于java数组的静态初始化")
    var arr1 = arrayOf("Java", "Kotlin") //kotlin自动推断出类型
    println(arr1)
    println("arrayOf创建的array类型为${arr1.javaClass}")
    //创建指定长度，元素为null的数组
    var arr2 = arrayOfNulls<Double>(5) //必须指定类型
    for(e in arr2) {
        println(e)
    }
    //创建长度为0的空数组
    var arr3 = emptyArray<String>() //需要指定类型

    //创建指定长度，但是用lambda表达式初始化的数组
    var arr4 = Array(5, {(it * 2 + 97).toChar()}); //it 代表lambda表达式的形参，初始值在这里为0 貌似是数组元素的index
    for(e in arr4) {
        println(e)
    }
    var arr5 = Array(5, {it + 0.1}); //it 代表lambda表达式的形参，初始值在这里为0
    for(e in arr5) {
        println(e)
    }

    println("创建IntArray")
    val intArrayOf = intArrayOf(1, 2, 3)
    println(Arrays.toString(intArrayOf))
    println("intArrayOf创建的array类型为${intArrayOf.javaClass}")

    var intArray2 = IntArray(5, {it * it})
    println(Arrays.toString(intArray2))
    println("kotlin中数组元素的下标从0开始")
    println(intArray2[0]) //取值
    println(intArray2.get(1)) //取值
    intArray2[3] = 100; //设置值
    intArray2.set(4, 200) //设置值
    println(Arrays.toString(intArray2))

    println("通过Array的size属性遍历数组，其实是Array的下标")
    for (i in 0 until intArray2.size) {
        println("${i} : " + "${intArray2[i]}")
    }
    println("使用Array提供的indices获得索引区间")
    for (i in intArray2.indices) {
        println(intArray2[i])
    }
    println("直接通过for-in循环遍历数组")
    for(i in intArray2) {
        println(i)
    }

    println("通过IndexedValue访问数组的下标和元素值")
    for ((index, value) in intArray2.withIndex()) {
        println("索引为${index}, 元素是${value}")
    }

    println("===========================5.1.5 数组常用方法==========================")
    var intArray3 = arrayOf(1, 2, 3)
    println(intArray3.any({it > 1}))
    println("intArray3.any({it > 1})")

    var nullVal : String? = "abc";
    println(nullVal?.length) //?.表明若nullVal的值为null的话，直接返回null，否则返回nullVal的length属性的值
    nullVal!!.length //无论nullVal的是否为null，均调用其length属性，这有可能产生NPE

    println("===========================多维数组==========================")
    var a = arrayOfNulls<Array<Int>>(4)
    for (i in a.indices) {
        println(Arrays.toString(a[i]))
    }
    println("初始化a数组的第一个元素")
    a[0] = arrayOf(2, 5)
    a[0]?.set(1, 6)
    for (i in a.indices) {
        println(Arrays.toString(a[i]))
    }
    println("a数组的第一个元素时一个一维数组，遍历这个一维数组")
    for (i in a[0]!!.indices) {
        println(a[0]?.get(i))
    }

    println("===========================5.2 Kotlin集合概述==========================")
    println("===========================kotlin只提供了HashSet，HashMap, LinkedHashSet, LinkedHashMap，ArrayList" +
            "并且这些集合也并不是kotlin实现的，只是java中这些集合的一个别名而已" +
            "若需要用其他的集合类可以直接使用java提供的==========================")


    println("创建不可变集合")
    var set = setOf("Java", "Kotlin", "Go");
    println("集合元素按照添加顺序")
    println(set)

    println("创建可变集合")
    var mutableSet = mutableSetOf("Java", "Go");
    println("集合元素按照添加顺序")
    println(mutableSet)

    println("setOf创建的集合实际类型为:${set.javaClass}") //LinkedHashSet
    println("mutableSetOf创建的集合实际类型为:${mutableSet.javaClass}") //LinkedHashSet

    var hashSet = hashSetOf("Java", "Kotlin", "Go")
    println("不保证元素的顺序")
    println(hashSet)
    println("hashSetOf创建的set实际类型为${hashSet.javaClass}")

    var linkedHashSet = linkedSetOf("Java", "Kotlin", "Go")
    println("集合元素按照添加顺序")
    println(linkedHashSet)
    println("linkedSetOf创建的set实际类型为${linkedHashSet.javaClass}")

    var treeSet = sortedSetOf("Java", "Kotlin", "Go")
    println("创建TreeSet${treeSet.javaClass}")
    println(treeSet)
    println("sortedSetOf创建的set集合类型为:${treeSet.javaClass}");

    println("===========================5.3.2 使用Set的方法==========================")
    var set2 = setOf("Java", "Kotlin", "Go")
    println("Set转换成Map")
    var map = set.associateBy { "疯狂" + it + "讲义" }
    println(map)
    println("使用for-in遍历集合")
    for (lan in set2) {
        println(lan)
    }
    println("使用forEach遍历集合")
    println("第一种形式: 通过lambda")
    set2.forEach({ele -> println(ele)})
    println("第二种形式：省略方法的小括号");
    set2.forEach {ele -> println(ele)}
    println("第三种形式：直接省略形参");
    set2.forEach { println(it) }

    println("===========================5.4 List集合==========================")
    println("创建不可变的list集合")
    var list1 = listOf("Java", "Kotlin", "Go")
    println(list1)
    var listOfNotNull = listOfNotNull("Java", "Kotlin", "Go", null)
    println(listOfNotNull)
    println("创建可变的list集合")
    var mutableList = mutableListOf("Java", "Kotlin", "Go")
    println(mutableList)
    println("创建ArrayList")
    var arrayList1 = arrayListOf("Java", "Kotlin", "Go")
    println(arrayList1)

    println("listOf创建的集合实际类型为:${list1.javaClass}") //java.util.Arrays$ArrayList
    println("listOfNotNull创建的集合实际类型为:${listOfNotNull.javaClass}") //java.util.ArrayList
    println("mutableListOf创建的集合实际类型为:${mutableList.javaClass}") //java.util.ArrayList

    println("===========================5.5 Map集合==========================")
    println("创建不可变map")
    var map1 = mapOf("Java" to 86, "Kotlin" to 92, "Go" to 93)
    println(map1)
    var mutableMap = mutableMapOf("Java" to 86, "Kotlin" to 92, "Go" to 93)
    println(mutableMap)
    println("mapOf创建的集合实际类型为:${map1.javaClass}") //java.util.LinkedHashMap
    println("mutableMapOf创建的集合实际类型为:${mutableMap.javaClass}") //java.util.LinkedHashMap

    println("创建HashMap")
    println("不保证顺序")
    var hashMap = hashMapOf("Java" to 86, "Kotlin" to 92, "Go" to 93)
    println(hashMap)
    println("hashMapOf创建的集合实际类型为:${hashMap.javaClass}") // java.util.HashMap
    println("创建LinkedHashMap")
    println("保证顺序")
    var linkedHashMap = linkedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 93)
    println(linkedHashMap)
    println("linkedMapOf创建的集合实际类型为:${linkedHashMap.javaClass}") // java.util.LinkedHashMap
    println("创建TreeMap")
    println("保证顺序,key由小到大排列")
    var treeMap = sortedMapOf("Java" to 86, "Kotlin" to 92, "Go" to 93)
    println(treeMap)
    println("sortedMapOf创建的集合实际类型为:${treeMap.javaClass}") // java.util.TreeMap
    println("===========================遍历map==========================")
    var map2 = mapOf("Java" to 86, "Kotlin" to 92, "Go" to 93)
    println("通过entry进行遍历")
    for (en in map2.entries) {
        println("${en.key} -> ${en.value}")
    }
    println("通过key进行遍历")
    for (key in map2.keys) {
        println("${key} -> ${map2[key]}")
    }
    println("for-in遍历")
    for ((key, value) in map2) {
        println("${key} -> ${value}")
    }
    println("用lambda遍历")
    map2.forEach { println("${it.key} -> ${it.value}") }

    println("=============================================================")
    println("========================第6章 函数和Lambda表达式=================")
    println("=============================================================")

    println("===========================6.1 函数入门==========================")
    var res1 = com.me.kotlintest.max(1, 2)
    println("res : ${res1}")

    foo()
    say()

    println("===========================单表达式函数==========================")
    var area = area(03.0, 4.0);
    println("面积为 : ${area}")
    println("面积为 : ${area(5.0, 6.0)}")

    println("===========================命名参数==========================")
    println(girth(3, 4))
    println(girth(width = 3, height = 4))
    println(girth(height = 4, width = 3))
    println(girth(3, height = 4))

    println("===========================形参默认值==========================")
    sayHi()
    sayHi("张三", "早上好")
    sayHi("张三")
    sayHi(message = "下午好")

    println("===========================个数可变形参：vararg修饰==========================")
    test(2, "疯狂Kotlin", "Go语言")
    // 这样定义可变形参的函数可以编译通过，但是无法这样调用
//    testParam("a", "b", "c", "d")

    var returnFun = returnFun("add")
    println(returnFun(1, 2))
    returnFun = returnFun("sub")
    println(returnFun(1, 2))

}

fun returnFun(name: String): (i: Int, j: Int) -> Int {

    fun add(i: Int, j: Int): Int {
        return i + j
    }

    fun sub(i: Int, j: Int): Int {
        return i - j
    }

    when (name) {
        "add" -> return ::add
        "sub" -> return ::sub
        else -> return ::add
    }

}

/**
 * 可变参数
 */
fun testParam(vararg names: String, username: String) {
    for (name in names) {
        println(name)
    }

    println(username)
}

/**
 * 个数可变形参
 */
fun test(a : Int, vararg books : String) {
    for (b in books) {
        println(b)
    }

    println(a)
}

/**
 * 形参默认值
 */
fun sayHi(name : String = "李四", message : String = "你好") {
    println("${name} ${message}")
}

/**
 * 命名参数
 */
fun girth(width : Int, height : Int) : Int {
    return 2 * (width + height);
}

/**
 * 单表达式函数
 */
fun area(x : Double, y : Double) : Double = x * y;

/**
 * 无返回值形式2
 */
fun say() : Unit {
    println("无返回值形式2")
}

/**
 * 无返回值形式1
 */
fun foo() {
    println("无返回值")
}

/**
 * 比较大小，返回大值
 */
fun max(x : Int, y : Int) : Int {

    if(x > y) {
        return x;
    }else {
        return y;
    }
}

/**
 * 测试 return
 */
fun returnTest() {

    for(j in 0..5) {
        println("j : ${j}")

        for(i in 5..10) {
            println("i : ${i}")
            if(i == 5) {
                return; //遇到return 直接结束整个函数或方法，而不管return处于多少层循环之内
            }
        }
    }
}

/**
 * when分支判断类型
 */
fun realPrice(inputPrice : Any) = when (inputPrice) {
    is String -> inputPrice.toDouble()
    is Int -> inputPrice.toDouble()
    is Double -> inputPrice.toDouble()
    else -> 0.0
}

