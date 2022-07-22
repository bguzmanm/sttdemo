package cl.sustantiva.sttdemo.web.controller;

import cl.sustantiva.sttdemo.domain.service.CustomerService;
import cl.sustantiva.sttdemo.persistence.entity.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    Log logger = LogFactory.getLog(CustomerController.class);

    private final CustomerService service;

    public CustomerController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public String getAllCustomer(Model model){
        model.addAttribute("customers", service.getAll());
        return "listCustomers";
    }

    @GetMapping("/{customerId}")
    public String getCustomerById(@PathVariable("customerId") int customerId, Model model){
        model.addAttribute("customer", service.getOne(customerId).get());
        return "customer";
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute Customer customer, Model model){
        logger.info(customer.toString());
        service.save(customer);
        return "redirect:/customer/all";
    }
    @GetMapping("/new")
    public String newCustomer(){
        return "newCustomer";
    }
    @GetMapping("/del/{customerId}")
    public String delCustomer(@PathVariable("customerId") int customerId){
        service.delete(customerId);
        return "redirect:/customer/all";
    }

}
