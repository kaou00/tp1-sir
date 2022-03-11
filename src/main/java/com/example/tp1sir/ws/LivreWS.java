package com.example.tp1sir.ws;

import com.example.tp1sir.bean.Livre;
import com.example.tp1sir.service.LivreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/livre")
public class LivreWS {

    @Autowired
    private LivreService livreService;

@PostMapping("/")
    public int sauvgarder( @RequestBody Livre livre) {

        return livreService.sauvgarder( livre);
    }

    @GetMapping("/isbn/{isbn}")
    public Livre findByIsbn( @PathVariable String isbn) {

        return livreService.findByIsbn(isbn);
    }
@Transactional
    @DeleteMapping("/isbn/{isbn}")
    public int deleteByIsbn( @PathVariable String isbn) {

        return livreService.deleteByIsbn(isbn);
    }
@GetMapping("/findByStockNonDispo")
    public List<Livre> findByStockNonDispo() {

        return livreService.findByStockNonDispo();
    }
@GetMapping("/findByLivreNonCritique")
    public List<Livre> findByLivreNonCritique() {

        return livreService.findByLivreNonCritique();
    }
@GetMapping("/stock/{stock}")
    public List<Livre> findByStock(@PathVariable double stock) {
        return livreService.findByStock(stock);
    }

    @GetMapping("/")
    public List<Livre> findAll() {

        return livreService.findAll();
    }
}
