package com.company;

import java.io.*;

class EncodingConverter {
    static void encodingConverter(String in, String out, String code1, String code2)throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(in), code1));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), code2));
        String s;
        while((s = br.readLine()) != null){
            bw.write(new String(s.getBytes(),code2));
            bw.write("\r\n");
           // bw.flush();
        }
        br.close();
        bw.close();
    }
}
