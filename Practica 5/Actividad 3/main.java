package epx3;

public class main {
    public static void main(String[] args) {
        // Tipos integrados
        System.out.println(IgualGenerico.esIgualA(5, 5));               
        System.out.println(IgualGenerico.esIgualA(5, 10));              

        // null
        System.out.println(IgualGenerico.esIgualA(null, null));         
        System.out.println(IgualGenerico.esIgualA(null, "texto"));      

        // Object
        Object obj1 = new Object();
        Object obj2 = obj1;
        Object obj3 = new Object();
        System.out.println(IgualGenerico.esIgualA(obj1, obj2));         
        System.out.println(IgualGenerico.esIgualA(obj1, obj3));        

        // Integer
        Integer int1 = 100;
        Integer int2 = 100;
        System.out.println(IgualGenerico.esIgualA(int1, int2));         

        // String
        String s1 = "Melgar";
        String s2 = "Melgar";
        String s3 = new String("Melgar");
        System.out.println(IgualGenerico.esIgualA(s1, s2));             
        System.out.println(IgualGenerico.esIgualA(s1, s3));             
    }
}