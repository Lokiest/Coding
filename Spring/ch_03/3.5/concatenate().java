//문자열 연결 기능 콜백을 이용하여 만든 concatenate()
public String concatenate(String filepath) throws IOException {
        LineCallback<String> multiplyCallback
          = new LineCallback<String>() {
            public String doSomethingWithReader(String line, String value) {
            return value + line;
        }};
    return lineReadTemplate(filepath, concatenateCallback, ""); //템플릿 메소드의 T는 모두 String화
}
