package task1.log;

public interface Logger {
    String  currentTime();

    void printInfo(String value);

    void printError(String value);

    void print(String[] values);

    // 数据库操作 打印
    void printInfoDB(String value);

    // 数据库操作 打印
    void printErrorDB(String value);

    void printInfo(String[] values);

    // 错误打印
    void printError(String[] values);
}