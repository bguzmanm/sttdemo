package cl.sustantiva.sttdemo.web.controller;

import cl.sustantiva.sttdemo.domain.service.CustomerService;
import cl.sustantiva.sttdemo.persistence.entity.Customer;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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
        logger.info("[ buscando id = " + customerId + "]");
        Optional<Customer> c = service.getOne(customerId);
        logger.info("[ está vacío: " + c.isEmpty() + "]");

        model.addAttribute("customer", service.getOne(customerId).get());
        return "customer";
    }

    @PostMapping("/save")
    public String saveCustomer(@RequestBody Customer customer, Model model){
        service.save(customer);
        return "redirect:/customer/all";
    }

}
