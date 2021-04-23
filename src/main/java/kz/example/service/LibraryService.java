//package kz.example.service;
//
//import kz.example.entity.Book;
//import kz.example.entity.Moder;
//import kz.example.entity.PersonalData;
//import kz.example.entity.User;
//import kz.example.repository.BookRepository;
//import kz.example.repository.ModeratorRepository;
//import kz.example.repository.PersonalDataRepository;
//import kz.example.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class LibraryService {
//
//
//    private final BookRepository bookRepository;
//
//    private final ModeratorRepository moderatorRepository;
//
//    private final PersonalDataRepository personalDataRepository;
//
//    private final UserRepository userRepository;
//
//    @Autowired
//    public LibraryService(BookRepository bookRepository, ModeratorRepository moderatorRepository, PersonalDataRepository personalDataRepository, UserRepository userRepository) {
//        this.bookRepository = bookRepository;
//        this.moderatorRepository = moderatorRepository;
//        this.personalDataRepository = personalDataRepository;
//        this.userRepository = userRepository;
//    }
//
//    public Moder moderLogin(String name, String password) {
//        return moderatorRepository.findModer(name, password);
//    }
//
//    public User userLogin(String name, String password) {
//        return userRepository.findUser(name, password);
//    }
//
//    public void userRegister(PersonalData personalData) {
//         personalDataRepository.save(personalData);
//    }
//
//
//    public void issueBook(Long id, Long user_id ) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//
//        if (optionalBook.isPresent()) {
//
//            if (optionalBook.get().getMyUserId() == null) {
//                Book updatedBook = optionalBook.get();
//                updatedBook.setMyUserId(user_id);
//                updatedBook.setIssued(true);
//
//                bookRepository.save(updatedBook);
//            } else {
//                System.out.println("Book not available");
//            }
//
//        }
//    }
//
//    public void returnIssuedBook(Long id) {
//        Optional<Book> optionalBook = bookRepository.findById(id);
//
//        if (optionalBook.isPresent()) {
//            Book updatedBook = optionalBook.get();
//            updatedBook.setMyUserId(null);
//            updatedBook.setIssued(false);
//
//            bookRepository.save(updatedBook);
//        }
//    }
//
//    public List<Book> findAvailableBooks() {
//        return bookRepository.findAvailableBooks(false);
//    }
//
//    public List<Book> findNotAvailableBooks() {
//        return bookRepository.findNotAvailableBooks(true);
//    }
//
//    public Optional<User> findMyBooks(Long id) {
//        return userRepository.findById(id);
//    }
//
//    public Optional<Book> findBookById(Long id) {
//        return bookRepository.findById(id);
//    }
//
//    public void addNewBook(Book book) {
//        bookRepository.save(book);
//    }
//}
