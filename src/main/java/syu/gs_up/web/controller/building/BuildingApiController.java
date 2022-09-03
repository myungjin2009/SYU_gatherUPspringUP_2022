package syu.gs_up.web.controller.building;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import syu.gs_up.web.controller.building.exception.FormException;
import syu.gs_up.web.controller.building.form.ClassRoomForm;
import syu.gs_up.web.controller.building.form.LectureForm;
import syu.gs_up.web.controller.building.response.PostResponse;
import syu.gs_up.web.service.building.ClassRoomService;
import syu.gs_up.web.service.building.LectureService;

import java.util.HashMap;

@RestController
@RequiredArgsConstructor
@Slf4j
public class BuildingApiController {

    private final ClassRoomService classRoomService;
    private final LectureService lectureService;

    private void commonPostException(FieldError fieldError) {
        HashMap<String, String> map = new HashMap<>();
        map.put(fieldError.getField(), fieldError.getDefaultMessage());
        throw new FormException(map);
    }

    //TODO 인증필요
    @PostMapping("/classRoom/add")
    public ResponseEntity<PostResponse> addClassRoom(@Validated @RequestBody ClassRoomForm form,
                                                     BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            commonPostException(bindingResult.getFieldError());
        }
        try {
            classRoomService.addClassRoom(form);
        }catch(FormException e){
            log.info("존재하지 않는 건물명 기입");
            PostResponse notFoundBuilding = new PostResponse(HttpStatus.BAD_REQUEST, "존재하지 않는 건물입니다.", HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(notFoundBuilding,notFoundBuilding.getHttpStatus());
        }

        PostResponse response = new PostResponse(HttpStatus.OK, "등록되었습니다.", HttpStatus.OK.value());
        return new ResponseEntity<>(response,response.getHttpStatus());
    }

    //TODO 인증필요
    @PostMapping("/classRoom/{id}/addLecture")
    public ResponseEntity<PostResponse> addLectures(@PathVariable("id") Long id,
                                                    @Validated @RequestBody LectureForm form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            commonPostException(bindingResult.getFieldError());
        }
        try {
            lectureService.addLecture(id, form);
        }catch(Exception e){
            log.info("존재하지 않는 강의실에 수업 추가 시도");
            PostResponse notFoundBuilding = new PostResponse(HttpStatus.BAD_REQUEST, "존재하지 않는 강의실입니다.", HttpStatus.BAD_REQUEST.value());
            return new ResponseEntity<>(notFoundBuilding,notFoundBuilding.getHttpStatus());
        }
        PostResponse response = new PostResponse(HttpStatus.OK, "등록되었습니다.", HttpStatus.OK.value());
        return new ResponseEntity<>(response,response.getHttpStatus());
    }
}
