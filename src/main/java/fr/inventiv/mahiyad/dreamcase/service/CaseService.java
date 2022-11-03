package fr.inventiv.mahiyad.dreamcase.service;

import fr.inventiv.mahiyad.dreamcase.data.entities.Case;
import fr.inventiv.mahiyad.dreamcase.exceptions.caseNotFoundException;

import java.util.List;

public interface CaseService {

    Case getCaseById(Long id) throws caseNotFoundException;
    List<Case> findAll();

    Case saveCase(Case newCase);

    void deleteCase(Long id);

    Case updateCase(Long id, Case updateCase) throws caseNotFoundException;
}
