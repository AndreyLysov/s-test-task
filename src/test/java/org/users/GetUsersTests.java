package org.users;

import org.api.core.UserApiClient;
import org.api.models.users.PlayerGetAllResponseDto;
import org.core.BaseTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.apache.commons.lang3.StringUtils.isEmpty;
import static org.hamcrest.MatcherAssert.assertThat;

public class GetUsersTests extends BaseTest {

    private UserApiClient userApiClient;

    @BeforeClass
    public void beforeClass() {
        userApiClient = new UserApiClient(apiClientManager);
    }

    @Test
    public void testGetAllUsers() {
        String supervisorRole = "supervisor";
        String adminRole = "admin";

        PlayerGetAllResponseDto players = userApiClient.getAllPlayers();

        assertThat("There is at least one user with empty role",
                players.getPlayers()
                        .stream()
                        .noneMatch(user -> isEmpty(user.getRole())));

//        Verify default users are present (supervisor, admin)
        assertThat("There is no user with role 'supervisor'",
                players.getPlayers()
                        .stream()
                        .anyMatch(user -> user.getRole().equals(supervisorRole)));

        assertThat("There is no user with role 'admin'",
                players.getPlayers()
                        .stream()
                        .anyMatch(user -> user.getRole().equals(adminRole)));
    }
}
