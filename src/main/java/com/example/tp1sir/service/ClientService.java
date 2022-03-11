package com.example.tp1sir.service;

import com.example.tp1sir.bean.Client;
import com.example.tp1sir.dao.ClientDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ClientService {

    public List<Client> findByFiable() {
        return clientDao.findByFiable();
    }

    public  Client save(Client client) {
        return clientDao.save(client);
    }

    public Client findByCin(String cin) {
        return clientDao.findByCin(cin);
    }

@Transactional
    public int deleteByCin(String cin) {
        return clientDao.deleteByCin(cin);
    }

    @Autowired
    private ClientDao clientDao;
}
