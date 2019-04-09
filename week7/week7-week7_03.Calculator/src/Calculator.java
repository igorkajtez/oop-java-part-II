
public class Calculator {

    private Reader reader;
    private int counter;

    public Calculator() {
        this.reader = new Reader();
        this.counter = 0;
    }

    public void start() {
        while (true) {
            System.out.print("command: ");
            String command = this.reader.readString();
            if (command.equals("end")) {
                break;
            }

            if (command.equals("sum")) {
                sum();
                this.counter++;
            } else if (command.equals("difference")) {
                difference();
                this.counter++;
            } else if (command.equals("product")) {
                product();
                this.counter++;
            }
        }

        statistics();
    }

    private void sum() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        
        System.out.println("sum of the values " + (value1+value2));

    }

    private void difference() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        
        System.out.println("difference of the values " + (value1-value2)); 
    }

    private void product() {
        System.out.print("value1: ");
        int value1 = reader.readInteger();
        
        System.out.print("value2: ");
        int value2 = reader.readInteger();
        
        System.out.println("product of the values " + (value1*value2));
    }
    
    private void statistics() {
        System.out.println("Calculations done " + this.counter);
    }

}
