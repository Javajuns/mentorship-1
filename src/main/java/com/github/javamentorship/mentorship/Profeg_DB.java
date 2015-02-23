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
        return  comment.replaceAll("<", "&lt;").replaceAll(">", "&gt;");
    }
    
    public static void add_safe(String comment) {
        comments.add(out_safe(comment));
    }



}
