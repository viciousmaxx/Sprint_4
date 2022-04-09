import io.qameta.allure.Description;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Test;

public class AccountTest {

    @Description ("Корректный сценарий: имя = 5 букв, пробел, фамилия = 7 букв")
    @Test
    public void validNameReturnTrueTest() {
        String name = RandomStringUtils.randomAlphabetic(5) + " " + RandomStringUtils.randomAlphabetic(7);
        Account account = new Account(name);
        Assert.assertTrue(account.checkNameToEmboss());
    }

    @Description ("Некорректный сценарий: длина менее 3 символов (1 буква + пробел)")
    @Test
    public void shortNameReturnFalseTest() {
        String name = RandomStringUtils.randomAlphabetic(1) + " ";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Description ("Некорректный сценарий: отсутствует пробел в середине")
    @Test
    public void nameWithoutSpaceBarReturnFalseTest() {
        String name = RandomStringUtils.randomAlphabetic(17);
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Description ("Некорректный сценарий: длина более 19 символов")
    @Test
    public void longNameReturnFalseTest() {
        String name = RandomStringUtils.randomAlphabetic(10) + " " + RandomStringUtils.randomAlphabetic(9);
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Description ("Некорректный сценарий: пробел в начале строки")
    @Test
    public void nameStartFromSpaceBarReturnFalseTest() {
        String name = " " + RandomStringUtils.randomAlphabetic(5) + " " + RandomStringUtils.randomAlphabetic(5);
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Description ("Некорректный сценарий: пробел в конце строки")
    @Test
    public void nameEndWithSpaceBarReturnFalseTest() {
        String name = RandomStringUtils.randomAlphabetic(5) + " " + RandomStringUtils.randomAlphabetic(5) + " ";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Description ("Некорректный сценарий: пробел в начале и конце строки")
    @Test
    public void nameStartAndEndWithSpaceBarReturnFalseTest() {
        String name = " " + RandomStringUtils.randomAlphabetic(5) + " " + RandomStringUtils.randomAlphabetic(5) + " ";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Description ("Некорректный сценарий: 2 пробела в середине строки")
    @Test
    public void nameWithTwoSpaceBarInMiddleReturnFalseTest() {
        String name = RandomStringUtils.randomAlphabetic(5) + " " + RandomStringUtils.randomAlphabetic(5) + " " + RandomStringUtils.randomAlphabetic(5);
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }

    @Description ("Некорректный сценарий: Пробел в начале и конце строки, без пробела в середине строки")
    @Test
    public void nameStartAndEndWithSpaceBarWithoutSpaceBarInMiddleReturnFalseTest() {
        String name = " " + RandomStringUtils.randomAlphabetic(5) + " ";
        Account account = new Account(name);
        Assert.assertFalse(account.checkNameToEmboss());
    }
}
