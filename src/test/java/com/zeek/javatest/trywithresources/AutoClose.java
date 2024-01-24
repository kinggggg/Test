package com.zeek.javatest.trywithresources;

/**
 * @ClassName AutoClose
 * @Description
 * @Author liweibo
 * @Date 2019/8/5 5:43 PM
 * @Version v1.0
 **/
public class AutoClose implements AutoCloseable {

    @Override
    public void close() {
        System.out.println(">>> close()");
        throw new RuntimeException("Exception in close()");
    }

    public void work() throws MyException {
        System.out.println(">>> work()");
        throw new MyException("Exception in work()");
    }

    public static void main(String[] args) {
        try (AutoClose autoClose = new AutoClose()) {
            autoClose.work();
        } catch (MyException e) {
            System.out.println("catch MyException");
            e.printStackTrace();
        }finally {
            System.out.println("finally");
        }
    }
}

class MyException extends Exception {

    public MyException() {
        super();
    }

    public MyException(String message) {
        super(message);
    }
}
