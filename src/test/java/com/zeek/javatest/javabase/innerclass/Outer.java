package com.zeek.javatest.javabase.innerclass;

/**
 * @author liweibo03 <liweibo03@kuaishou.com>
 * Created on 2021-04-22
 */
public class Outer {

    public static void main(String[] args) {
        Outer outer = new Outer();
        Inner inner = outer.new Inner();
        inner.getP();
    }

    private class Inner {
        int p;

        public int getP() {
            System.out.println("Car.this: " + Outer.this);
            return p;
        }

        public void setP(int p) {
            this.p = p;
        }
    }

}
