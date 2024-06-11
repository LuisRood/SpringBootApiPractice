package com.apirest.ApiRest.Controllers;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
public class ItemController {
    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<Item> getItems(@RequestParam(required = false) String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return itemRepository.findAll();
        }
        return itemRepository.findByNombreContaining(nombre);
    }

    @GetMapping("/pokemon/{name}")
    public ResponseEntity<String> getPokemon(@PathVariable String name) {
        return ResponseEntity.ok(pokemonService.getPokemon(name));
    }

    @PostMapping("/encrypt")
    public ResponseEntity<String> encrypt(@RequestBody String data) {
        return ResponseEntity.ok(encryptionService.encrypt(data));
    }


}
