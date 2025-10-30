package org.example.string;

public class StringTest {

    public static void main(String[] args) {
        String str = "New Jersey";
        System.out.println(str);
        str = str +"1";

        System.out.println(str+"ewee"+"ewewewe"+"gfgfgfg");


        StringBuffer sb = new StringBuffer();
        sb.append("New Jersey");

        sb.append("1");
        sb.append("ewee");

        sb.append("ewewewe");
        sb.append("gfgfgfgJersey");
        System.out.println(sb);
        System.out.println(sb.indexOf("Jersey"));
        System.out.println(sb.insert(4,"US"));

        StringBuilder stringBuilder = new StringBuilder();
    }
}
