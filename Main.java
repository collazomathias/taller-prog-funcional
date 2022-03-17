import java.util.function.BiFunction;
import java.util.function.IntBinaryOperator;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

        //Suma y resta
        BiFunction<Integer,Integer,Integer> sumar=(a, b) -> a+b;
        BiFunction<Integer,Integer,Integer> restar=(a, b) -> a-b;

        //BinaryOperators Add
        IntBinaryOperator add=(a, b)->a+b;

        //Multiplicación
        IntBinaryOperator mult=(a, b)-> 
          IntStream.range(0, b+1)
            .reduce((acumulador, numero)-> add.applyAsInt(acumulador, a))
            .getAsInt();


        //División
        BiFunction<Integer,Integer,Integer> divisionEntera = (num, den) ->{
            return IntStream.range(0, num+1)
                .reduce((acumulador, numero) -> {
                    if (mult.applyAsInt(numero, den) <= num) {
                        acumulador = numero;
                    }
                    return acumulador;
                }).getAsInt();
                    
        };

        System.out.println(sumar.apply(2, 5));
        System.out.println(restar.apply(5, 2));
        System.out.println(mult.applyAsInt(4, 5));
        System.out.println(divisionEntera.apply(95, 3));

    }
}