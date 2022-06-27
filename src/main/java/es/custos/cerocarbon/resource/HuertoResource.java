package es.custos.cerocarbon.resource;

import es.custos.cerocarbon.service.DTO.HuertoDTO;
import es.custos.cerocarbon.service.IHuertoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
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
    @GetMapping("/huertos-paginados")
    public Page<HuertoDTO> huertosPaginados(Pageable pageable){
        return huertoService.huertoPaginado(pageable);
    }

    @CrossOrigin
    @PostMapping("/huertos")
    public ResponseEntity<?> crearHuerto(@RequestBody HuertoDTO HuertoDTO){

        if(HuertoDTO.getNombre()=="" || HuertoDTO.getNombre() == null){
            return ResponseEntity.badRequest().body("El nombre no puede estar vacío");
        }else{
            huertoService.save(HuertoDTO);
            return ResponseEntity.ok().body("El huerto se ha guardado corretamente");
        }
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
    public ResponseEntity<?> deleteHuerto(@PathVariable Integer id){

        if(huertoService.delete(id)){
            return ResponseEntity.ok().body("");
        }else{
            return ResponseEntity.badRequest().body("El ID no existe");
        }
    }

}


