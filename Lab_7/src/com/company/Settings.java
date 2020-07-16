package com.company;
import java.util.*;
import java.io.*;
public class Settings {
    private HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

    public void	put(String key, int val) {
        hashMap.put (key, val);
    }

    public int get(String key) {
        try {
            return get(key);
        }
        catch (NullPointerException e) {
            throw new RuntimeException("No element with key: " + key);
        }
    }

    public void delete(String key) {
        try {
            hashMap.remove(key);
        }
        catch (NullPointerException e) {
            throw new RuntimeException("No element with key: " + key);
        }

    }

    public String toString() {
        StringBuilder res = new StringBuilder ();
        for (String key : hashMap.keySet()) {
            res.append (key + ' ' + hashMap.get(key) + "\r\n");
        }
        return res.toString ();
    }

    public static Settings loadFromTextFile(String filename) throws IOException {
        Settings resSettings = new Settings();
        String key = null;
        String value = null;
        InputStream in = new FileInputStream(filename);
        Reader r = new BufferedReader(new InputStreamReader(in));
        Scanner sc = new Scanner (r);
        while (sc.hasNext()) {
            key = sc.next();
            value = sc.next();
            resSettings.put(key, Integer.parseInt(value.replaceAll("\n", "")));
        }
        sc.close ();
        return resSettings;
    }

    public void saveToTextFile(String filename) throws IOException {
        OutputStream out = new FileOutputStream(filename);
        Writer w = new BufferedWriter (new OutputStreamWriter(out));
        String res = this.toString();
        w.write(res, 0, res.length());
        w.close();
    }
    public void saveToBinaryFile(String filename) throws IOException {
        DataOutputStream out = new DataOutputStream(new FileOutputStream(filename));
        for (String key : hashMap.keySet()) {
            out.write(key.getBytes());
            byte b = ' ';
            out.writeByte(b);
            out.writeInt(hashMap.get(key));
        }
        out.close();
    }

    public static Settings loadFromBinaryFile(String filename) throws IOException {
        Settings resSettings = new Settings();
        DataInputStream in = new DataInputStream(new FileInputStream(filename));
        String key = new String("");
        String value = new String("");
        int length = in.available();
        String str = new String ("");
        for (int i = 0; i < length; i++) {
            byte b = in.readByte();
            if (b == ' ') {
                int num = in.readInt();
                i += 4;
                resSettings.put(str, num);
                str = new String ("");
            }
            else {
                str += (char) b;
            }
        }
        in.close();
        return resSettings;
    }


    @Override
    public boolean equals (Object obj) {
        if (this == obj)
            return true;
        if (this == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Settings other = (Settings) obj;
        return hashMap.equals(other.hashMap);
    }
}