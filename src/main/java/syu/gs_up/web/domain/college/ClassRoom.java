package syu.gs_up.web.domain.college;

import lombok.Getter;
import lombok.NoArgsConstructor;
import syu.gs_up.web.domain.Base;

import javax.persistence.*;
import java.util.LinkedList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class ClassRoom extends Base {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long classRoomId;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String floor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "building_id",nullable = false)
    private Building building;

    @OneToMany(mappedBy = "classRoom",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<Lecture> lectureList = new LinkedList<>();

    //TODO 테스트용 생성자입니다.
    public ClassRoom(String name, String floor, Building building) {
        this.name = name;
        this.floor = floor;
        this.building = building;
    }
}
