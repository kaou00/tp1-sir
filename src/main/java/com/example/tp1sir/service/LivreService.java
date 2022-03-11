package com.example.tp1sir.service;

import com.example.tp1sir.bean.Livre;
import com.example.tp1sir.dao.LivreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LivreService {

public int sauvgarder(Livre livre){
    if(livre.getIsbn() == null ){
        return -1;
    }
   else if(findByIsbn(livre.getIsbn()) != null)
        return -2;
    else{
        livreDao.save(livre);
        return 1;
    }
}

    public List<Livre> findByStock(double stock) {
        return livreDao.findByStock(stock);
    }

    public Livre findByIsbn(String isbn) {
        return livreDao.findByIsbn(isbn);
    }
@Transactional
    public int deleteByIsbn(String isbn) {
        return livreDao.deleteByIsbn(isbn);
    }

    public List<Livre> findByStockNonDispo() {
        return livreDao.findByStockNonDispo();
    }

    public List<Livre> findByLivreNonCritique() {
        return livreDao.findByLivreNonCritique();
    }

    public List<Livre> findAll() {
        return livreDao.findAll();
    }

    @Autowired
   private LivreDao livreDao ;
}
