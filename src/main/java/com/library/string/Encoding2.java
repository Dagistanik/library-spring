package com.library.string;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

public class Encoding2 {
    public static void main(String[] args) throws UnsupportedEncodingException {
        /*
        ������� ������� � ������� ������� � ��������� win-1251, ����������� ���������
         */
        String firstLine = "����� ������";

        byte[] bytes = firstLine.getBytes("windows-1252");
        System.out.println("win-1251 - " + Arrays.toString(bytes));

        /*
        - �������������� ��� ������� � utf-8, ����������� ���������
         */
//        String secondLine = new String(bytes, StandardCharsets.UTF_8);
        byte[] bytesUTF8 = firstLine.getBytes(StandardCharsets.UTF_8);
        System.out.println("UTF-8    - " + Arrays.toString(bytesUTF8));

        /*
        - �������������� ��� ������� � utf-16, ����������� ���������e
         */
//        String thirdLine = new String(bytesUTF8, StandardCharsets.UTF_16);
        byte[] bytesUTF16 = firstLine.getBytes(StandardCharsets.UTF_16);
        System.out.println("UTF-16   - " + Arrays.toString(bytesUTF16));
    }

}
