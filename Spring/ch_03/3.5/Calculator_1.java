//초기 Calculator 클래스 코드
package springbook.learningtest.template;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Calculator {
	public Integer calcSum(String filepath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        //한 줄씩 읽기 위한 BufferedReader로 파일 가져오기
        Integer sum = 0;
        String line = null;
        while((line = br.readLine()) != null) { //한 줄씩 읽어가며 수 더해주기
            sum += Integer.valueOf(line);
        }
   
        br.close();
        return sum;
    }
}
