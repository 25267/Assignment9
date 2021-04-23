//package kz.example.controller;
//
//import kz.example.entity.Book;
//import kz.example.entity.PersonalData;
//import kz.example.entity.User;
//import kz.example.service.LibraryService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//
//
//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//@Controller
//public class LibraryController {
//
//
//    private Long user_Id;
//    private static BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
//
//    private final LibraryService service;
//
//    @Autowired
//    public LibraryController(LibraryService service) {
//        this.service = service;
//    }
//
//
//    public boolean moderLogin() throws IOException {
//        System.out.println("Moder NAME:");
//        String adminName = read.readLine();
//        System.out.println("Moder PASSWORD:");
//        String adminPassword = read.readLine();
//
//        if (service.moderLogin(adminName, adminPassword) != null) {
//
//            return true;
//        } else {
//            return false;
//        }
//    }
//
//    public boolean userLogin() throws IOException {
//        System.out.println("User NAME:");
//        String userName = read.readLine();
//        System.out.println("User PASSWORD:");
//        String userPassword = read.readLine();
//
//
//        if (service.userLogin(userName, userPassword) != null) {
//            user_Id = service.userLogin(userName, userPassword).getId();
//            return true;
//        } else {
//            return false;
//
//        }
//    }
//
//
//    public void userRegister() throws IOException {
//        System.out.println("User Name:");
//        String userName = read.readLine();
//        System.out.println("User PASSWORD:");
//        String userPassword = read.readLine();
//        System.out.println("age");
//        String age = read.readLine();
//        System.out.println("phone Number");
//        String phone = read.readLine();
//        System.out.println("street");
//        String street = read.readLine();
//        System.out.println("house Number");
//        String houseNo = read.readLine();
//
//        PersonalData personalData = new PersonalData();
//        personalData.setAge(age);
//        personalData.setPhoneNumber(phone);
//        personalData.setHouseNo(houseNo);
//        personalData.setStreet(street);
//
//        User user = new User(userName, userPassword);
//
//        personalData.setUser(user);
//
//
//        service.userRegister(personalData);
//
//    }
//
//
//    public void addBook() throws IOException {
//        System.out.println("write author");
//        String authorName = read.readLine();
//        System.out.println("write title");
//        String title = read.readLine();
//
//        Book book = new Book(authorName, false, title);
//
//        service.addNewBook(book);
//    }
//
//    public void issueBook() throws IOException {
//        System.out.println("Write id of the book");
//        Long book_id = Long.valueOf(read.readLine());
//
//        service.issueBook(book_id, user_Id);
//
//
//    }
//
//    public void  returnBook() throws IOException {
//        System.out.println("Write id of the book");
//        Long book_id = Long.valueOf(read.readLine());
//
//        service.returnIssuedBook(book_id);
//    }
//
//    public void findAvailableBooks(){
//        System.out.println("Available BOOKS: " + service.findAvailableBooks());
//    }
//
//    public void findNotAvailableBooks(){
//        System.out.println("Not Available BOOKS: " + service.findNotAvailableBooks());
//    }
//
//    public void findMyBooks(){
//        System.out.println("My BOOKS: " + service.findMyBooks(user_Id));
//    }
//
//    public void findById() throws IOException {
//        System.out.println("Write id of the Book");
//        Long id = Long.valueOf(read.readLine());
//        System.out.println(service.findBookById(id));
//    }
//}
