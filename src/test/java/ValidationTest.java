import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ValidationTest {

    @Test
    void shouldErrorWithoutPhone() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Николай Гоголь");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("div:nth-child(2) > span > span > span.input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldErrorWithoutName() {
        open("http://localhost:7777/");
        $("span[data-test-id=phone] input").setValue("+79111111111");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("div:nth-child(1) > span > span > span.input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldErrorWithIncorrectName() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("%$#");
        $("span[data-test-id=phone] input").setValue("+79111111111");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("div:nth-child(1) > span > span > span.input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldErrorWithIncorrectPhone() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Николай Гоголь");
        $("span[data-test-id=phone] input").setValue("+7911111111");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("div:nth-child(2) > span > span > span.input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldErrorWithoutAgreement() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Николай Гоголь");
        $("span[data-test-id=phone] input").setValue("+79111111111");
        $("button[type=button").click();
        $("div:nth-child(2) > span > span > span.input__sub").shouldHave(exactText("На указанный номер моб. тел. будет отправлен смс-код для подтверждения заявки на карту. Проверьте, что номер ваш и введен корректно."));
    }
}
