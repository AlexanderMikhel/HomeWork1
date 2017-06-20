package view;

import controller.SchoolController;
import model.Exceptions.NotFoundObjectExceptions;
import model.Exceptions.NotValidateParametrException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.*;

import static com.sun.org.apache.xalan.internal.utils.SecuritySupport.getResourceAsStream;


public class View {
    private SchoolController controller;
    private Scanner in;
    private Logger logger;

    public View() {
        controller = new SchoolController();
        in = new Scanner(System.in);
        logger = Logger.getLogger(this.getClass().getName());
        try {
            FileHandler fh = new FileHandler("C:\\Users\\user\\Desktop\\Altarix\\DZver.2\\logFile.log",true);
            logger.addHandler(fh);
            logger.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        } catch (IOException e) {
            logger.log(Level.WARNING,"проблемы с настройкой логирования");
        }
    }

    public void start() {
       // template();
        try {
            controller.readData();
            boolean flag = true;
            while (flag) {
                int choice = 0;
                mainTheme();
                try {
                    choice = in.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println(controller.getAllClassestoString());
                            break;
                        case 2:
                            System.out.println(controller.getAllStudentstoString());
                            break;
                        case 3:
                            System.out.println(controller.getAllTeacherstoString());
                            break;
                        case 4:
                            System.out.println(controller.getAllSubjectstoString());
                            break;
                        case 5:
                            System.out.println(controller.getAllMarkstoString());
                            break;
                        case 6:
                            System.out.println("enter the class id: ");
                            int id = in.nextInt();
                            System.out.println(controller.getMarksInClasstoString(id));
                            break;
                        case 7:
                            System.out.println("enter the class id: ");
                            int classID = in.nextInt();
                            System.out.println("enter day: ");
                            int day = in.nextInt();
                            System.out.println("enter month: ");
                            int month = in.nextInt();
                            System.out.println("enter value: ");
                            int value = in.nextInt();
                            System.out.println("enter student id: ");
                            int stdentID = in.nextInt();
                            System.out.println("enter teacher id: ");
                            int teacherID = in.nextInt();
                            System.out.println("enter subject id: ");
                            int subjectID = in.nextInt();
                            controller.addMark(value, day, month, teacherID, stdentID, subjectID, classID);
                            break;
                        case 8:
                            System.out.println("enter the mark id: ");
                            int markID = in.nextInt();
                            controller.deleteMark(markID);
                            break;
                        case 9:
                            System.out.println("enter the mark id: ");
                            int markID1 = in.nextInt();
                            System.out.println("enter the new value: ");
                            int value1 = in.nextInt();
                            controller.changeMark(markID1, value1);
                            break;
                        case 10:
                            System.out.println("Goodbye");
                            flag = false;
                            controller.saveData();
                            logger.log(Level.INFO,"file is save");
                            break;
                        default:
                            System.out.println("There is no such command, try again");

                    }
                } catch (NotFoundObjectExceptions | NotValidateParametrException e) {
                    System.out.println(e.getMessage());
                } catch (InputMismatchException e) {
                    /**
                     * ВНИМАНИЕ, КОСТЫЛЬ!
                     * программа зацикливалась тк в поток для чисел попадал символ
                     * как отчистить сканер я не нашел, поэтому я просто создаю новый поток
                     * и работаю дальше с ним)
                      */
                    System.out.println("Необходимо ввести число, а не символ.");
                    Scanner scanner = new Scanner(System.in);
                    in = scanner;
                }
            }
        }catch (Exception e){
            System.out.print("Some problem with serialization");
        }
    }

    public void template() {
        try {
            controller.addSubject("mathematics");
            controller.addSubject("russian language");
            controller.addSubject("physics");
            controller.addSubject("mathematics");
            controller.addSubject("english language");
            controller.addSubject("literature");
            controller.addSubject("chemical");
            controller.addSubject("biological");

            controller.addTeacher("Maria", "Plushenko", 1);
            controller.addTeacher("Maria", "Shoigu", 2);
            controller.addTeacher("Victor", "Rudenko", 3);
            controller.addTeacher("Evgeney", "Riabov", 4);
            controller.addTeacher("Alexander", "Putin", 5);
            controller.addTeacher("Alexey", "Busin", 6);
            controller.addTeacher("Maxim", "Tikhonov", 7);
            controller.addTeacher("Olga", "Plushenko", 8);

            controller.addClassUnit(1);
            controller.addClassUnit(2);
            controller.addClassUnit(4);
            controller.addClassUnit(7);
            controller.addClassUnit(8);

            controller.addStudent("Vitia", "Avtaev", 1);
            controller.addStudent("Vitalik", "Strijko", 1);
            controller.addStudent("Igor", "Strijko", 1);
            controller.addStudent("Evelina", "Safin", 1);
            controller.addStudent("Sveta", "Levashkino", 1);
            controller.addStudent("Katerina", "Safin", 1);
            controller.addStudent("Nadejda", "Avtaev", 1);
            controller.addStudent("Pomidor", "Levashkin", 1);
            controller.addStudent("Faddey", "Safin", 1);
            controller.addStudent("Ipolit", "Strijko", 2);
            controller.addStudent("Lenin", "Avtaev", 1);
            controller.addStudent("Stalin", "Strijko", 1);
            controller.addStudent("Trockiy", "Levashkin", 1);
            controller.addStudent("Leha", "Safin", 1);
            controller.addStudent("Oleg", "Levashkin", 1);
            controller.addStudent("Mihail", "Strijko", 1);
            controller.addStudent("Maik", "Strijko", 1);
            controller.addStudent("Sveta", "Avtaev", 1);
            controller.addStudent("Katerina", "Strijko", 1);
            controller.addStudent("Nadejda", "Safin", 1);

            controller.addStudent("Stas", "Sadikov", 2);
            controller.addStudent("Nikolay", "Strijko", 2);
            controller.addStudent("Iluha", "Rudenko", 2);
            controller.addStudent("Stepa", "Rudenko", 2);
            controller.addStudent("Eva", "Strijko", 2);
            controller.addStudent("Katerina", "Rudenko", 2);
            controller.addStudent("Nadejda", "Chunihin", 2);
            controller.addStudent("Pomidor", "Karimov", 2);
            controller.addStudent("Baklajan", "Strijko", 2);
            controller.addStudent("Amir", "Chunihin", 2);
            controller.addStudent("Lenin", "Karimov", 2);
            controller.addStudent("Stalin", "Strijko", 2);
            controller.addStudent("Trockiy", "Strijko", 2);
            controller.addStudent("Leha", "Karimov", 2);
            controller.addStudent("Oleg", "Strijko", 2);
            controller.addStudent("Mihail", "Karimov", 2);
            controller.addStudent("Maik", "Chunihin", 2);
            controller.addStudent("Sveta", "Karimov", 2);
            controller.addStudent("Katerina", "Chunihin", 2);
            controller.addStudent("Nadejda", "Strijko", 2);

            controller.addStudent("Olga", "Durdiev", 3);
            controller.addStudent("Alexander", "Samoilov", 3);
            controller.addStudent("Lena", "Yarigin", 3);
            controller.addStudent("Natasha", "Strijko", 3);
            controller.addStudent("Sveta", "Muhlinin", 3);
            controller.addStudent("Katerina", "Yarigin", 3);
            controller.addStudent("lila", "Samoilov", 3);
            controller.addStudent("Pomidor", "Strijko", 3);
            controller.addStudent("Djuma", "Durdiev", 3);
            controller.addStudent("Ipolit", "Strijko", 3);
            controller.addStudent("KAterina", "Strijko", 3);
            controller.addStudent("Stalin", "Muhlinin", 3);
            controller.addStudent("Trockiy", "Samoilov", 3);
            controller.addStudent("Natasha", "Yarigin", 3);
            controller.addStudent("Oleg", "Durdiev", 3);
            controller.addStudent("Mihail", "Strijko", 3);
            controller.addStudent("Dima", "Yarigin", 3);
            controller.addStudent("Kirill", "Muhlinin", 3);
            controller.addStudent("Katerina", "Samoilov", 3);
            controller.addStudent("Sia", "Durdiev", 3);

            controller.addStudent("Petr", "Berezin", 4);
            controller.addStudent("Sergey", "Samoilov", 4);
            controller.addStudent("Lena", "Popov", 4);
            controller.addStudent("Natasha", "Strijko", 4);
            controller.addStudent("Sveta", "Popov", 4);
            controller.addStudent("Katerina", "Krasnov", 4);
            controller.addStudent("lila", "Berezin", 4);
            controller.addStudent("Tatiana", "Strijko", 4);
            controller.addStudent("Djuma", "Durdiev", 4);
            controller.addStudent("Ipolit", "Strijko", 4);
            controller.addStudent("Nikita", "Berezin", 4);
            controller.addStudent("Dima", "Berezin", 4);
            controller.addStudent("Dimka", "Popov", 4);
            controller.addStudent("Dimanchik", "Yarigin", 4);
            controller.addStudent("Brat", "Durdiev", 4);
            controller.addStudent("Za", "Popov", 4);
            controller.addStudent("Brata", "Krasnov", 4);
            controller.addStudent("Za", "Muhlinin", 4);
            controller.addStudent("Osnovy", "Samoilov", 4);
            controller.addStudent("Vziato", "Krasnov", 4);


            controller.addMark(1, 3, 4, 2, 3, 5, 1);
            controller.addMark(4, 3, 4, 4, 5, 5, 1);
        } catch (NotFoundObjectExceptions e) {
            e.getMessage();
        } catch (NotValidateParametrException e) {
            e.getMessage();
        }

    }

    public void mainTheme() {
        System.out.println("what do you want?");
        System.out.println("1 - get all classes");
        System.out.println("2 - get all students");
        System.out.println("3 - get all teachers");
        System.out.println("4 - get all subjects");
        System.out.println("5 - get all mark");
        System.out.println("6 - get all mark in the class");
        System.out.println("7 - set mark to student");
        System.out.println("8 - delete mark");
        System.out.println("9 - change mark");
        System.out.println("10 - exit");
    }
}
