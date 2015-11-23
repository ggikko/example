package me.ggikko.accounts;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Park Ji Hong, ggikko.
 */
@Entity
@Getter
@Setter
public class Account {

    @Id @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    private String email;

    private String fullName;

    @Temporal(TemporalType.DATE)
    private Date joined;

    @Temporal(TemporalType.DATE)
    private Date updated;

}
