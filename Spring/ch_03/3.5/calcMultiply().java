//곱을 계산하는 콜백을 가진 calcMultiply()
public Integer calcMultiply(String filepath) throws IOException {
        BufferedReaderCallback multiplyCallback
          = new BufferedReaderCallback() {
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
        Integer multiply = 1;
        String line = null;
        while((line = br.readLine()) != null) {
            multiply *= Integer.valueOf(line);
        }
        return multiply;
      }
  };
  return fileReadTemplate(filepath, multiplyCallback);
}
