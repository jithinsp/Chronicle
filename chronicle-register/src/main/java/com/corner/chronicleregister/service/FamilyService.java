package com.corner.chronicleregister.service;

import com.corner.chronicleregister.dto.CreateFamilyRequest;
import com.corner.chronicleregister.entity.Family;

import java.util.List;

public interface FamilyService {
    List<Family> getAllFamily();

    Family getFamilyById(Long id);

    Family createFamily(CreateFamilyRequest createFamilyRequest);

    void deleteUserById(Long id);

    Family updateFamily(Family existingFamily);
}
