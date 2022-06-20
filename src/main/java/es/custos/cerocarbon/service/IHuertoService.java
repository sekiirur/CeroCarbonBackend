package es.custos.cerocarbon.service;

import es.custos.cerocarbon.model.Huerto;
import es.custos.cerocarbon.service.DTO.HuertoDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IHuertoService {
    public List<HuertoDTO> getAllHuertos();

    public HuertoDTO save(HuertoDTO huertoDTO);
    public HuertoDTO getHuertobyId(Integer id);
    public void delete(Integer id);
}
