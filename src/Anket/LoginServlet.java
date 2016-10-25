package Anket;

import Anket.entity.Person;
import Anket.entity.PersonContainer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    PersonContainer personContainer = PersonContainer.getContainer();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String surname = req.getParameter("surname");
        int age = Integer.parseInt(req.getParameter("age"));
        Person person = null;

        resp.setContentType("text/html;charset=UTF-8");
        if (!name.isEmpty() && !surname.isEmpty() && age > 0 && age < 100) {
            person = new Person(name, surname, age);
            if (personContainer.isPresent(person)) resp.sendRedirect("/statistics.jsp");
            else {
                personContainer.add(person);
                PersonContainer.writeToFile(personContainer);
                resp.sendRedirect("/questionary.html");
            }
        } else resp.sendRedirect("/wrongparam.html");
    }
}
