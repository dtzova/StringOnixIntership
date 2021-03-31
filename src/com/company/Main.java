package com.company;

public class Main {

    public static void main(String[] args) throws Exception {

        CoolString str = new CoolString("Test 123");

        System.out.println(str.get());

        str.reverse();

        System.out.println(str.get());

        str.reverse();

        SearchTest(str,"123");
        SearchTest(str,"456");

        CoolString[] split = CoolString.split(str,4);

        System.out.println(split[0].get());
        System.out.println(split[1].get());

        str = str.concat(new CoolString("\nConcat test 456"));

        System.out.println(str.get());
    }

    static void SearchTest(CoolString where, String search){

        if(where.search(search)){
            System.out.println(where.get() + " contains " + search);
        }else{
            System.out.println(where.get() + " doesn't contain " + search);
        }
    }
}
