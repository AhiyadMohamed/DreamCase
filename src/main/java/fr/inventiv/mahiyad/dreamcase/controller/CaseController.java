package fr.inventiv.mahiyad.dreamcase.controller;

import fr.inventiv.mahiyad.dreamcase.common.Paths;
import fr.inventiv.mahiyad.dreamcase.data.entities.Case;
import fr.inventiv.mahiyad.dreamcase.exceptions.caseNotFoundException;
import fr.inventiv.mahiyad.dreamcase.service.CaseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(Paths.CASES)
public class CaseController {


    private CaseService caseService;

    public CaseController(CaseService caseService) {
        this.caseService = caseService;
    }


    @GetMapping("{id}")
    public Case getCaseById(@PathVariable Long id) throws caseNotFoundException {
        return caseService.getCaseById(id);
    }

    @GetMapping
    List<Case> findAll(){
     return  caseService.findAll();
    }

    @PostMapping
    public Case save(@RequestBody Case newCase) {
        return this.caseService.saveCase(newCase);
    }

    @PutMapping("/{id}")
    public Case update(@PathVariable Long id,@RequestBody Case updateCase) throws caseNotFoundException {
        return caseService.updateCase(id,updateCase);
    }


    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        caseService.deleteCase(id);
    }


}
