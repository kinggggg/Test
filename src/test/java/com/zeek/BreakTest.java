package com.zeek;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by weibo_li on 16/4/8.
 */
public class BreakTest {

    /**
     * breakֻ�������ڲ�ѭ��,�����������ѭ��;
     */
    @Test
    public void testBreak(){
        int i = 0;

        tt : while(i < 10){

            System.out.println("i = " + i);
            ++i;

            for(; i < 5; ){
                System.out.println("ii = " + i);
                break ;
            }

        }
    }
}
