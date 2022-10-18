package com.exam.portal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.exam.portal.models.Packages;
import com.exam.portal.models.UserPackages;

public interface UserPackageService {

    void saveUserPackage(UserPackages userPackages);
    List<Packages> getPackage(List<UserPackages> list);

}
