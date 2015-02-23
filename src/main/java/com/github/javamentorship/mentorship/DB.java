package com.github.javamentorship.mentorship;

import java.util.ArrayList;
import java.util.List;

public class DB {

    public static final List<String> comments = new ArrayList<String>();

    static {
        DB.comments.add("Coool!");
        DB.comments.add("Sucks!");
    }

}
