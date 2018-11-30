import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import amaris.futbol.Service.PlayerService;

@RestController
@RequestMapping(value="/manager")
public class ManagerController {

    @Autowired
    private PlayerService service;

    
    public ManagerController(PlayerService service){
        this.service=service;
    }

    @GetMapping(value = "/list")
    public Iterable list(Model model){
        return service.findAll();
    }

    @GetMapping(value = "/show/{id}")
    public Manager showConsultant(@PathVariable long id, Model model){
        return (Manager) service.findById(id);

    }


    @PostMapping(value = "/add")
    public ResponseEntity saveConsultant(@RequestBody Manager manager){
        service.save(manager);
        return new ResponseEntity("Manager saved successfully", HttpStatus.OK);
    }


    @PutMapping(value = "/update/{id}")
    public ResponseEntity updateConsultant(@PathVariable Long id, @RequestBody Manager manager ){
        service.update(manager);
        return new ResponseEntity("Consultant updated successfully", HttpStatus.OK);
    }


    @DeleteMapping(value="/delete/{id}")
    public ResponseEntity delete(@PathVariable Integer id){
        service.deleteById(id);
        return new ResponseEntity("Product deleted successfully", HttpStatus.OK);

    }
}

