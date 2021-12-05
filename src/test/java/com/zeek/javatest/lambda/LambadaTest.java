package com.zeek.javatest.lambda;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by weibo_li on 2017/5/26.
 */
public class LambadaTest {

    public static class Ele{


        private int intType = 0 ;

        private String stringType = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ;

        public int getIntType() {
            return intType;
        }

        public void setIntType(int intType) {
            this.intType = intType;
        }

        public String getStringType() {
            return stringType;
        }

        public void setStringType(String stringType) {
            this.stringType = stringType;
        }
    }

    @Test
    public void filterTest() {
        List<String> collect = Stream.of("aa", "bb").filter(ele -> ele.equals("cc")).filter(ee -> ee.equals("dd")).collect(Collectors.toList());
        System.out.println(collect);
    }

    @Test
    public void name() {

        List<Integer> list = Arrays.asList(new Integer(2), new Integer(4));


        Integer integer = list.stream()
                .max(Comparator.comparing(Integer::valueOf)).orElse(1);

        System.out.println(integer);

        list.stream().max(Comparator.comparing(Integer::valueOf));


    }

    @Test
    public void testForLoop() {

        List<Ele> eleList = new ArrayList<>();
        for(int i = 0; i < 1000000; i++) {
            Ele ele = new Ele();
            ele.setIntType(i);

            eleList.add(ele);
        }

        long startTime = System.currentTimeMillis();
        System.out.println("开始时间为: " + startTime);

        long endTime = 0;

        for(Ele ele : eleList) {
            ele.setIntType(100);
        }
        endTime = System.currentTimeMillis();
        System.out.println("for循环耗时: " + (endTime -  startTime));

        eleList.parallelStream().forEach(ele -> {ele.setIntType(100);});

        endTime = System.currentTimeMillis();
        System.out.println("并行流耗时为: " + (endTime - startTime));

        endTime = System.currentTimeMillis();
        eleList.parallelStream().forEach(ele -> {ele.setIntType(100);});
        System.out.println("流耗时为: " + (endTime - startTime));



    }

    @Test
    public void testNull() {

        Integer result ;
        List< Integer> someNumbers = Arrays. asList();

        List<Integer> collect = someNumbers.stream().map(integer -> integer).collect(Collectors.toList());
        System.out.println(collect);

    }

    @Test
    public void test() {

        Integer result ;
        List< Integer> someNumbers = Arrays. asList( 1, 2, 2, 4, 5);
        Optional< Integer> firstSquareDivisibleByThree = someNumbers. stream() .map(x -> x * x) .filter(x -> x % 3 == 0) .findFirst();

        firstSquareDivisibleByThree.get();

    }

    @Test
    public void optionalTest() {

        Optional<Object> empty = Optional.empty();
        empty.ifPresent(value -> System.out.println(empty));

    }

    @Test
    public void optionalTest2() {

        String requDetail = "RequestInfo{mapInfo={releasephone=, durationzantorelease=21197133, sign=8b6ee18896fc45519edfa2eff0d1dff5, businessId=videopraise, zanuserid=53054728, sessionid=79590A61-02E1-4393-9889-1AA7E3EFBACA, zanuserid_1440=1, ua=iPhone\t12.2\tautohome\t9.9.3\tiPhone, zanuserid_60=1, videoid_120=1, sessionid_1=1, releaseuserid=33692922, zanlogip_si_19=-100, sessionid_60=1, mzanip_60=1, zanregip_si_19=-100, releasephone_pibl_17=-100, zanuserid_1=1, mzanip_si_19=-100, mzanip=null, videoid=1187302, version=10, releasephone_sptd_24=-100, zanuserid_uibl_9=-100, zanip_si_19=-100, zanlogip_sitd_23=-100, zanphone_sp_20=-100, releasephone_sp_20=-100, zanip_60=1, durationzantolog=23044008, releaseip=null, zanphone=13852121317, zanip_1=1, zanregip_sitd_23=0.0, videoid_10=1, zanregip=223.104.186.230, zanlogip=153.36.26.143, releaseuserid_uibl_9=-100, orderNum=videopraise15572224791138800, zanphone_sptd_24=-100, releaseregip=123.154.244.239, releaselogip=111.2.151.145, platform=app.iphone, videoid_1440=1, videoid_60=1, videoid_2880=1, releaseip_1=1, sessionid_1440=1, mzanip_sitd_23=-100, zanip=183.206.157.169, mzanip_1=1, activityid=0, videoid_30=1, mzanip_1440=1, videoid_1=1, releaseip_1440=1, zanip_sitd_23=-100, zanphone_pibl_17=-100, zanip_1440=1, ts=1557222479113}, returnResult='null', orderNum='videopraise15572224791138800', ruleGroupId='7', businessManagerId='3', businessId='7', address='10.27.74.21', ruleGroupName='RuleGroupProductModel316632A64FD64E2693C91F33C57BDC37', productModelPackge='null', productModelName='null'}" ;

        String[] split = requDetail.split("}")[0].split("\\{")[2].split(",");
        System.out.println(split);

        Map<String, String> collect = Arrays
                .stream(split)
                .filter(ele -> ele.split("=").length == 2)
                .map(kv -> kv.split("="))
                .collect(Collectors
                        .toMap(kv -> kv[0].trim(), kv -> kv[1].trim()));
        System.out.println(collect);

    }
}
