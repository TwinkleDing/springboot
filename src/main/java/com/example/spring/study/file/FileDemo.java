package com.example.spring.study.file;

import java.io.File;
import java.io.IOException;

/**
 * @author TwinkleDing
 */
public class FileDemo {
    public static void main(String[] args) throws IOException {

        findAllFile();
    }

    /**
     * 查找电脑所有文件
     */
    static void findAllFile() {

    }

    /**
     * 查找文件
     */
    static void findFile() {
        File file = new File("springboot\\aaa");
        File[] files = file.listFiles();
        assert files != null;
        for (File f : files) {
            if (f.isFile() && f.getName().endsWith(".txt")) {
                System.out.println("找到");
            }
        }
    }

    /**
     * 创建文件
     */
    static void createFile() throws IOException {
        File file = new File("springboot\\aaa");
        file.mkdirs();
        File src = new File(file, "a.txt");
        boolean b = src.createNewFile();
        if (b) {
            System.out.println("创建成功");
        } else {
            System.out.println("创建失败");

        }
    }

    static void listFiles() {
        File f = new File("E:\\Demo\\springboot\\src\\main\\java\\com\\example\\spring\\study");
        // listFiles 方法，获取所有文件包含隐藏文件
        File[] files = f.listFiles();
        assert files != null;
        for (File file : files) {
            System.out.println(file.getName());
        }
    }
}
