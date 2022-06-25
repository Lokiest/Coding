//lineReadTemplate()을 사용하도록 수정한 Sum, Multiply()
public Integer calcSum(String filepath) throws IOException {
        LineCallback sumCallback
          = new LineCallback() {
            public Integer doSomethingWithReader(String line, Integer value) {
            return value + Integer.valueOf(line);
        }};
    return lineReadTemplate(filepath, sumCallback, 0);
}

public Integer calcMultiply(String filepath) throws IOException {
        LineCallback multiplyCallback
          = new LineCallback() {
            public Integer doSomethingWithReader(String line, Integer value) {
            return value * Integer.valueOf(line);
        }};
    return lineReadTemplate(filepath, multiplyCallback, 1);
}
