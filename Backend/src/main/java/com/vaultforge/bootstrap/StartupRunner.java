package com.vaultforge.bootstrap;

import com.vaultforge.mongo.ActivityEvent;
import com.vaultforge.mongo.ActivityEventRepository;
import com.vaultforge.sql.AppUserEntity;
import com.vaultforge.sql.AppUserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartupRunner implements CommandLineRunner {

    private final AppUserRepository appUserRepository;
    private final ActivityEventRepository activityEventRepository;

    public StartupRunner(AppUserRepository appUserRepository, ActivityEventRepository activityEventRepository) {
        this.appUserRepository = appUserRepository;
        this.activityEventRepository = activityEventRepository;
    }

    @Override
    public void run(String... args) {
        appUserRepository.findByEmail("admin@vaultforge.local")
                .orElseGet(() -> appUserRepository.save(new AppUserEntity("admin@vaultforge.local")));

        activityEventRepository.save(new ActivityEvent("BOOT", "VaultForge backend started"));
    }
}