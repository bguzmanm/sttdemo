package cl.sustantiva.sttdemo.web.controller;

import cl.sustantiva.sttdemo.domain.dto.StaffDTO;
import cl.sustantiva.sttdemo.domain.service.StaffService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/staff")
public class StaffController {

    Log logger = LogFactory.getLog(StaffController.class);

    private final StaffService service;

    public StaffController(StaffService service) {
        this.service = service;
    }
    @GetMapping
    public String getAll(Model model){
        model.addAttribute("staffs", service.getAll());
        return "listStaff";
    }
    @GetMapping("/{staffId}")
    public String getOne(@PathVariable("staffId") int staffId, Model model){
        model.addAttribute("staff", service.getOne(staffId).orElse(null));
        return "staff";
    }
    @GetMapping("/new")
    public String getOne(Model model){
        return "newStaff";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute StaffDTO staffDTO){
        logger.info("staffDTO: " + staffDTO.toString());
        service.save(staffDTO);
        return "redirect:/staff";
    }

    @GetMapping("/del/{staffId}")
    public String delete(@PathVariable("staffId") int staffId){
        service.delete(staffId);
        return "redirect:/staff";
    }
}
