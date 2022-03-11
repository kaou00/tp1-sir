package com.example.tp1sir.dao;

import com.example.tp1sir.bean.Client;
import com.example.tp1sir.bean.Emprunt;
import com.example.tp1sir.bean.Livre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmpruntDao extends JpaRepository<Emprunt,Long> {

    List<Emprunt> findByClient(Client client);
    List<Emprunt> findByLivre(Livre livre);
    int deleteByClient(Client client);
    int deleteByLivre(Livre livre);
    List<Emprunt> findByLivreIsbn(String isbn);
    List<Emprunt> findByClientCin(String cin);


}
