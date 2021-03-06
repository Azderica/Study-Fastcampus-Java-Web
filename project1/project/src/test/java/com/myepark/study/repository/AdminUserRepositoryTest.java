package com.myepark.study.repository;

import com.myepark.study.StudyApplicationTests;
import com.myepark.study.model.entity.AdminUser;
import com.myepark.study.model.enumclass.AdminUserStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class AdminUserRepositoryTest extends StudyApplicationTests {

    @Autowired
    private AdminUserRepository adminUserRepository;

    @Test
    public void create() {
        AdminUser adminUser = new AdminUser();
        adminUser.setAccount("AdminUser01");
        adminUser.setPassword("AdminUser01");
        adminUser.setStatus(AdminUserStatus.REGISTERED);
        adminUser.setRole("PARTNER");
//        adminUser.setCreatedAt(LocalDateTime.now());
//        adminUser.setCreatedBy("AdminServer");

        AdminUser newAdminUser = adminUserRepository.save(adminUser);
        Assert.assertNotNull(newAdminUser);
    }

}