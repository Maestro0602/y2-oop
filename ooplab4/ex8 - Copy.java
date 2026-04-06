class BasicMath {
    double addition(double a, double b) { 
        return a + b; 
    }
    double subtract(double a, double b) { 
        return a - b; 
    }
}

class AdvancedMath extends BasicMath {
    double multiply(double a, double b) { 
        return a * b; 
    }
    double divide(double a, double b)   { 
        return a / b; 
    }
}

public class ex8 {
    public static void main(String[] args) {
        BasicMath bm = new BasicMath();
        System.out.println(bm.addition(6, 7));   
        System.out.println(bm.subtract(6, 7));   

        AdvancedMath am = new AdvancedMath();
        System.out.println(am.addition(6, 7));   
        System.out.println(am.subtract(6, 7));   
        System.out.println(am.multiply(6, 7));   
        System.out.println(am.divide(6, 7));     
    }
}