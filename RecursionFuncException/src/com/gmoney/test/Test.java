package com.gmoney.test;

public class Test {

    public void testFunction(int i) throws ApiBizException {
        int j = i + 1;

        try {
            System.out.println(j);

            if(j == 5) {
                int a = 5 / 0;
            }

            testFunction(j);
        } catch (ApiBizException e) {
            System.out.println(j);
            System.out.println("Api Biz Exception " + j + " : " + e.getResponseBody());
            throw e;
        } catch (Exception e) {
            System.out.println(j);
            System.out.println("Exception " + j);
            throw new ApiBizException(ApiBizException.MessageType.CODE, "test", j);
        }
    }

}
