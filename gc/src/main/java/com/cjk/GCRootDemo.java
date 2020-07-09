package com.cjk;

/**
 * 在java中，可作为GC Roots的对象有:
 *
 * 虚拟机栈(栈帧中的局部变量区,也叫做局部表量表)中引用的对象
 * 方法区中的类静态属性引用的对象
 * 方法区中常量引用的对象
 * 本地方法栈中JNI(Native方法)引用的对象
 */
public class GCRootDemo {

    private byte[] byteArray = new byte[100*1024*1024];

    private static GCRootDemo2 g2;

    private static final GCRootDemo3 g3 = new GCRootDemo3();

    public static void m1() {
        GCRootDemo g1 = new GCRootDemo();
        System.gc();
        System.out.println("第一次GC完成");
    }
    public static void main(String[] args) {
        m1();
    }
}
