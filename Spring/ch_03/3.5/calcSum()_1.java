//템플릿/콜백을 적용한 calcSum()
public Integer calcSum(String filepath) throws IOException {
        BufferedReaderCallback sumCallback
          = new BufferedReaderCallback() {
            public Integer doSomethingWithReader(BufferedReader br) throws IOException {
        Integer sum = 0;
        String line = null;
        while((line = br.readLine()) != null) {
            sum += Integer.valueOf(line);
        }
        return sum;
      }
  };
  return fileReadTemplate(filepath, sumCallback);
}
