import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class HappyPathTest {

    @Test
    void shouldSendSimpleSurname() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Николай Гоголь");
        $("span[data-test-id=phone] input").setValue("+79211712862");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("p[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldSendComplexSurname() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Кузьма Петров-Водкин");
        $("span[data-test-id=phone] input").setValue("+79111111111");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("p[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldSendYoName() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Ли Вэй");
        $("span[data-test-id=phone] input").setValue("+71234567890");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("p[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }

    @Test
    void shouldSendLongSurname() {
        open("http://localhost:7777/");
        $("span[data-test-id=name] input").setValue("Дженифер Аийильцикликирмибайрактазийанкаграманоглу");
        $("span[data-test-id=phone] input").setValue("+74444444444");
        $("label[data-test-id=agreement]").click();
        $("button[type=button").click();
        $("p[data-test-id=order-success]").shouldHave(exactText("Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время."));
    }
}
