//제네릭 메소드로 만든 lineReadTemplate()
public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException {
                                                                        //계산 결과 저장할 변수 초기값
    BufferedReader br = null;

    try {
        T res = initVal;
        String line = null;
        while((line = br.readLine()) != null { //각 라인 돌면서 가져오는 것도 템플릿이 담당
            res = callback.doSomethingWithLine(line, res); //콜백이 계산한 값을 저장해뒀다가 다인 계산에 다시 사용
        }
   
        return res;
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
