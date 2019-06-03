package ir.codefather.vaadin;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

@Controller
public class TestController {

    /**
     *
     * prepare data and pass to view
     *
     * @return ModelAndView
     */
    @GetMapping("/")
    public ModelAndView test() {
        ModelAndView view = new ModelAndView();
        view.setViewName("parsa1");
        List<Employee> employees = new LinkedList<>();
        for (int i = 0; i < 10; i++) {
            employees.add(new Employee(Integer.toUnsignedLong(i), "parsa " + i, "mihand" + i));
        }

        view.addObject("employees", employees);
        return view;
    }

}
