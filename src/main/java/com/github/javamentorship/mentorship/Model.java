package com.github.javamentorship.mentorship;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/*
 * Created by Проф on 10.02.2015.
 * Brainfuck language interpreter
 * used memory
 * short[] arr = chars[30000]
 * used operators
 * >    shift pointer right     pointer++
 * <    shift pointer left      pointer--
 * +    increment pointer       arr[pointer]++
 * -    decrement pointer       arr[pointer]--
 * [    begin loop              while (arr[pointer]) {
 * ]    end loop                }
 * .    print pointer           sout arr[pointer]
 * ,    enter from input string arr[pointer] = getchar
 */

public class Model {

    //private static String strCommand = "----[---->+<]>++.";
    private static String strCommand = "++++++++++[>+++++++>++++++++++>+++>+<<<<-]>++.>+.+++++++..+++.>++.<<+++++++++++++++.>.+++.------.--------.>+.>.";
    //private static String strCommand = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]++++++++++++++++++++++++++++++++++++++++++++.[-]++++++++++++++++++++++++++++++++.[-]+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.[-]+++++++++++++++++++++++++++++++++.[-]++++++++++.[-]";

    // this vars must be global and static for implementation debug (step by step interprete) process
    // its seems like singletone pattern

    private static final int STACK_LENGHT = 30000;
    public static short[] arr;
    public static Model instance;
    public static boolean isDebug;
    public static char[] cmd_stack;
    public static int cmd_pointer;    //command pointer
    public static int pointer;        //memory pointer
    public static ArrayList<Integer> queue;

    static {
        arr = new short[STACK_LENGHT];
        isDebug = false;
        cmd_stack = strCommand.toCharArray();
        cmd_pointer = 0;
        pointer = 0;
        queue = new ArrayList<Integer>();
        instance = getInstance();
    }

    private Model() {
    }

    public static Model getInstance() {
        if (instance == null) {
            instance = new Model();
        }
        return instance;
    }

    public void setIsDebug(boolean isDebug) {
        isDebug = this.isDebug;
    }
    
    public static String interprete(String strCommand) {
        StringBuilder retString = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        if (!isDebug) {
            cmd_stack = strCommand.toCharArray();
            cmd_pointer = 0;    //command pointer
            pointer = 0;
        }
        
        while (cmd_pointer < cmd_stack.length) {
            switch (cmd_stack[cmd_pointer]) {
                case '+':
                    if ((arr[pointer]+1) > 255) arr[pointer] = 0;
                    else arr[pointer]++;
                    cmd_pointer++;
                    break;
                case '-':
                    if ((arr[pointer]-1) < 0) arr[pointer] = 255;
                    else arr[pointer]--;
                    cmd_pointer++;
                    break;
                case '>':
                    pointer++;
                    cmd_pointer++;
                    break;
                case '<':
                    pointer--;
                    cmd_pointer++;
                    break;
                case '.':
                    retString.append((char) arr[pointer]);
                    cmd_pointer++;
                    break;
                case ',':
                    try {
                        arr[pointer] = (short) Integer.parseInt(reader.readLine());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    cmd_pointer++;
                    break;
                case '[':
                    queue.add(cmd_pointer);
                    cmd_pointer++;
                    break;
                case ']':
                    if ((arr[pointer]) > 0) cmd_pointer = queue.remove(queue.size()-1);
                    else cmd_pointer++;
                    break;
                default:
                    cmd_pointer++;
                    break;

            }
        }
        return retString.toString();
    }

    public static String printMemoryTable() {
        int leftBorder = 0;
        StringBuffer result = new StringBuffer();
        if (Model.pointer - 5 > 0) leftBorder = Model.pointer;
        result.append("<table width = \"100%\" align=\"center\"  bgcolor=\"black\" cellspacing=\"1\">");
        result.append("<caption>MEMORY</caption>");
        result.append("<tr>"); // this row shows pointer number
        for (int i = leftBorder; i < 10; i++) {
            result.append("<td bgcolor=\"white\">");
            result.append(i);
            result.append("<td>");
        }
        result.append("</tr>");
        result.append("<tr>"); // this row shows contains pointer values
        for (int i = leftBorder; i < 10; i++) {
            result.append("<td bgcolor=\"white\">");
            result.append(Model.arr[i]);
            result.append("<td>");
        }
        result.append("</tr>");
        result.append("<tr>"); // this row shows contains pointer
        for (int i = leftBorder; i < 10; i++) {
            if (i == Model.pointer) result.append("<td>");
            else result.append("<td bgcolor=\"white\">");
            result.append("<td>");
        }
        result.append("</tr>");
        result.append("</table");

        return result.toString();
    }

    public static String printCommandTable() {
        int leftBorder = 0;
        StringBuffer result = new StringBuffer();
        if (Model.pointer - 5 > 0) leftBorder = Model.cmd_pointer;
        result.append("<table width = \"100%\" align=\"center\"  bgcolor=\"black\" cellspacing=\"1\">");
        result.append("<caption>COMMANDS</caption>");
        result.append("<tr>"); // this row shows pointer number
        for (int i = leftBorder; i < 10; i++) {
            result.append("<td bgcolor=\"white\">");
            result.append(i);
            result.append("<td>");
        }
        result.append("</tr>");
        result.append("<tr>"); // this row shows contains pointer values
        for (int i = leftBorder; i < 10; i++) {
            result.append("<td bgcolor=\"white\">");
            result.append(Model.cmd_stack[i]);
            result.append("<td>");
        }
        result.append("</tr>");
        result.append("<tr>"); // this row shows contains pointer
        for (int i = leftBorder; i < 10; i++) {
            if (i == Model.cmd_pointer) result.append("<td>");
            else result.append("<td bgcolor=\"white\">");
            result.append("<td>");
        }
        result.append("</tr>");
        result.append("</table");

        return result.toString();
    }

}
