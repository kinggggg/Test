package com.zeek.nebulagraph;

import org.junit.Test;

/**
 * @ClassName ReturnTest
 * @Description return执行时机
 * @Author liweibo
 * @Date 2019/8/5 4:21 PM
 * @Version v1.0
 **/
public class NebulaTest {

    @Test
    public void test1() {
        // 为什么输出的还是负值？
        //int i = -2147483648;
        //int j = -i;
        //int q = Math.abs(i);
        //System.out.println(i);
        //System.out.println(j);
        //System.out.println(q);
        //System.out.println(Integer.MIN_VALUE);
        //System.out.println(Integer.MAX_VALUE);
    }

    @Test
    public void createEdgeTypeTest() {
        for (int k = 0; k < 1000; k++) {
            System.out.printf("create edge serve%s(start_year int,end_year int, type int);\n", k);
        }
    }

    @Test
    public void deleteEdgeTypeTest() {
        for (int k = 0; k < 1000; k++) {
            System.out.printf("DROP EDGE IF EXISTS serve%s;\n", k);
        }
    }

    @Test
    public void insertEdgeDataTest() {
        for (int k = 0; k < 1000; k++) {
            System.out.printf("insert edge serve%s(start_year,end_year, type) values \"player10005\"->\"team20001\"@%s:(%s, %s, %s);\n", k, k, k + 1, k + 2, k);
        }
    }

    @Test
    public void edgeDataTest2() {
        for (int k = 0; k < 1000; k++) {
            System.out.printf("insert edge serve(start_year,end_year) values \"player10004\"->\"team20001\"@%s:(1999, 2018);\n", k);
        }
    }
}
