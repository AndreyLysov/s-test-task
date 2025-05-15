package org.api.comparators;

import org.api.models.users.PlayerCreateRequestDto;
import org.api.models.users.PlayerCreateResponseDto;
import org.api.models.users.PlayerGetByPlayerIdResponseDto;

public class EqualityComparer {

    public static boolean equals(PlayerCreateRequestDto request, PlayerCreateResponseDto response) {
        return request.getAge().equals(response.getAge())
                && request.getGender().equals(response.getGender())
                && request.getLogin().equals(response.getLogin())
                && request.getRole().equals(response.getRole())
                && request.getScreenName().equals(response.getScreenName());
    }

    public static boolean equals(PlayerCreateResponseDto response1, PlayerGetByPlayerIdResponseDto response2) {
        return response1.getAge().equals(response2.getAge())
                && response1.getGender().equals(response2.getGender())
                && response1.getId().equals(response2.getId())
                && response1.getLogin().equals(response2.getLogin())
                && response1.getRole().equals(response2.getRole())
                && response1.getScreenName().equals(response2.getScreenName());
    }
}
