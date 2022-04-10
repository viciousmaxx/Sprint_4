import io.qameta.allure.Step;

public class Account {

    private final String name;

    public Account(String name) {
        this.name = name;
    }

    //Для шага checkNameToEmboss() используй аннотацию @Step("Проверяем текст для эмбоссирования"). Без аннотации @Step шаг не отобразится в Allure отчете. В скобках указывай описание шага. Это сделает отчет Allure информативнее, что позволит сократить время локализации дефекта.
    @Step("Проверяем текст для эмбоссирования")
    public boolean checkNameToEmboss() {

        try {
            return (name.length() >= 3 && name.length() < 20) && (name.length() - name.replaceAll(" ", "").length() == 1) && (!name.startsWith(" ") && (!name.endsWith(" ")));
        } catch (NullPointerException exception) {
            return false;
        }
    }
}