import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class ValidationTest {

    @Test
    void shouldErrorWithoutPhone() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Николай Гоголь");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldErrorWithoutName() {
        open("http://localhost:7777/");
        $("span[data-test-id=phone] input").setValue("+79111111111");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Поле обязательно для заполнения"));
    }

    @Test
    void shouldErrorWithIncorrectName() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("%$#");
        $("span[data-test-id=phone] input").setValue("+79111111111");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("[data-test-id='name'].input_invalid .input__sub").shouldHave(exactText("Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы."));
    }

    @Test
    void shouldErrorWithIncorrectPhone() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Николай Гоголь");
        $("span[data-test-id=phone] input").setValue("+7911111111");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("[data-test-id='phone'].input_invalid .input__sub").shouldHave(exactText("Телефон указан неверно. Должно быть 11 цифр, например, +79012345678."));
    }

    @Test
    void shouldErrorWithoutAgreement() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Николай Гоголь");
        $("span[data-test-id=phone] input").setValue("+79111111111");
        $("button[type=button").click();
        $("[data-test-id='agreement'].input_invalid").shouldBe(visible);
    }
}
