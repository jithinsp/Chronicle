package com.corner.chronicleregister.service;

import com.corner.chronicleregister.dto.CreateFamilyRequest;
import com.corner.chronicleregister.entity.Family;
import com.corner.chronicleregister.repository.FamilyRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FamilyServiceImpl implements FamilyService{
    @Autowired
    FamilyRepository familyRepository;

    public List<Family> getAllFamily() {
        return familyRepository.findAll();
    }

    public Family getFamilyById(Long id) {
        return familyRepository.findById(id).orElseThrow();
    }

    public Family createFamily(CreateFamilyRequest createFamilyRequest) {
        Family family = new Family();
        BeanUtils.copyProperties(createFamilyRequest, family);
        Family createdFamily = familyRepository.save(family);
        family.setId(createdFamily.getId());
        return family;
    }

    public void deleteUserById(Long id) {
        familyRepository.deleteById(id);
    }

    public Family updateFamily(Family existingFamily) {
        return familyRepository.save(existingFamily);
    }
}
