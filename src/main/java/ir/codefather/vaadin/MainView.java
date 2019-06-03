package ir.codefather.vaadin;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinRequest;

import java.util.Collection;

@Route("parsa1")
public class MainView extends VerticalLayout {
    Grid<Employee> grid;
    TextField filter;
    private Button addNewBtn;

    //todo RTL test
    public MainView() {
        this.grid = new Grid<>(Employee.class);
        this.filter = new TextField();
        this.addNewBtn = new Button("New Employee", VaadinIcon.PLUS.create());
        HorizontalLayout horizontalLayout = new HorizontalLayout(filter, addNewBtn);

        add(horizontalLayout, grid);

        Collection<Employee> employees =(Collection) VaadinRequest.getCurrent().getAttribute("employees");
        grid.setItems(employees);

        grid.setHeight("200px");
        grid.setColumns("id", "firstName", "lastName");
        grid.getColumnByKey("id").setWidth("50px").setFlexGrow(0);

        filter.setPlaceholder("Filter by last name");
    }


}
