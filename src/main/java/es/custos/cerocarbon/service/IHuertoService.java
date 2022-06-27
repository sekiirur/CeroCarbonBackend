package es.custos.cerocarbon.service;

import es.custos.cerocarbon.model.Huerto;
import es.custos.cerocarbon.service.DTO.HuertoDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import java.util.List;

@Service
public interface IHuertoService {
    public List<HuertoDTO> getAllHuertos();

    public HuertoDTO save(HuertoDTO huertoDTO);
    public HuertoDTO getHuertobyId(Integer id);
    public boolean delete(Integer id);

    public Page<HuertoDTO> huertoPaginado(Pageable pageable);

    public HuertoDTO alquilar(Integer id);
}
