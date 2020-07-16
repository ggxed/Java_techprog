package com.company;
import java.util.ArrayList;
import java.util.Scanner;

class FormattedInput {
    private ArrayList<Object> res = new ArrayList<>();
    private boolean in_correct = false;
    private int in_from_scanf = 0;

    public Object[] scanf(String format) {
        res.clear();
        Scanner sc = new Scanner(System.in);
        System.out.print("\n Введите данные: ");
        String s = "";
        if(sc.hasNextLine()) {
            s = sc.nextLine();
            in_from_scanf = 1;
            sscanf(format, s);
        }
        return res.toArray();
    }

    private Object[] sscanf(String format, String in) {
        String stmp = "";
        int j = 0;
        for(j = 0; j < in.length(); j++)
            if(in.charAt(j) != ' ')
                break;

        int tmp = 0;
        boolean repit = false;
        for (int i = 0; i < format.length(); i++) {
            if (format.charAt(i) == ' ' || format.charAt(i) == '%') {
                continue;
            }
            if (in.charAt(j) == ' ')
                j++;
            if (format.charAt(i) == 'd') {
                tmp = j;
                while (in.charAt(j) != ' ') {
                    if ((int)in.charAt(j) >= 48 && (int)in.charAt(j) <= 57)
                        stmp = stmp + in.charAt(j);
                    else {
                        System.out.print("Вы ввели не целое число ");

                        repit = true;
                        break;
                    }
                    j++;
                    if (j == in.length())
                        break;
                }
                if ( repit == false) {
                    int integertmp = 0;
                    integertmp = Integer.parseInt(stmp);
                    res.add(integertmp);
                    in_correct = true;
                }
                else
                    in_correct = false;
                repit = false;
                stmp = "";
            } else if (format.charAt(i) == 'f') {
                while (in.charAt(j) != ' ') {
                    if (in.charAt(j) >= '0' && in.charAt(j) <= '9' || in.charAt(j) == '.')
                        stmp = stmp + in.charAt(j);
                    else {
                        System.out.println("\n Вы ввели не дробное число");
                        repit = true;
                        break;
                    }
                    j++;
                    if (j == in.length())
                        break;
                }
                if (repit == false) {
                    double tmpdouble = 0.000000000000000000000;
                    tmpdouble = Float.parseFloat(stmp);
                    res.add(tmpdouble);
                    in_correct = true;
                }
                else
                    in_correct = false;
                repit = false;
                stmp = "";
            } else if (format.charAt(i) == 's') {
                String tmpstr = "";
                while (in.charAt(j) != ' ') {
                    tmpstr = tmpstr + in.charAt(j);
                    j++;
                    if (j == in.length())
                        break;
                }
                stmp = "";
                res.add(tmpstr);
            } else if (format.charAt(i) == 'c') {
                char tmpsymbol = '0';
                tmpsymbol = in.charAt(j);
                j++;
                res.add(tmpsymbol);
            }
            else if (format.charAt(i) == 'b') {
                while (in.charAt(j) != ' ') {
                    if (in.charAt(j) == '0' || in.charAt(j) == '1' )
                        stmp = stmp + in.charAt(j);
                    else {
                        System.out.println("\n Вы ввели не бинарное число");
                        repit = true;
                        break;
                    }
                    j++;
                    if (j == in.length())
                        break;
                }
                if (repit == false) {
                    res.add(stmp);
                    in_correct = true;
                }
                else
                    in_correct = false;
                repit = false;
                stmp = "";
            }else if (format.charAt(i) == 'x') {
                while (in.charAt(j) != ' ') {
                    if (in.charAt(j) >= '0' && in.charAt(j) <= '9'||in.charAt(j) >= 'A' && in.charAt(j) <= 'F' )
                        stmp = stmp + in.charAt(j);
                    else {
                        System.out.println("\n Вы ввели не шестнадцатиричное число");
                        repit = true;
                        break;
                    }
                    j++;
                    if (j == in.length())
                        break;
                }
                if (repit == false) {
                    res.add(stmp);
                    in_correct = true;
                }
                else
                    in_correct = false;
                repit = false;
                stmp = "";
            }
            if(!in_correct && in_from_scanf == 1) {
                scanf(format);
            }
            else if(!in_correct && in_from_scanf == 0)
                System.out.println("вы ввели неверные данные");
        }

        return res.toArray();
    }

    public String toString() {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < res.size(); i++) {
            result.append(" ").append(res.get(i));
        }
        return  res.toString();
    }


}
