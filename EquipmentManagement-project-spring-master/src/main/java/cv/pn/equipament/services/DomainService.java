package cv.pn.equipament.services;


import cv.pn.equipament.dtos.DomainDTO;
import cv.pn.equipament.utilities.APIResponse;

public interface DomainService {
    APIResponse insertDomain(DomainDTO domainDTO);
    APIResponse updateDomain(String id, DomainDTO domainDTO);
    APIResponse getDomain(String id);
    APIResponse getAllDomain(String selfId);
}
