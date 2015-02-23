package com.github.javamentorship.mentorship;

import java.util.ArrayList;
import java.util.List;

public class Profeg_DB {

    public static final List<String> comments = new ArrayList<String>();

    static {
        comments.add("Coool!");
        comments.add("Sucks!");
    }
    
    public static String out_safe(String comment) {
        StringBuilder protectedComment = new StringBuilder(comment);
        int index = 0;
        while (index < protectedComment.length()) {
            if(protectedComment.charAt(index) == '<') {
                protectedComment.deleteCharAt(index);
                protectedComment.insert(index, "&lt;");
                index += 4;
                continue;
            }
            if(protectedComment.charAt(index) == '>') {
                protectedComment.deleteCharAt(index);
                protectedComment.insert(index, "&gt;");
                index += 4;
                continue;
            }
            index++;
        }
        return protectedComment.toString();
        
    }
    
    public static void add_safe(String comment) {

        StringBuilder protectedComment = new StringBuilder(comment);
        int index = 0;
        while (index < protectedComment.length()) {
            if(protectedComment.charAt(index) == '<') {
                protectedComment.deleteCharAt(index);
                protectedComment.insert(index, "&lt;");
                index += 4;
                continue;
            }
            if(protectedComment.charAt(index) == '>') {
                protectedComment.deleteCharAt(index);
                protectedComment.insert(index, "&gt;");
                index += 4;
                continue;
            }
            index++;
        }
        comments.add(protectedComment.toString());
    }



}
