package com.example.tp1sir.ws;

import com.example.tp1sir.bean.Client;
import com.example.tp1sir.service.ClientService;
import com.example.tp1sir.service.EmpruntService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientWS {

@GetMapping("/findByFiable/{findByFiable}")
    public List<Client> findByFiable() {
        return clientService.findByFiable();
    }
@PostMapping("/")
    public Client save( @RequestBody Client client) {
        return clientService.save(client);
    }
@GetMapping("/cin/{cin}")
    public Client findByCin(@PathVariable String cin) {
        return clientService.findByCin(cin);
    }

@Transactional
@DeleteMapping("cin/{cin}")
    public int deleteByCin(@PathVariable String cin) {
        return clientService.deleteByCin(cin);
    }

    @Autowired
private ClientService clientService;

}
