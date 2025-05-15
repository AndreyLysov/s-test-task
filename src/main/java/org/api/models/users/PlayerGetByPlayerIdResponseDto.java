package org.api.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.api.models.core.ResponseModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class PlayerGetByPlayerIdResponseDto implements ResponseModel {

    private Integer age;
    private String gender;
    private Long id;
    private String login;
    private String password;
    private String role;
    private String screenName;
}
