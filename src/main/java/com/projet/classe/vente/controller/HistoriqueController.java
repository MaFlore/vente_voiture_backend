package com.projet.classe.vente.controller;

import com.projet.classe.vente.model.Historique;
import com.projet.classe.vente.service.HistoriqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(name = "/api")
@CrossOrigin(value = "*")
public class HistoriqueController {

    @Autowired
    public HistoriqueService historiqueService;

    @RequestMapping(value = "/historiques", method = RequestMethod.GET)
    public List<Historique> getAllHistoriques() {

        List<Historique> historiques = new ArrayList<>();

        try {
            historiques = this.historiqueService.getAll();
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Erreur " + e.getMessage());
        }

        return historiques;

    }

    @RequestMapping(value = "/historique/{id}", method = RequestMethod.GET)
    public Historique findById(@PathVariable Long id) {

        Historique historique = new Historique();

        try {
            historique = this.historiqueService.findById(id);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return historique;
    }

    @RequestMapping(value = "/historique/ajouter", method = RequestMethod.POST, headers = "accept=Application/json")
    public Historique saveHistorique(@RequestBody Historique historique) {

        try {
            historique = this.historiqueService.save(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return historique;
    }

    @RequestMapping(value = "/historique/modifier/{id}", method = RequestMethod.PUT, headers = "accept=Application/json")
    public Historique updateHistorique(@RequestBody Historique historique) {

        try {
            historique = this.historiqueService.update(historique);
        } catch (Exception e) {
            System.out.println("Erreur " + e.getMessage());
        }

        return historique;

    }

    @RequestMapping(value = "/historique/supprimer/{id}", method = RequestMethod.DELETE, headers = "accept=Application/json")
    public void deleteHistorique(@PathVariable Long id) {
        this.historiqueService.deleteById(id);
    }
}
