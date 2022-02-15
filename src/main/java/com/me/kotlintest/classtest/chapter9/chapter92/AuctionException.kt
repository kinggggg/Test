package com.me.kotlintest.classtest.chapter9.chapter92

/**
 * kotlin自定义异常
 * @author: weibo_li
 * @since: 2019-01-14 上午11:00
 */
class AuctionException: Exception {

    constructor() {}

    constructor(msg: String) : super(msg){}
}