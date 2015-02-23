package com.github.javamentorship.mentorship;

import java.util.ArrayList;
import java.util.List;

public class DB {

    public static final List<String> comments = new ArrayList<String>();

    static {
        DB.comments.add("Coool!");
        DB.comments.add("Sucks!");
    }
    
    public static void add_safe(String comment) {
        
        StringBuffer protectedComment = new StringBuffer(comment);
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
        DB.comments.add(protectedComment.toString());
    } 
        
    
    
}
