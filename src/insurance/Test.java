package insurance;

public class Test {

    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
          Deploy d=new Deploy();
          Violation v=new Violation();
          v.setViolationtime(2);             
          int mc=v.getViolationtime();
          d.deployrool(mc);
    }
}