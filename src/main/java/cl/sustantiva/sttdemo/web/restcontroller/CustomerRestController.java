package cl.sustantiva.sttdemo.web.restcontroller;

import cl.sustantiva.sttdemo.domain.dto.CustomerDTO;
import cl.sustantiva.sttdemo.domain.service.CustomerService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer")
public class CustomerRestController {

    private final CustomerService service;

    public CustomerRestController(CustomerService service) {
        this.service = service;
    }

    @GetMapping("/all")
    @ApiOperation("Return all Customers")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<CustomerDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @ApiOperation("Return a Customer by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Customer not found"),
    })
    public ResponseEntity<CustomerDTO> getOne(@ApiParam(value = "the id of customer", required = true) @PathVariable("id") int customerId){
        return service.getOne(customerId)
                .map(customer -> new ResponseEntity<>(customer, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    @ApiOperation("Save a Customer")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<CustomerDTO> save(@ApiParam(value="the customer", required = true) @RequestBody CustomerDTO customer){
        return new ResponseEntity<>(service.save(customer), HttpStatus.OK);
    }

    @DeleteMapping("/del/{id}")
    @ApiOperation("Delete a customer by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Customer not found"),
    })
    public ResponseEntity delete(@ApiParam(value = "the id of customer", required = true) @PathVariable("id") int customerId){
        if (service.delete(customerId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }




}
