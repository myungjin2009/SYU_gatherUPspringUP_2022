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
public class Building extends Base {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long buildingId;

    @Column(nullable = false,unique = true)
    private String name;

    private String intro;

    @Column(nullable = false)
    private String latitude;

    @Column(nullable = false)
    private String longitude;

    @OneToMany(mappedBy = "building",cascade = CascadeType.ALL,orphanRemoval = true)
    private List<ClassRoom> classRoomList = new LinkedList<>();

    //TODO 테스트 용 생성자입니다.
    public Building(String name, String intro, String latitude, String longitude) {
        this.name = name;
        this.intro = intro;
        this.latitude = latitude;
        this.longitude = longitude;
    }
}
