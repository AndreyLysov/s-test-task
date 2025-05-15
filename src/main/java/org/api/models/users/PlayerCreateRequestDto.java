package org.api.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.api.models.core.RequestModel;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class PlayerCreateRequestDto implements RequestModel {

    private Integer age;
    private String editor;
    private String gender;
    private Long id;
    private String login;
    private String password;
    private String role;
    private String screenName;
}
