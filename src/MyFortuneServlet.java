

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Objects;

@WebServlet("/fortune")
public class MyFortuneServlet extends HttpServlet {
    HashMap<Person, String> map = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html;charset=UTF-8");

        String[] fortuneTelling = new String[5];
        fortuneTelling[0] = "길가다 돌을 맞는다";
        fortuneTelling[1] = "길가다가 총을 맞는다";
        fortuneTelling[2] = "길가다가 돈을 줍는다";
        fortuneTelling[3] = "길가다가 똥을 맞는다";
        fortuneTelling[4] = "사업이 망한다";

        int random = (int) (Math.random() * fortuneTelling.length);



        String name =request.getParameter("name");
        String dob = request.getParameter("dob");

        if(map.containsKey(new Person(name,dob))){
            print(response, map, name, dob);
            System.out.println("if");
        }else{
            map.put(new Person(name, dob), fortuneTelling[random]);
            print(response, map, name, dob);
            System.out.println("else");
            System.out.println(map);
        }



    }

    private static void print(HttpServletResponse response, HashMap<Person, String> map, String name, String dob) throws IOException {
        PrintWriter out = response.getWriter();
        out.print("<h1>"+ name +"님의 오늘의 운세</h1><hr>");
        out.print("<h2>"+ map.get(new Person(name, dob)) +"</h2><hr>");
        out.print("<a href='fortune.html'>다시하기</a>");
        out.close();
    }


}

class Person {
    String name;
    String dob;

    public Person(String name, String dob) {
        this.name = name;
        this.dob = dob;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(dob, person.dob);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dob);
    }

    @Override
    public String toString() {
        return name;
    }
}
