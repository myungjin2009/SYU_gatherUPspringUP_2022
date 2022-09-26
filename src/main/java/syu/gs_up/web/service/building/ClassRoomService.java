package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.controller.building.exception.FormException;
import syu.gs_up.web.controller.building.form.ClassRoomForm;
import syu.gs_up.web.domain.college.Building;
import syu.gs_up.web.domain.college.ClassRoom;
import syu.gs_up.web.dto.classRoom.ClassRoomDto;
import syu.gs_up.web.repository.BuildingRepository;
import syu.gs_up.web.repository.classroom.ClassRoomRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ClassRoomService {

    private final ClassRoomRepository classRoomRepository;
    private final BuildingRepository buildingRepository;

    public List<ClassRoomDto> getClassRoomDtoByBId(Long id) {
        List<ClassRoom> classRoomList = classRoomRepository.findByBuildingId(id);
        return classRoomList
                .stream()
                .map(c -> new ClassRoomDto(c.getClassRoomId(),c.getName(),c.getFloor()))
                .collect(Collectors.toList());
    }


    public ClassRoom getClassRoomByName(String name) {
        ClassRoom classRoom = classRoomRepository.getByName(name);
        return classRoom;
    }

    @Transactional
    public void addClassRoom(ClassRoomForm form) {
        Optional<Building> buildingOptional = buildingRepository.findByName(form.getBuilding());
        Building building = buildingOptional.orElseThrow(FormException::new);
        ClassRoom classRoom = new ClassRoom(form.getName(), form.getFloor(), building);
        classRoomRepository.save(classRoom);
    }
}
