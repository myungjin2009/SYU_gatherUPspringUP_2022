package syu.gs_up.web.domain.college;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
public class EmailAuth {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long authId;
    @Column
    private String authEmail;
    @Column
    private Integer authNumber;

    public EmailAuth(String authEmail, Integer authNumber) {
        this.authEmail = authEmail;
        this.authNumber = authNumber;
    }
}
