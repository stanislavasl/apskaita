package lt.codeacademy.api.service;

import lt.codeacademy.api.entity.Client;
import lt.codeacademy.api.exception.ClientNotFoundException;
import lt.codeacademy.api.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public void createClient(Client client) {
        clientRepository.save(client);
    }

    public List<Client> getClients() {
        return clientRepository.findAll();
    }

    public Client getClient(String id) {
        return clientRepository.findById(id).orElseThrow(() -> new ClientNotFoundException(id));
    }

    public void updateClient(Client client) {
        clientRepository.save(client);
    }

}
