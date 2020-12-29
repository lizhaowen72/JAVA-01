package com.geek.course;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.FileChannel;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class HelloClassLoader extends ClassLoader {
	private final static String[] hexDigits = {"0", "1", "2", "3", "4", "5","6", "7", "8", "9", "A", "B", "C", "D", "E", "F"};
    public HelloClassLoader(ClassLoader parent) {
        super(parent);
    }
    public HelloClassLoader() {
    }

    public static void main(String[] args) {
        try {
            HelloClassLoader helloClassLoader = new HelloClassLoader();
            Class<?> hello = helloClassLoader.findClass("Hello");
            Object o = hello.newInstance();
            Method method = hello.getMethod("hello");
            method.invoke(o);
        } catch (InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) {
        byte[] classBytes = new byte[0];
        try {
            classBytes = getClassBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int i = 0; i < classBytes.length; i++) {
            classBytes[i] = (byte) (255 - classBytes[i]);
        }
        return defineClass(name, classBytes, 0,classBytes.length);
    }

    public byte[] decode(String base64) {
        return Base64.getDecoder().decode(base64);

    }
    private byte[] getClassBytes() throws Exception {
        File file = new File("Hello.xlass");
        FileInputStream fis = new FileInputStream(file);
        FileChannel fc = fis.getChannel();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        WritableByteChannel wbc = Channels.newChannel(baos);
        ByteBuffer by = ByteBuffer.allocate(1024);
        while (true) {
            int i = fc.read(by);
            if (i == 0 || i == -1)
                break;
            by.flip();
            wbc.write(by);
            by.clear();
        }
        fis.close();
        return baos.toByteArray();
    }
	 public String byteToHexString(byte b) {
        int n = b;
        if (n < 0)
            n = 256 + n;
        int d1 = n / 16;
        int d2 = n % 16;
        return hexDigits[d1] + hexDigits[d2];
    }
}
