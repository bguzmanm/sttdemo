package cl.sustantiva.sttdemo.web.restcontroller;

import cl.sustantiva.sttdemo.domain.dto.CityDTO;
import cl.sustantiva.sttdemo.domain.service.CityService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/city")
public class CityRestController {

    private final CityService service;

    public CityRestController(CityService service) {
        this.service = service;
    }

    @GetMapping("/name/{name}")
    @ApiOperation("Return all cities")
    @ApiResponses({
            @ApiResponse(code=200, message = "Ok"),
            @ApiResponse(code=404, message = "Cities not found"),
    })
    public ResponseEntity<List<CityDTO>> getCityByName(@ApiParam(value="name of city", required = true)
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
    public ResponseEntity<List<CityDTO>> getCityByCountry(@ApiParam(value = "id of country", required = true)
                                                           @PathVariable("countryId") int countryId){
//        if (service.getByCountry(countryId).map(List::size).orElse(0)>0){
//            return service.getByCountry(countryId)
//                    .map(cities -> new ResponseEntity<>(cities, HttpStatus.OK))
//                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK) ;

    }
    @GetMapping("/all")
    @ApiOperation("Return all cities")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<List<CityDTO>> getAll(){
        return new ResponseEntity<>(service.getAll(), HttpStatus.OK);
    }
    @GetMapping("/{cityId}")
    @ApiOperation("Return a city by id")
    @ApiResponses({
            @ApiResponse(code = 200, message = "Ok"),
            @ApiResponse(code = 404, message = "City not found"),
    })
    public ResponseEntity<CityDTO> getOne(@ApiParam(value="the id of city", required = true)
                                       @PathVariable("cityId") int cityId){
        return service.getCity(cityId)
                .map(city -> new ResponseEntity<>(city, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    @ApiOperation("Save a City")
    @ApiResponse(code = 200, message = "Ok")
    public ResponseEntity<CityDTO> save(@ApiParam(value = "city", required = true) @RequestBody CityDTO city){
        return new ResponseEntity<>(service.save(city), HttpStatus.OK);
    }

    @DeleteMapping("/del/{cityId}")
    @ApiOperation("Delete a City")
    @ApiResponses({
            @ApiResponse(code=200, message = "ok"),
            @ApiResponse(code=404, message = "city not found"),
    })
    public ResponseEntity delete(@ApiParam(value = "id of city", required = true) @PathVariable("cityId") int cityId){
        if (service.delete(cityId)){
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }



}
