package com.example.tp1sir.service;

import com.example.tp1sir.bean.Client;
import com.example.tp1sir.bean.Emprunt;
import com.example.tp1sir.bean.Livre;
import com.example.tp1sir.dao.ClientDao;
import com.example.tp1sir.dao.EmpruntDao;
import com.example.tp1sir.dao.LivreDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmpruntService {

    public int save( Emprunt emprunt){
        if(findByLivreIsbn(emprunt.getLivre().getIsbn()) == null)
            return -1;
        else if(findByClientCin(emprunt.getClient().getCin()) == null)
            return -2;
        else{
            Client c = clientService.findByCin(emprunt.getClient().getCin());
            Livre l = livreService.findByIsbn(emprunt.getLivre().getIsbn());
            if(l.getStock() == 0)
                return -3;
            else if(c.getPoint() <= 7)
                return -4;
            else{
                emprunt.setEtat("enCours");
                l.setStock(l.getStock() - emprunt.getNombreExemplaire());
                livreService.sauvgarder(l);
                emprunt.setClient(c);
                emprunt.setLivre(l);
                empruntDao.save(emprunt);
                return 1;
            }
        }


    }

    public List<Emprunt> findByLivreIsbn(String isbn) {
        return empruntDao.findByLivreIsbn(isbn);
    }

    public List<Emprunt> findByClientCin(String cin) {
        return empruntDao.findByClientCin(cin);
    }

    public List<Emprunt> findByClient(Client client) {
        return empruntDao.findByClient(client);
    }

    public List<Emprunt> findByLivre(Livre livre) {
        return empruntDao.findByLivre(livre);
    }
@Transactional
    public int deleteByClient(Client client) {
        return empruntDao.deleteByClient(client);
    }
@Transactional
    public int deleteByLivre(Livre livre) {
        return empruntDao.deleteByLivre(livre);
    }

    public List<Emprunt> findAll() {
        return empruntDao.findAll();
    }

    @Autowired
     ClientService clientService;
    @Autowired
    LivreService livreService;

    @Autowired
    private EmpruntDao empruntDao;
}
