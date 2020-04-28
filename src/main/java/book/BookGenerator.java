package book;

import book.model.Book;
import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class BookGenerator {

    private static Faker faker = new Faker();

    public static Book createBook() {

        Date date = faker.date().past(10000, TimeUnit.DAYS);
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        Book book = Book.builder()
                .isbn13(faker.code().isbn13())
                .author(faker.book().author())
                .title(faker.book().title())
                .format(faker.options().option(Book.Format.class))
                .publisher(faker.book().publisher())
                .publicationDate(localDate)
                .pages(faker.number().numberBetween(1,1000))
                .available(faker.bool().bool())
                .build();

        return book;
    }
}
