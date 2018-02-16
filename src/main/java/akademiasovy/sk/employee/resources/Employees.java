package akademiasovy.sk.employee.resources;

import akademiasovy.sk.employee.db.MySQL;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employees")

public class Employees {

    @GET
    @Path("/employees")
    @Produces(MediaType.APPLICATION_JSON)
    public String getEmployees(){
        MySQL mySQL=new MySQL();
        List<String> list= mySQL.getEmployees();
        System.out.println(list);
        boolean b= false;
        String result="option({\"name\":[";
        for(String temp:list){
            if(b==true){
                result+=',';
            }
            else
                b=true;
            result+="\""+temp+"\"";
        }
        result+="]})";

        return result;

    }
    @GET
    @Path("/salary/{name}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getCountry(@PathParam("name") String last_name) {

        String salaries = new MySQL().getSalaries(last_name);
        String result = "{\"salary\":\""+salaries+"\"}";
        return result;
    }

}