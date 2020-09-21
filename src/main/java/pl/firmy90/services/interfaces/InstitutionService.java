package pl.firmy90.services.interfaces;

import pl.firmy90.dtos.InstitutionDTO;

import java.util.List;

public interface InstitutionService {
    List<InstitutionDTO> showInstitutions();
    InstitutionDTO findById(Long id);
    void saveInstitution(InstitutionDTO institutionDTO);
    boolean updateInstitution(Long id,InstitutionDTO institutionDTO);
    boolean deleteInstitution(Long id);
    boolean archiveInstitution(Long id);
}
