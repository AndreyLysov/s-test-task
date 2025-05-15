package org.api.models.users;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@With
public class PlayerGetAllResponseDto {

    private List<PlayerItem> players;
}
