import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;

public class list {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> laba8 = new ArrayList<String>();


        int choice;

        Scanner scan=new Scanner(System.in);
        System.out.println("Меню");

        System.out.println("1 Добавить");
        System.out.println("2 Удалить");
        System.out.println("3 Поиск одинаковых элементов");
        System.out.println("4 Реверс всех строк");
        System.out.println("5 Статистика по символам");
        System.out.println("6 Поиск подстроки в строках");
        System.out.println("7 Считать текстовый файл txt");
        System.out.println("8 Длины строк");
        System.out.println("9 Выгрузка в xml");

        do {
            System.out.println("Введите ваш выбор");
            choice=scan.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Введите новый элемент");
                    Scanner novoe = new Scanner(System.in);
                    String addtext = novoe.nextLine();
                    laba8.add( addtext);
                    System.out.println(laba8);
                    break;

                case 2:
                    System.out.println("Введите индекс элемента , который хотите удалить");
                    Scanner del = new Scanner(System.in);
                    int del1 = del.nextInt();
                    laba8.remove(del1);
                    System.out.println(laba8);
                    break;

                case 3:
                    HashMap<String,Integer> hm = new HashMap<String, Integer>();
                    Integer am;
                    for(String i: laba8){
                        am=hm.get(i);
                        hm.put(i,am==null? 1:am+1);
                    }
                    System.out.println(hm);
                    break;

                case 4:
                    Collections.reverse(laba8);
                    System.out.println(laba8);
                    break;

                case 5:
                    String laba8tr=laba8.toString();
                    Map<Character,Integer> map = new TreeMap<Character, Integer>();
                    for (char c : laba8tr.toCharArray())
                        map.put(c,(map.containsKey(c))?map.get(c)+1:1);

                    StringBuilder sb=new StringBuilder();
                    for (char c:map.keySet())
                        sb.append(c);
                    System.out.println("Имеются символы \""+sb.toString()+"\"");

                    for (char c:map.keySet())
                        System.out.printf("Количество '%c'=%d \n",c,map.get(c));
                    break;

                case 6:
                    System.out.println("Введите подстроку");
                    Scanner dev=new Scanner(System.in);
                    String podstr=dev.nextLine();

                    if(laba8.get(0).contains(podstr))
                        System.out.println("Подстрока найдена в строке "+laba8.get(0));

                    if(laba8.get(1).contains(podstr))
                        System.out.println("Подстрока найдена в строке " +laba8.get(1));

                    if(laba8.get(2).contains(podstr))
                        System.out.println("Подстрока найдена в строке " + laba8.get(2));
                    break;

                case 7:
                    Scanner s =new Scanner(new File("C:\\Users\\dasha\\8lab_2\\text.txt"));
                    String bla=s.nextLine();
                    laba8.add(bla);
                    System.out.println(laba8);
                    break;

                case 8:
                    System.out.println("Длина первой строки = "+laba8.get(0).length());
                    System.out.println("Длина второй строки = "+laba8.get(1).length());
                    System.out.println("Длина третьей строки = "+laba8.get(2).length());
                    System.out.println("Длина четвертой строки = "+laba8.get(3).length());
                    break;

                case 9:
                    laba8st p1 =new laba8st(laba8.get(0),laba8.get(1),laba8.get(2),laba8.get(3));
                    try {
                        FileOutputStream fos=new FileOutputStream(new File("./laba8list.xml"));
                        XMLEncoder encoder=new XMLEncoder(fos);
                        encoder.writeObject(p1);
                        encoder.close();
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    System.out.println("Успешно");
                    break;

                default:
                    System.out.println("Неверный ввод");
            }
        }while (choice!=15);
    }
}

