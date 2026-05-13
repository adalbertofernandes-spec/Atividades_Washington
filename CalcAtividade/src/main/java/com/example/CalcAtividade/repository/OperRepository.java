package com.example.CalcAtividade.repository;

import com.example.CalcAtividade.model.OperacaoModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperRepository extends JpaRepository<OperacaoModel, Long > {


}
