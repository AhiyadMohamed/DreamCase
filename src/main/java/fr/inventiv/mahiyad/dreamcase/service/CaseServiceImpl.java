package fr.inventiv.mahiyad.dreamcase.service;

import fr.inventiv.mahiyad.dreamcase.data.entities.Case;
import fr.inventiv.mahiyad.dreamcase.data.repositories.CaseRepository;
import fr.inventiv.mahiyad.dreamcase.exceptions.caseNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CaseServiceImpl implements CaseService{

    private CaseRepository caseRepository;

    public CaseServiceImpl(CaseRepository caseRepository) {
        this.caseRepository = caseRepository;
    }

    @Override
    public Case getCaseById(Long id) throws caseNotFoundException {
        Case case1 = caseRepository.findById(id)
                .orElseThrow(()->new caseNotFoundException("Case id not found"));
        return case1;
    }

    @Override
    public List<Case> findAll() {
        log.info("List Case");
        return caseRepository.findAll();
    }

    @Override
    public Case saveCase(Case newCase) {
        log.info("New Case");
        Case newCases = new Case();
        newCases.setTitle(newCase.getTitle());
        newCases.setDescription(newCase.getDescription());
        newCase.setCreationDate(new Date());
        return caseRepository.save(newCase);
    }

    @Override
    public void deleteCase(Long id) {
        log.info("Delete Case");
        caseRepository.deleteById(id);
    }

    @Override
    public Case updateCase(Long id, Case updateCase) throws caseNotFoundException {
        Case case1 =caseRepository.findById(id).orElseThrow(
                () -> new caseNotFoundException("Case id not found"));

        if (updateCase.getCreationDate() != null){
            case1.setCreationDate(updateCase.getCreationDate());
        }

        if (updateCase.getTitle() != null){
            case1.setTitle(updateCase.getTitle());
        }
        if (updateCase.getDescription() != null){
            case1.setDescription(updateCase.getDescription());
        }

        case1.setLastUpdateDate(new Date());

        return caseRepository.save(case1);
    }

}
