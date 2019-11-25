package logic;

public class StatCounter {

    private static Integer authorListProseLength = 40000;
    private static Integer authorListPoemLength = 700;

    private static Integer getCharWithSpaces(String text){
        String textWithoutSpaces = text.replaceAll("[\\n]", "");
        return text.length();
    }

    private static Integer getCharWithoutSpaces(String text){
        String textWithoutSpaces = text.replaceAll("[\\s\\n]", "");
        return textWithoutSpaces.length();
    }

    private static Integer getAuthorListsProse(String text){
        return getCharWithSpaces(text) / authorListProseLength;
    }

    private static Integer getAuthorListsPoem(String text){
        return getPoemLength(text) / authorListPoemLength;
    }

    private static Integer getPoemLength(String text){
        String []lines = text.split("\n");
        return lines.length - 1;
    }

    //TODO: тут криво считает слова, учитывает знаки препинания типа тире - пофиксить
    private static Integer getWords(String text){
        String []words = text.split("[\\s\\n]+");
        return words.length;
    }

    public static String getPoemStat(String text){
        return String.format("Вот что я узнал. В твоем стихе:" +
                "\n- %s символов с пробелами;" +
                "\n- %s символов без пробелов;" +
                "\n- %s слов;" +
                "\n- %s строк;" +
                "\n- %s полных авторских страниц;",
                Integer.toString(getCharWithSpaces(text)),
                Integer.toString(getCharWithoutSpaces(text)),
                Integer.toString(getWords(text)),
                Integer.toString(getPoemLength(text)),
                Integer.toString(getAuthorListsPoem(text))
                );
    }

    public static String getProseStat(String text){
        return String.format("Вот что я узнал. В твоем тексте:" +
                        "\n- %s символов с пробелами;" +
                        "\n- %s символов без пробелов;" +
                        "\n- %s слов;" +
                        "\n- %s полных авторских страниц;",
                Integer.toString(getCharWithSpaces(text)),
                Integer.toString(getCharWithoutSpaces(text)),
                Integer.toString(getWords(text)),
                Integer.toString(getAuthorListsProse(text))
        );
    }
}
