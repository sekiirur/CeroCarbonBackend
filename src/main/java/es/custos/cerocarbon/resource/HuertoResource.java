package es.custos.cerocarbon.resource;

import es.custos.cerocarbon.model.Huerto;
import es.custos.cerocarbon.service.DTO.HuertoDTO;
import es.custos.cerocarbon.service.IHuertoService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin

@RestController
@RequestMapping("/api")
public class HuertoResource {

    private IHuertoService huertoService;


    public HuertoResource(IHuertoService huertoService){
        this.huertoService = huertoService;
    }
    @CrossOrigin
    @GetMapping("/huertos")
    public List<HuertoDTO> listaHuertos() {
        List<HuertoDTO> huertos = new ArrayList<HuertoDTO>();
        huertos = huertoService.getAllHuertos();

        return huertos;
    }
    @CrossOrigin
    @PostMapping("/huertos")
    public HuertoDTO crearHuerto(@RequestBody HuertoDTO HuertoDTO){
        return huertoService.save(HuertoDTO);
    }
    
    @CrossOrigin
    @PutMapping("/huertos")
    public HuertoDTO editarHuerto(@RequestBody HuertoDTO HuertoDTO){
        return huertoService.save(HuertoDTO);
    }
    @CrossOrigin
    @GetMapping("/huertos/{id}")
    public HuertoDTO getHuertobyId(@PathVariable Integer id ){
        return huertoService.getHuertobyId(id);
    }
    @CrossOrigin
    @DeleteMapping("/huertos/{id}")
    public void deleteHuerto(@PathVariable Integer id){
        huertoService.delete(id);
    }

}


