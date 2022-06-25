//BufferedReaderCallback을 사용하는 템플릿 메소드
public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException {
    BufferedReader br = null;

    try {
        br = new BufferedReader(new FileReader(filepath));
        int ret = callback.doSomethingWithReader(br); //콜백 오브젝트 호출
        return ret
        }
   
        br.close();
        return sum;
    }
 
    catch(IOException e) {
        System.out.println(e.getMessage());
        throw e;
    }

    finally {
        if (br != null) {
            try { br.close(); }
            catch(IOException e) { System.out.println(e.getMessage()); }
        }
    }
}
