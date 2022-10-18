package com.exam.portal.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exam.portal.models.Packages;
import com.exam.portal.models.UserPackages;
import com.exam.portal.repo.UserPackageRepository;
import com.exam.portal.service.UserPackageService;


@Service
public class UserPackageServiceimpl  implements UserPackageService{

    @Autowired
    private UserPackageRepository userPackageRepository;

    @Override
    public void saveUserPackage(UserPackages userPackages) {
        // TODO Auto-generated method stub
        userPackageRepository.save(userPackages);
    }

    @Override
    public List<Packages> getPackage(List<UserPackages> list) {
        List<Packages> pack = new ArrayList<>();
        for (UserPackages userPackages : list) {
            pack.add(userPackages.getPackages());
        }
        return pack;
    }

    
}
