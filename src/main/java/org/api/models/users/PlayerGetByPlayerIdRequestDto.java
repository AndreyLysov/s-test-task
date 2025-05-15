package org.api.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;
import org.api.models.core.RequestModel;

@AllArgsConstructor
@Data
@NoArgsConstructor
@With
public class PlayerGetByPlayerIdRequestDto implements RequestModel {

    private Long id;
}
