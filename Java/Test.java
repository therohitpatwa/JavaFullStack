
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Test
{
   public static void main(String[] args) {
       ArrayList<Integer> l1=new ArrayList<>(Arrays.asList(10,20,30,40,50));
       System.out.println(l1);
        System.err.println("----------------------------------------------");

       //WAP to filter the elements of the list which are greater than 20 and store them in another list using stream API
       List<Integer> collect=l1.stream().filter(i->i>20).collect(Collectors.toList());
         System.out.println(collect);

        System.err.println("----------------------------------------------");
        
        //WAP to add 5 to each element and store them in another list using stream API
        List<Integer> collect2= l1.stream().map(i->i+5).collect(Collectors.toList());
        System.out.println(collect2);

        System.out.println("----------------------------------------------");

        //Terminal operation
        // toArray() method
        Stream<Integer> s = Stream.of(1, 2, 3, 4, 5);
        Object[] arr = s.toArray();
        for (Object obj : arr) {
            System.out.print(obj + " ");
        }
        System.out.println();
        System.err.println("----------------------------------------------");

        //2. count() method
        Stream<Integer> s1 = Stream.of(1, 2, 3, 4, 5);
        long count=s1.count();
        System.out.println("Count: " + count);

        System.err.println("----------------------------------------------");

        //3. forEach() method
        Stream<Integer> s2 = Stream.of(1, 2, 3, 4, 5);
        s2.forEach(ele->System.err.print(ele+""));

        System.err.println();
        System.out.println("----------------------------------------------");
        //4. min(), max() method
        Stream<Integer> s3 = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> s4 = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> min = s3.min((o1,o2)->o1.compareTo(o2));
        Optional<Integer> max = s4.max((o1,o2)->o1.compareTo(o2));
        System.out.println("Min: " + min.get());
        System.out.print("Max: " +max.get());

        System.err.println();
        System.out.println("----------------------------------------------");

        //5. anyMatch() method
        ArrayList<Integer> listOfNum=new ArrayList<>(Arrays.asList(10,20,30,40,50));
        listOfNum.stream().anyMatch(i->i>20);
        boolean anyMatch = listOfNum.stream().anyMatch(i -> i > 20);
        System.out.println("Any Match: " + anyMatch);

        System.err.println("");
        System.out.println("----------------------------------------------");

        //6. allMatch() method
        boolean allMatch = listOfNum.stream().allMatch(i -> i > 20);
        System.out.println("All Match: " + allMatch);

        System.err.println("");
        System.out.println("----------------------------------------------");

        //7. noneMatch() method
        boolean noneMatch = listOfNum.stream().noneMatch(i -> i > 20);
        System.out.println("None Match: " + noneMatch);

        System.err.println("");
        System.out.println("----------------------------------------------");


        //8. findAny() method
        Stream<Integer> s5 = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> findAny = s5.findAny(); 
        System.out.println("Find Any: " + findAny.get());

        System.err.println("");
        System.out.println("----------------------------------------------");


        //9. findFirst() method
        Stream<Integer> s6 = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> findFirst = s6.findFirst();
        System.out.println("Find First: " + findFirst.get());

        System.err.println("");
        System.out.println("----------------------------------------------");

        //10. collect method()
        Stream<Integer> s7 = Stream.of(1, 2, 3, 4, 5);
        List<Integer> collect3 = s7.collect(Collectors.toList());
        System.out.println("Collect: " + collect3);

        
   }

}