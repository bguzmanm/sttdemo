package cl.sustantiva.sttdemo.web.restcontroller;

import cl.sustantiva.sttdemo.domain.service.CityService;
import cl.sustantiva.sttdemo.persistence.entity.City;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    private final CityService service;

    public CityRestController(CityService service) {
        this.service = service;
    }

    @GetMapping("/{name}")
    @ApiOperation("Return all cities")
    @ApiResponses({
            @ApiResponse(code=200, message = "Ok"),
            @ApiResponse(code=404, message = "Cities not found"),
    })
    public ResponseEntity<List<City>> getCityByName(@ApiParam(value="name of city", required = true)
                                                        @PathVariable("name") String name){
        if (service.getByName(name).map(List::size).orElse(0) > 0){
            return service.getByName(name)
                    .map(cities -> new ResponseEntity<>(cities, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/country/{countryId}")
    @ApiOperation("Return all cities by country id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "Cities not found")
    })
    public ResponseEntity<List<City>> getCityByCountry(@ApiParam(value = "id of country", required = true)
                                                           @PathVariable("countryId") int countryId){
        if (service.getByCountry(countryId).map(List::size).orElse(0)>0){
            return service.getByCountry(countryId)
                    .map(cities -> new ResponseEntity<>(cities, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/all")
    @ApiOperation("Return all cities")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<City>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }



}
