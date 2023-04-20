package com.zeek.aviator;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;

public class AviatorTest {

    /**
     * 逻辑运算
     * @throws Exception
     */
    @Test
    public void test2() throws Exception {
        String expression = "c && (a || b) && d";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<>();
        env.put("a", true);
        env.put("b", false);
        env.put("c", false);
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);
    }

    /**
     * 算式运算
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        String expression = "a-(b-c)>100";
        Expression compiledExp = AviatorEvaluator.compile(expression);
        Map<String, Object> env = new HashMap<>();
        env.put("a", 100.3);
        env.put("b", 45);
        env.put("c", -199.100);
        Boolean result = (Boolean) compiledExp.execute(env);
        System.out.println(result);
    }
}
