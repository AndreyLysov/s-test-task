package org.api.models;

import org.api.models.users.PlayerCreateRequestDto;
import org.api.models.users.PlayerItem;

import java.util.concurrent.ThreadLocalRandom;

import static java.lang.String.format;

public class DataSupplier {

    private static final String ROLE_TEMPLATE = "aqa_role_%s";
    private static final String SCREEN_NAME_TEMPLATE = "aqa_screen_name_%s";
    private static final String EDITOR_TEMPLATE = "aqa_editor_%s";
    private static final String DEFAULT_PASSWORD = "Qwe!23123";

    public static PlayerItem getPlayerItem() {
        return new PlayerItem()
                .withAge(getAge())
                .withGender(getGender())
                .withRole(getRole())
                .withScreenName(getScreenName());
    }

    public static PlayerCreateRequestDto getPlayerCreateRequestDto() {
        return new PlayerCreateRequestDto()
                .withAge(getAge())
                .withGender(getGender())
                .withRole(getRole())
                .withScreenName(getScreenName())
                .withEditor(getEditor())
                .withLogin(getScreenName())
                .withPassword(DEFAULT_PASSWORD);
    }

//    To get default valid editor
    public static String getEditor() {
        return format(EDITOR_TEMPLATE, ThreadLocalRandom.current().nextInt());
    }

//    To get default valid screen name
    public static String getScreenName() {
        return format(SCREEN_NAME_TEMPLATE, ThreadLocalRandom.current().nextInt());
    }

//    To get default valid role
    public static String getRole() {
        return format(ROLE_TEMPLATE, ThreadLocalRandom.current().nextInt());
    }

//    To get default valid gender
    private static String getGender() {
        return ThreadLocalRandom.current().nextBoolean() ? "male" : "female";
    }

//    To get default valid age
    private static int getAge() {
        return ThreadLocalRandom.current().nextInt(18, 101);
    }
}
