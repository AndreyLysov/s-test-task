package org.api.core;

import org.api.models.core.RequestModel;
import org.api.models.users.PlayerCreateRequestDto;
import org.api.models.users.PlayerCreateResponseDto;
import org.api.models.users.PlayerGetAllResponseDto;
import org.api.models.users.PlayerGetByPlayerIdRequestDto;
import org.api.models.users.PlayerGetByPlayerIdResponseDto;

public class UserApiClient extends AbstractApiClient {

    public UserApiClient(ApiClientManager apiClientManager) {
        super(apiClientManager);
    }

    public PlayerCreateResponseDto createPlayer(RequestModel player) {
        return post("player/create", player, PlayerCreateResponseDto.class);
    }

    public PlayerGetByPlayerIdResponseDto getPlayer(Long player) {
        return post("player/get", new PlayerGetByPlayerIdRequestDto(player), PlayerGetByPlayerIdResponseDto.class);
    }

    public PlayerGetAllResponseDto getAllPlayers() {
        return get("player/get/all")
                .as(PlayerGetAllResponseDto.class);
    }
}
