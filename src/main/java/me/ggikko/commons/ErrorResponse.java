package me.ggikko.commons;

import lombok.Data;

import java.util.List;

/**
 * Created by Park Ji Hong, ggikko.
 */
@Data
public class ErrorResponse {

    private String message;
    private String code;

    private List<ErrorField> errors;

    private static class ErrorField {
        private String value;
        private String field;
        private String reason;

    }

}
