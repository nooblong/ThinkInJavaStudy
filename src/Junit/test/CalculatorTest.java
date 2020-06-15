package Junit.test;

import Junit.Calaulator;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CalculatorTest {
    /**
     * 初始化方法
     */
    @Before
    public void init(){
        System.out.println("init...");
    }

    /**
     * close
     */
    @org.junit.After
    public void close(){
        System.out.println("close...");
    }

    @Test
    public void testAdd(){
        System.out.println("run");
        //创建对象，调用add
        Calaulator c = new Calaulator();
        int result = c.add(1,2);
        System.out.println(result);
        Assert.assertEquals(3,result);
    }
}
