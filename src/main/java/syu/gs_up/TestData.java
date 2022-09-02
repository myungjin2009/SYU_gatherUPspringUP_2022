package syu.gs_up;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.Building;
import syu.gs_up.web.repository.BuildingRepository;

@Component
@RequiredArgsConstructor
public class TestData {

    private final BuildingRepository buildingRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void buildingInit() {
        Building daniel = new Building("다니엘관", "삼육대학교 중심관", "37.6424", "127.1079");
        buildingRepository.save(daniel);

        Building samuel = new Building("사무엘관", "영문학과&사회복지학과", "37.6432", "127.1037");
        buildingRepository.save(samuel);
    }
}
