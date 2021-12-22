package me.WhoKnew.AutoJoin.utils;

import org.apache.commons.lang3.Validate;

public class Utils {

    public static final char COLOUR_CHAR = '\u00A7';

    public static String translateAlternativeColourCode(char alternateColourCode, String string){
        Validate.notNull(string, "Cannot translate null text");

        char[] b = string.toCharArray();
        for (int i = 0; i < b.length - 1; i++){
            if(b[i] == alternateColourCode && "0123456789AaBbCcDdEeFfKkLlMmNnOoRrXx".indexOf(b[i + 1]) > -1){
                b[i] = Utils.COLOUR_CHAR;
                b[i + 1] = Character.toLowerCase(b[i + 1]);

            }
        }
        return  new String(b);
    }

    public static String chat(String string){
        return Utils.translateAlternativeColourCode('&', string);
    }

}
