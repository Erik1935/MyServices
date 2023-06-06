package nocountryjavareact05.MyServices.controllers;

import lombok.RequiredArgsConstructor;
import nocountryjavareact05.MyServices.dto.Succes;
import nocountryjavareact05.MyServices.dto.registroExperto;
import nocountryjavareact05.MyServices.services.ExpertService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequiredArgsConstructor
public class ExpertController {
    private final ExpertService expertService;
    @PostMapping("/expert")
    public ResponseEntity<Succes>registerExpert(@RequestBody registroExperto registro){
        return new ResponseEntity<Succes>(expertService.registerExpert(registro), HttpStatus.OK);
    }
}
