package com.github.javamentorship.mentorship;
import java.sql.*;
public class DBImpl {

        public static void main(String[] a)
                throws Exception {
            Class.forName("org.h2.Driver");
            Connection conn = DriverManager.
                    getConnection("jdbc:h2:~/test", "sa", "");
            // add application code here

            Statement stmt = conn.createStatement();

            String sql = "SELECT id,name,parent_id FROM category";
            ResultSet rs = stmt.executeQuery(sql);
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String name = rs.getString("name");
                int parentId = rs.getInt("parent_id");

                //Display values
                System.out.print("ID: " + id);
                System.out.print(", Name: " + name);
                System.out.println(", Parent ID: " + parentId);
            }
            rs.close();



            conn.close();
        }
}
