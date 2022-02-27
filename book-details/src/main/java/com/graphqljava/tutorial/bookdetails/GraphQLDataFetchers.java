package com.graphqljava.tutorial.bookdetails;

import com.google.common.collect.ImmutableMap;
import graphql.execution.DataFetcherResult;
import graphql.schema.DataFetcher;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Component
public class GraphQLDataFetchers {

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "author-1"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "author-2"),
            ImmutableMap.of("id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"),
            ImmutableMap.of("id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"),
            ImmutableMap.of("id", "author-3",
                    "firstName", "Anne",
                    "lastName", "Rice")
    );

    public DataFetcher getBookByIdDataFetcher() {

        System.out.println("--- BookByIdDataFetcher has been registered ---");

        return dataFetchingEnvironment -> {
            System.out.println("-- BookByIdDataFetcher is waiting for response ---");
            // Sleep
            TimeUnit.SECONDS.sleep(30);

            String bookId = dataFetchingEnvironment.getArgument("id");
            // Snapshot directive
            Object snapshotInput = dataFetchingEnvironment.getArgument("snapshotInput");
            System.out.println("  -- snapshotInput: " + snapshotInput + " --");

            Map<String, String> firstBook = books.stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);

            DataFetcherResult.Builder builder = DataFetcherResult.newResult().data(firstBook);
            return builder.build();
        };
    }

    public DataFetcher getAuthorDataFetcher() {

        System.out.println("--- AuthorDataFetcher has been registered ---");

        return dataFetchingEnvironment -> {
            System.out.println("-- AuthorDataFetcher is waiting for response --");
            Map<String, String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authors
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }
}
