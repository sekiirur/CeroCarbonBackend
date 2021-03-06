package es.custos.cerocarbon.service.impl;

import es.custos.cerocarbon.model.Huerto;
import es.custos.cerocarbon.service.DTO.HuertoDTO;
import es.custos.cerocarbon.service.IHuertoService;
import es.custos.cerocarbon.service.Mapper.ModelMapperUtils;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import es.custos.cerocarbon.repository.IHuertoRepository;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;
import java.io.FileWriter;
import java.util.Optional;

@CrossOrigin

@Service
public class HuertoService implements IHuertoService {

    private IHuertoRepository iHuertoRepository;

    public HuertoService(IHuertoRepository huertoRepository){
        this.iHuertoRepository = huertoRepository;
    }
    @Override
    public List<HuertoDTO> getAllHuertos() {
        //List<Huerto> huertos = init();
        List<Huerto> huertos = iHuertoRepository.findAll();
        return ModelMapperUtils.mapAll(huertos, HuertoDTO.class);
    }

    @Override
    public HuertoDTO save (HuertoDTO huertoDTO){
            Huerto huertoEntidad = ModelMapperUtils.map(huertoDTO, Huerto.class);
            iHuertoRepository.save(huertoEntidad);
            return ModelMapperUtils.map(huertoEntidad, HuertoDTO.class);
    }

    @Override
    public HuertoDTO alquilar(Integer id) {
        Huerto huertoAlquiler = ModelMapperUtils.map(getHuertobyId(id),Huerto.class);

        return null;
    }

    @Override
    public HuertoDTO getHuertobyId(Integer id) {
        Optional<Huerto> huertoOptional = iHuertoRepository.findById(id);
        if(huertoOptional.isPresent()){
            return ModelMapperUtils.map(huertoOptional.get(),HuertoDTO.class);
        }else{
            return null;
        }

    }

    @Override
    public boolean delete(Integer id) {
        Optional<Huerto> huerto = iHuertoRepository.findById(id);
        if(huerto.isPresent()) {
            iHuertoRepository.delete(huerto.get());
            return true;
        }else{
            return false;
        }
    }

    @Override
    public Page<HuertoDTO> huertoPaginado(Pageable pageable) {
        Page<Huerto> paginaHuertos = iHuertoRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        Page<HuertoDTO> paginaHuertoDTO = paginaHuertos.map(huerto -> ModelMapperUtils.map(huerto,HuertoDTO.class));

        return paginaHuertoDTO;
    }




}
