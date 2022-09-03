package syu.gs_up;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.domain.college.Building;
import syu.gs_up.web.domain.college.ClassRoom;
import syu.gs_up.web.repository.BuildingRepository;
import syu.gs_up.web.repository.classroom.ClassRoomRepository;

@Profile("secret")
@Component
@RequiredArgsConstructor
public class TestData {

    private final BuildingRepository buildingRepository;
    private final ClassRoomRepository classRoomRepository;

    @EventListener(ApplicationReadyEvent.class)
    @Transactional
    public void buildingInit() {
        Building daniel = new Building("다니엘관", "삼육대학교 중심관", "37.6424", "127.1079");
        buildingRepository.save(daniel);

        for(int i=1;i<=5;i++){
            ClassRoom classRoom = new ClassRoom("10" + i + "호", "1F", daniel);
            classRoomRepository.save(classRoom);
        }

        for(int i=1;i<=3;i++){
            ClassRoom classRoom = new ClassRoom("20" + i + "호", "2F", daniel);
            classRoomRepository.save(classRoom);
        }

        Building samuel = new Building("사무엘관", "영문학과&사회복지학과", "37.6432", "127.1037");
        buildingRepository.save(samuel);
    }
}
