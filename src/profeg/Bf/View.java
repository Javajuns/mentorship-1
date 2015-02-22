/**
 * Created by Проф on 12.02.2015.
 */
public class View {

    /*public String mainView(){
        String out = "";


        return out;
    }*/

    public String inputCode() {
        StringBuilder out = new StringBuilder();

        out.append("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">").
                append("<html>").append("<head>").
                append("<meta http-equiv=\"content-type\" content=\"text/html; charset=utf-8\" />").
                append("<meta name = \"description\" content = \"Here prof will try test MVC pattern on example brainfuck language interpreter\" />").
                append("<title>Brainfuck machine</title></head>").
                append("<body>").
                append("<form action = \"\" name = \"bf_interbreter\">").
                append("<table border = \"0\">").
                append("<tr>").
                append("<td> Input code</td>").
                append("<td><input type = \"text\" name = \"raw_code\"></td>").
                append("<td><input type = \"submit\" name = \"interprete\" value = \"Interprete\"></td>").
                append("</tr>").
                append("<tr>").
                append("<td colspan = \"3\">").
                append("<input type = \"text\" name = \"output\">").
                append("</td></tr></table></form></body></html>");
        return out.toString();
    }

    /*public String outResult() {
        String out = "";


        return out;
    }*/

}
