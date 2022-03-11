package com.example.tp1sir.ws;

import com.example.tp1sir.bean.Client;
import com.example.tp1sir.bean.Emprunt;
import com.example.tp1sir.bean.Livre;
import com.example.tp1sir.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/emprunt")
public class EmpruntWS {
@PostMapping("/")
    public int save(@RequestBody Emprunt emprunt) {
        return empruntService.save(emprunt);
    }
@GetMapping("/isbn/{isbn}")
    public List<Emprunt> findByLivreIsbn(@PathVariable String isbn) {
        return empruntService.findByLivreIsbn(isbn);
    }
@GetMapping("/cin/{cin}")
    public List<Emprunt> findByClientCin(@PathVariable String cin) {
        return empruntService.findByClientCin(cin);
    }
@GetMapping("/client")
    public List<Emprunt> findByClient(@RequestBody Client client) {
        return empruntService.findByClient(client);
    }
@GetMapping("/livre")
    public List<Emprunt> findByLivre(@RequestBody Livre livre) {
        return empruntService.findByLivre(livre);
    }

    @Transactional
    @DeleteMapping("/client")
    public int deleteByClient(@RequestBody Client client) {
        return empruntService.deleteByClient(client);
    }

    @Transactional
    @DeleteMapping("/livre")
    public int deleteByLivre(@RequestBody Livre livre) {
        return empruntService.deleteByLivre(livre);
    }
@GetMapping("/")
    public List<Emprunt> findAll() {
        return empruntService.findAll();
    }

    @Autowired
    private EmpruntService empruntService;
}
