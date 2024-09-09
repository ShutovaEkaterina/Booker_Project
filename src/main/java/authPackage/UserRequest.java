package authPackage;

import configPackage.Config;
import io.restassured.response.ValidatableResponse;

public class UserRequest extends Config {

    // todo зачем нужен static? повторить модификаторы доступа
    // todo что такое хороший тест (автотест)?
    // todo каким должен быть метод/функция в классе?
    // todo оставить один метод
    // todo научиться смотреть туду у идее
    private static final String USER_PATH = "/auth";
    public ValidatableResponse authUser(User user) {
        return spec()
                .body(user)
                .when()
                .post(USER_PATH)
                .then().log().all();
    }
    //todo отступы между методами
}
