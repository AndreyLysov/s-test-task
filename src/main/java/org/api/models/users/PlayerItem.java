package org.api.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.api.models.core.RequestModel;

@Data
@AllArgsConstructor
@NoArgsConstructor
@With
public class PlayerItem {

    private Integer age;
    private String gender;
    private Long id;
    private String role;
    private String screenName;
}
