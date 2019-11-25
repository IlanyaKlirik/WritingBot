package logic.handlers;

//TODO: фразы
public class PhrasesHandler{

    public static String getStartPhrase() {
        return "Привет, писатель! Я твой верный помощник. Если хочешь узнать, что я умею, скажи: " + getHelpCommand();
    }

    public static String getEndPhrase() {
        return "Спасибо, что заглянул. Если нужна будет какая-то помощь, смело пиши: " + getStartCommand();
    }

    public static String getStartCommand() {
        return "/start";
    }

    public static String getHelpCommand() {
        return "/help";
    }

    public static String getExitCommand() {
        return "Выход";
    }

    public static String getStatCommand() {
        return "Статистика";
    }

    public static String getPoemCommand() {
        return "Стих";
    }

    public static String getProseCommand() { return "Проза"; }

    public static String getDictCommand() {
        return "Словарь";
    }

    public static String getEndDialogCommand() {
        return "/exit";
    }

    public static String getStartStatPhrase() {
        return "Cкажи мне, что ты собираешься проверить: " + getPoemCommand() + " или " + getProseCommand() +
                "\nСкажи: " + getHelpCommand() + ", если возникнут трудности.";
    }

    public static String getStartPoemPhrase() {
        return "Хорошо! Отправь мне свой стих, и я его проверю. Соблюдай переносы строк. Если есть вопросы, скажи: " + getHelpCommand();
    }

    public static String getStartProsePhrase() {
        return "Хорошо! Отправь мне свой текст, и я его проверю. Если есть вопросы, скажи: " + getHelpCommand();
    }

    public static String getEndStatPhrase() {
        return "Больше нет текстов на проверку? Хорошо.";
    }

    public static String getEndProsePoemPhrase() {
        return "Скажи еще раз, что ты хочешь проверить: " + getPoemCommand() + " или " + getProseCommand() +
                "\nСкажи: " + getHelpCommand() + ", если возникнут трудности. Если тебе больше не нужно проверять тексты, скажи: " + getExitCommand();
    }

    public static String getEndCountPhrase() {
        return "Жду от тебя следующего текста. Если хочешь изменить тип своего текста, скажи: " + getExitCommand();
    }

    public static String getStartDictPhrase() {
        return "Я побуду твоим справочником. Задавай мне свои вопросы. Если что-то непонятно, скажи: " + getHelpCommand();
    }

    public static String getEndDictPhrase() {
        return "Хорошо, больше я не твой справочник :)";
    }

    public static String getStartHelp() {
        return "Я могу тебе помочь, но только если ты скажешь: " + getStartCommand();
    }

    public static String getDialogHelp() {
        return String.format("%s - вызвать справку\n%s - выйти из чата\n%s - проверить свой текст\n%s - обратиться к справочнику русского языка\n%s - выйти из чата в любой момент",
                getHelpCommand(), getExitCommand(), getStatCommand(), getDictCommand(), getEndDialogCommand());
    }

    public static String getStatHelp() {
        return "Что-то не выходит? Для начала определись с типом текста, иначе я не смогу правильно посчитать количество авторских страниц. " +
                "Для выбора напиши: \"" + getPoemCommand() + "\" или \"" + getProseCommand();
    }

    public static String getProseHelp(){
        return "Хорошо, с радостью объясню. Здесь ты можешь проверить свой текст. Ты узнаешь:" +
                "\n- количество знаков с пробелами и без, количество слов, количество авторских страниц;" +
                "\n- допущенные ошибки. Я не всезнающий, но что-то подсказать смогу :)" +
                "\nЧтобы получить такую подробную статистику, просто отправь свой текст без каких-либо специальных пометок." +
                "Если больше не хочешь проверять свои тексты, скажи: " + getExitCommand();
    }

    public static String getPoemHelp(){
        return "Хорошо, с радостью объясню. Здесь ты можешь проверить свой стих. Ты узнаешь:" +
                "\n- количество знаков с пробелами и без, количество слов, строк и количество авторских страниц;" +
                "\n- допущенные ошибки. Я не всезнающий, но что-то подсказать смогу :)" +
                "\nЧтобы получить такую подробную статистику, просто отправь свой текст без каких-либо специальных пометок." +
                "Если больше не хочешь проверять свои тексты, скажи: " + getExitCommand();
    }

    public static String getDictHelp(){
        return "Конечно, мне не сложно объяснить. Представь, что я - справочник навроде \"Грамоты.ру\". А теперь задавай свой вопрос" +
                "\nЕсли тебе надоест проверять свои знания, просто скажи: " + getExitCommand();
    }

    public static String getUnknownPhrase() {
        return "Прости, я тебя совсем не понимаю... Скажи \"" + getHelpCommand() + "\", и я объясню тебе, что делать.";
    }
}