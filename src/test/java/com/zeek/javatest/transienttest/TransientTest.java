package com.zeek.javatest.transienttest;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName TransientTest
 * @Description
 * @Author liweibo
 * @Date 2018/11/27 下午7:12
 * @Version v1.0
 **/
public class TransientTest implements Externalizable {

    private transient String content = "是的，我将会被序列化，不管我是否被transient关键字修饰";

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(content);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        content = (String) in.readObject();
    }

    public static void main(String[] args) throws Exception {

        TransientTest et = new TransientTest();
        ObjectOutput out = new ObjectOutputStream(new FileOutputStream(
                new File("test")));
        out.writeObject(et);

        ObjectInput in = new ObjectInputStream(new FileInputStream(new File(
                "test")));
        et = (TransientTest) in.readObject();
        System.out.println(et.content);

        out.close();
        in.close();
    }
}
