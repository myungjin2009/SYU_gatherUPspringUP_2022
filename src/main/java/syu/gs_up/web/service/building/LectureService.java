package syu.gs_up.web.service.building;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import syu.gs_up.web.controller.building.form.LectureForm;
import syu.gs_up.web.domain.college.ClassRoom;
import syu.gs_up.web.domain.college.Lecture;
import syu.gs_up.web.dto.lectures.LectureDto;
import syu.gs_up.web.repository.classroom.ClassRoomRepository;
import syu.gs_up.web.repository.lecture.LectureRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class LectureService {

    private final LectureRepository lectureRepository;
    private final ClassRoomRepository classRoomRepository;

    @Transactional
    public void addLecture(Long id, LectureForm form) {
        Optional<ClassRoom> roomOptional = classRoomRepository.findById(id);
        ClassRoom classRoom = roomOptional.orElseThrow();

        Lecture lecture = new Lecture(
                form.getStartTime(), form.getEndTime(), form.getProfessor(),
                form.getLectureName(), form.getLectureDay(), classRoom);
        lectureRepository.save(lecture);
    }

    public List<LectureDto> getLectureDtosById(Long id) {
        List<Lecture> lectures = lectureRepository.findLecturesByCId(id);
        return lectures
                .stream()
                .map(l -> new LectureDto(l.getLectureName(),l.getProfessor(),l.getLectureDay(),l.getStartTime(),l.getEndTime()))
                .collect(Collectors.toList());
    }
}
