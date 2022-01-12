package lt.codeacademy.api.controller;

import static lt.codeacademy.api.ApiPath.*;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import lt.codeacademy.api.entity.Client;
import lt.codeacademy.api.service.ClientService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(CLIENTS)
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @GetMapping
    public List<Client> getCounterparties() {
        return clientService.getClients();
    }

    @GetMapping(value = CLIENT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Client getClient(@PathVariable(ID_VARIABLE)String id) {
        return clientService.getClient(id);
    }

    @PostMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public void createClient(@RequestBody Client client) {
        clientService.createClient(client);
    }

    @PutMapping(consumes = APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void updateCounterparty(@RequestBody Client client) {
        clientService.updateClient(client);
    }


}
