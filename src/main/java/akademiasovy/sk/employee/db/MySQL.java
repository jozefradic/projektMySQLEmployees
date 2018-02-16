package akademiasovy.sk.employee.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class MySQL {
    private Connection conn;
    private String driver = "com.mysql.jdbc.Driver";
    private String url="jdbc:mysql://localhost:3306/employees";
    private String username="root";
    private String password="";

    public List<String> getEmployees(){
        List<String> list = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from employees";
            PreparedStatement ps= conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                String name=rs.getString("last_name");
                list.add(name);
            }

        }catch (Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }

        return list;
    }

    public String getSalaries(String last_name){
        String salaries="";
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            String query = "SELECT max(salaries.salary) as Salary from salaries inner join employees on employees.emp_no = salaries.emp_no where employees.last_name ='"+last_name+"'";
            PreparedStatement ps= conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                salaries=rs.getString("salary");
            }

        }catch (Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }

        return salaries;
    }
}
