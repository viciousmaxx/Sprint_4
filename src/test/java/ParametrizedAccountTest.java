import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//Тесты лучше сделать параметризованными.
@RunWith(Parameterized.class)
public class ParametrizedAccountTest {

    private final String name;
    private final boolean expected;

    public ParametrizedAccountTest(String name, boolean expected) {
        this.name = name;
        this.expected = expected;
    }

    //В параметризованных тестах для аннотации @Parameterized.Parameters лучше использовать аргумент name: @Parameterized.Parameters(name = "Тестовые данные: {0} {1}"), где {0}, {1} - индексы параметров. Это повысит информативность проверки.
    @Parameterized.Parameters(name = "Проверяемое имя: {0}, Ожидаемый результат: {1}")
    public static Object[][] checkName() {
        return new Object[][]{
                //Добавь позитивные проверки на граничные значения (3 и 19 символов)
                {RandomStringUtils.randomAlphabetic(1) + " " + RandomStringUtils.randomAlphabetic(1), true},
                {RandomStringUtils.randomAlphabetic(9) + " " + RandomStringUtils.randomAlphabetic(9), true},

                //Добавь негативные проверки на null и пустую строку.
                {"", false},
                {null, false},
        };
    }

    //При реализации тестов используй аннотацию @DisplayName("Проверка возможности эмбоссирования"). В скобках указывай название теста. Это сделает отчет Allure информативнее, что позволит сократить время локализации дефекта.
    @DisplayName("Проверка возможности эмбоссирования")
    @Test
    public void checkNameParametrizedTest() {
        Account account = new Account(name);
        boolean actual = account.checkNameToEmboss();
        Assert.assertEquals(expected, actual);
    }
}

