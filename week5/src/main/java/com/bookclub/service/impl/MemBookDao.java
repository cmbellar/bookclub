/*
    Walls, Craig (2022, March 1). Spring in Action (6th ed.). 
        Manning.
    Additional modifications by C. Bellar 2024
*/
package com.bookclub.service.impl;

/** imports */
import com.bookclub.model.Book;
import com.bookclub.service.dao.BookDao;
import java.util.ArrayList;
import java.util.List;

public class MemBookDao implements BookDao {

    private List<Book> books; // Sets a list of Book objects.

    /**
     * Default Constructor which is used to create a MemBookDao object with five preloaded Books.
     * @return none.
     */
    public MemBookDao() {
        this.books = new ArrayList<Book>();
        this.books.add(new Book("1250832365", "The Eye of the World", "When a vicious band of half-men, half beasts invade the Two Rivers seeking their master’s enemy, Moiraine persuades Rand al’Thor and his friends to leave their home and enter a larger unimaginable world filled with dangers waiting in the shadows and in the light.", 784, new ArrayList<>(List.of("Robert Jordan"))));
        this.books.add(new Book("0765334348", "The Great Hunt", "For centuries, gleemen have told the tales of The Great Hunt of the Horn. So many tales about each of the Hunters, and so many Hunters to tell of... Now the Horn itself is found: the Horn of Valere long thought only legend, the Horn which will raise the dead heroes of the ages. And it is stolen. In pursuit of the thieves, Rand al’Thor is determined to keep the Horn out of the grasp of The Dark One. But he has also learned that he is The Dragon Reborn―the Champion of Light destined to stand against the Shadow time and again. It is a duty and a destiny that requires Rand to uncover and master extraordinary capabilities he never imagined he possessed.", 672, new ArrayList<>(List.of("Robert Jordan"))));
        this.books.add(new Book("0765334356", "The Dragon Reborn", "Winter has stopped the war―almost―yet men are dying, calling out for the Dragon. But where is he? Rand al’Thor has been proclaimed the Dragon Reborn. Traveling to the great fortress known as the Stone of Tear, he plans to find the sword Callandor, which can only be wielded by the Champion of Light, and discover if he truly is destined to battle The Dark One. Following Rand, Moiraine and their friends battle Darkhounds on the hunt, hoping they reach the Heart of the Stone in time for the next great test awaiting the Dragon Reborn.", 624, new ArrayList<>(List.of("Robert Jordan"))));
        this.books.add(new Book("0312854315", "The Shadow Rising", "Accompanied by Moiraine Damodred, Rand arrives at the Aiel Waste and is granted permission by the Wise Ones to enter the sacred city of Rhuidean. After passing through a doorframe ter'angreal, Moiraine gains foresight while the Aiel await Rand's return, either with both arms marked by dragon symbols, validating his identity as He Who Comes With the Dawn, the Chief of Chiefs of all the Aiel―or to never emerge at all.", 704, new ArrayList<>(List.of("Robert Jordan"))));
        this.books.add(new Book("0274900653", "The Fires of Heaven", "Prophesized to defeat the Dark One, Rand al'Thor, the Dragon Reborn, has upset the balance of power across the land. Shaido Aiel are on the march, ravaging everything in their path. The White Tower's Amyrlin has been deposed, turning the Aes Sedai against one another. The forbidden city of Rhuidean is overrun by Shadowspawn. Despite the chaos swirling around him, Rand continues to learn how to harness his abilities, determined to wield the One Power--and ignoring the counsel of Moiraine Damodred at great cost.", 704, new ArrayList<>(List.of("Robert Jordan"))));
    }

    /**
     * Method which is used to return an array of Books.
     * @return a list of Books.
     */
    @Override
    public List<Book> list() {
        return this.books;
    } // end list

    /**
     * Method with one argument which is used to return a specific Book when the isbn matches.
     * @param key String
     * @return a Book.
     */
    @Override
    public Book find(String key) {
        for (Book book : this.books) {
            if (book.getIsbn().equals(key)) {
                return book;
            }
        }
        return new Book();
    } // end find
} // end MemBookDao