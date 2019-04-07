package com.mengxk.test;

import org.junit.Test;

import java.nio.file.Paths;
import java.util.Scanner;

import static org.junit.Assert.*;

/**
 * Created by mengxk on 2018/11/14.
 */
public class FileTest {
    @Test
    public void getFile() throws Exception {
        Scanner scanner = new Scanner(Paths.get("/Users/mengxk/Documents/myfile.txt"), "UTF-8");
        System.out.println(scanner.next());
    }

}