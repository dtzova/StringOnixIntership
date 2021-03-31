package com.company;

public class CoolString {

    private char[] value;

    public CoolString(String value) {

        this.value = value.toCharArray();
    }

    public CoolString(char[] value){
        this.value = value;
    }

    public int length() {
        return value.length;
    }

    public String get() {
        return new String(value);
    }

    public boolean search(String data) {

        if (data.length() > length()) return false;

        char[] search = data.toCharArray();

        for (int i = 0; i < length(); i++) {

            if (value[i] == search[0]) {

                if (i + search.length > length()) return false;

                boolean success = true;

                for (int j = 0; j < search.length; j++) {
                    if (value[i + j] != search[j]) {
                        success = false;
                        break;
                    }
                }

                if (success) return true;
            }
        }
        return false;
    }

    public void reverse() {
        int half = 0;

        if (length() % 2 == 0) {
            half = length() / 2;
        } else {
            half = (length() - 1) / 2;
        }

        for (int i = 0; i < half; i++) {

            char temp = value[i];
            value[i] = value[length() - i - 1];
            value[length() - i - 1] = temp;
        }
    }

    public CoolString concat(CoolString s){
        return new CoolString(get() + s.get());
    }

    public static CoolString intToString(int num){
        return new CoolString(""+num);
    }

    public static float stringToFloat(CoolString str){
        return Float.parseFloat(str.get());
    }

    public static CoolString[] split(CoolString string, int splitIndex) throws Exception {

        if(splitIndex <= 0 || splitIndex >= string.length()) throw new Exception("Not a proper split index");

        char[] chars = string.get().toCharArray();
        CoolString[] result = new CoolString[2];

        int secondLength = chars.length - splitIndex;
        int firstLength = chars.length - secondLength;

        char[] temp = new char[firstLength];

        for(int i = 0; i < firstLength; i++){
            temp[i] = chars[i];
        }
        result[0] = new CoolString(temp);

        temp = new char[secondLength];
        for (int i = 0; i < secondLength; i++){
            temp[i] = chars[i + firstLength];
        }
        result[1] = new CoolString(temp);

        return result;
    }
}
