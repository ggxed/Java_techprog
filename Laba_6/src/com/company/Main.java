package com.company;
import com.company.FormattedInput.*;
class Main {

    public static void main(String[] args) {

        FormattedInput a = new FormattedInput();
        a.scanf("%d %s %c ");
        System.out.print(a.toString());
        //a.scanf("%d %s %f");
        //System.out.print(a.toString());


        try {
            EncodingConverter.encodingConverter("in.txt","out.txt","CP1251","UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
