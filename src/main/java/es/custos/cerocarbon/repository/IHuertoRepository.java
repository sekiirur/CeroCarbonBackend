package es.custos.cerocarbon.repository;


import es.custos.cerocarbon.model.Huerto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@SuppressWarnings("unused")
@Repository
public interface IHuertoRepository extends JpaRepository<Huerto, Integer> {
}
