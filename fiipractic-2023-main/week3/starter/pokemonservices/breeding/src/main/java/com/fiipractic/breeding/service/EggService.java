package com.fiipractic.breeding.service;

import com.fiipractic.breeding.model.Egg;
import com.fiipractic.breeding.model.EggStatus;
import com.fiipractic.breeding.repository.EggRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EggService {
    private final EggRepository eggRepository;

    public EggService(EggRepository eggRepository) {
        this.eggRepository = eggRepository;
    }

    @Scheduled(fixedDelay = 1000)
    public void scanEggs(){
        System.out.println("Scanam ouale");
        List<Egg> pendingEggs = eggRepository.findByStatus(EggStatus.PENDING);
        for (Egg pengingEgg: pendingEggs){
            if(pengingEgg.getHatchTime().isBefore(LocalDateTime.now())){
                pengingEgg.setStatus(EggStatus.HATCHED);
                eggRepository.save(pengingEgg);
                System.out.println("\uD83E\uDD5A\uD83E\uDD5A\uD83E\uDD5A S-a ouat \uD83E\uDD5A\uD83E\uDD5A\uD83E\uDD5A");
            }
        }
    }

}
