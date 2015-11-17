package me.ggikko.accounts;

import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * Created by Park Ji Hong, ggikko.
 */
public class AccountDto {

    @Data
    public static class Create{
        @NotBlank
        @Size(min = 5)
        private String username;

        @NotBlank
        @Size(min = 5)
        private String password;
    }

    @Data
    public static class Response{
        private Long id;
        private String username;
        private String fullName;
        private Date joined;
        private Date updated;
    }

}
