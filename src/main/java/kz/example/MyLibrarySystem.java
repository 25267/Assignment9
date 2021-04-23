//package kz.example;
//
//import kz.example.config.SpringConfig;
//import kz.example.controller.LibraryController;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//public class MyLibrarySystem {
//    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//    private static Boolean moderBool = true;
//    private static Boolean userBool = true;
//
//    public static void main(String[] args) throws IOException {
//        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
//                SpringConfig.class
//        );
//
//        LibraryController controller = context.getBean("libraryController", LibraryController.class);
//
//
//        System.out.println("1. Login Moder");
//        System.out.println("2. Login User");
//        System.out.println("3. Register User");
//        String ch = read.readLine();
//
//
//        switch (ch) {
//            case "1":
//                if (controller.moderLogin()) {
//                    while (moderBool) {
//                        System.out.println("1. Add Book");
//                        System.out.println("2. Find Available Books");
//                        System.out.println("3. Find Not Available Books");
//                        System.out.println("0. To Quit");
//                        String choice = read.readLine();
//
//                        switch (choice) {
//                            case "1":
//                                controller.addBook();
//                                break;
//                            case "2":
//                                controller.findAvailableBooks();
//                                break;
//                            case "3":
//                                controller.findNotAvailableBooks();
//                                break;
//                            default:
//                                moderBool = false;
//                        }
//                    }
//                }
//                break;
//            case "2":
//                if (controller.userLogin()) {
//                    while (userBool) {
//                        System.out.println("1. Issue Book");
//                        System.out.println("2. Return Book");
//                        System.out.println("3. My BOOKS");
//                        System.out.println("4. Available Books");
//                        System.out.println("5. find By id");
//                        System.out.println("0. To Quit");
//                        String choice = read.readLine();
//
//                        switch (choice) {
//                            case "1":
//                                controller.issueBook();
//                                break;
//                            case "2":
//                                controller.returnBook();
//                                break;
//                            case "3":
//                                controller.findMyBooks();
//                                break;
//                            case "4":
//                                controller.findAvailableBooks();
//                                break;
//                            case "5":
//                                controller.findById();
//                                break;
//                            default:
//                                userBool = false;
//                        }
//                    }
//                }
//                break;
//            case "3":
//                controller.userRegister();
//                break;
//            case "0":
//                System.out.println("Bye bye");
//                break;
//
//            default:
//                System.out.println("exit");
//        }
//    }
//}
