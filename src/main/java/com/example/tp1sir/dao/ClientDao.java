package com.example.tp1sir.dao;

import com.example.tp1sir.bean.Client;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ClientDao extends JpaRepository<Client, Long> {
    Client findByCin(String cin);

    int deleteByCin(String cin);


    @Query("select c from Client c where c.point >= 7")
    List<Client> findByFiable();
}
