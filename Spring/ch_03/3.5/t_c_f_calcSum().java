//try/catch/finally 적용한 calcSum()
public Integer calcSum(String filepath) throws IOException {
    BufferedReader br = null;

    try {
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        Integer sum = 0;
        String line = null;
        while((line = br.readLine()) != null) { 
            sum += Integer.valueOf(line);
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
