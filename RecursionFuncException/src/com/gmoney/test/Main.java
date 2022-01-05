package com.gmoney.test;

public class Main {

    public static void main(String[] args) {

        Test t = new Test();
        int i = 0;

        try {
            t.testFunction(i);
        } catch (ApiBizException e) {
            System.out.println("Main : " + e.getResponseBody());
        } catch (Exception e) {
            System.out.println("Exception Main");
        }
    }
}
