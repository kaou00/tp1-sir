package com.example.tp1sir.dao;

import com.example.tp1sir.bean.Livre;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.tags.form.SelectTag;

import java.util.List;

@Repository
public interface LivreDao extends JpaRepository<Livre,Long > {
    Livre findByIsbn(String isbn);
    int deleteByIsbn(String isbn);
    List<Livre> findByStock(double stock);

    @Query("select l from Livre l where l.stock = 0")
     List<Livre> findByStockNonDispo() ;

    @Query("select l from Livre l where l.stock > l.seuilAlert")
    List<Livre> findByLivreNonCritique();
}
