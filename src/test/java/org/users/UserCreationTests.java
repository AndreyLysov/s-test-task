package org.users;

import org.api.comparators.EqualityComparer;
import org.api.core.UserApiClient;
import org.api.models.users.PlayerCreateRequestDto;
import org.api.models.users.PlayerCreateResponseDto;
import org.api.models.users.PlayerGetByPlayerIdResponseDto;
import org.core.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.api.models.DataSupplier.getPlayerCreateRequestDto;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserCreationTests extends BaseTest {

    private UserApiClient userApiClient;

    @BeforeClass
    public void beforeClass() {
        userApiClient = new UserApiClient(apiClientManager);
    }

    @Test
    public void testUserCreation() {
        PlayerCreateRequestDto player = getPlayerCreateRequestDto();
        PlayerCreateResponseDto playerCreationResponse = userApiClient.createPlayer(player);

        assertThat("Player response doesn't match player request\n" +
                        "Request: " + player + "\n" +
                        "Response: " + playerCreationResponse,
                EqualityComparer.equals(player, playerCreationResponse));

        PlayerGetByPlayerIdResponseDto playerById = userApiClient.getPlayer(playerCreationResponse.getId());

        assertThat("Player by id response doesn't match player creation response\n" +
                        "Player creation response: " + playerCreationResponse + "\n" +
                        "Player by id response: " + playerById,
                EqualityComparer.equals(playerCreationResponse, playerById));
    }
}
