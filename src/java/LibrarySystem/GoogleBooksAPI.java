package LibrarySystem;

import Model.Book;

import org.json.simple.parser.ParseException;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonString;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class GoogleBooksAPI {


    public static String makeUrlQuery(String title, String[] authors, String isbn, String publisher) {


        StringBuilder requests = new StringBuilder();

        if (!title.equals("*")) {
            requests.append("intitle:").append(title);
        }
        if (!isbn.equals("*")) {
            requests.append("+isbn:").append(isbn);
        }
        if (!publisher.equals("*")) {
            requests.append("+inpublisher:").append(publisher);
        }
        for(String i: authors){

            if(i.equals("*")){
                break;
            }else{
                requests.append("+inauthor:").append(i);
            }
        }

        return String.format("https://www.googleapis.com/books/v1/volumes?q=%s", requests);
    }

    public static String retrieveJson(String RequestUrl) {

        StringBuilder sb = new StringBuilder();

        try {
            URL url = new URL(RequestUrl.replace(" ", "%20"));
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setRequestProperty("Accept", "application/json");
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
            }
            BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
            String output;
            while ((output = br.readLine()) != null) {
                //System.out.println(output);
                sb.append(output);
            }
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    public ArrayList<Book> booksFromAPI(String jsonString) throws NullPointerException, ParseException {

        ArrayList<Book> googleBooks = new ArrayList<>();

        String isbn = "";
        String title;
        List<String> authors = new ArrayList<>();
        String publisher;
        String publishDate;
        int pageCount;

        JsonReader jsonReader = Json.createReader(new StringReader(jsonString));
        JsonObject json = jsonReader.readObject();
        jsonReader.close();

            for (JsonObject jsonObject : json.getJsonArray("items").getValuesAs(JsonObject.class)) {
                if (jsonObject.getJsonObject("saleInfo").getJsonString("country").toString().equals("\"US\"")
                        && jsonObject.getJsonObject("saleInfo").getJsonString("saleability").toString().equals("\"FOR_SALE\"")) {
                    try{
                    for (JsonObject p : jsonObject.getJsonObject("volumeInfo").getJsonArray("industryIdentifiers").getValuesAs(JsonObject.class)) {
                        if (p.getJsonString("type").toString().equals("\"ISBN_13\"")) {
                            isbn = p.getJsonString("identifier").toString();
                        }
                    }
                    }catch(NullPointerException e){isbn = "";}

                    try{
                    title = jsonObject.getJsonObject("volumeInfo").getJsonString("title").toString(); }
                    catch(NullPointerException e){title = "";}

                    for (JsonString p : jsonObject.getJsonObject("volumeInfo").getJsonArray("authors").getValuesAs(JsonString.class)) {
                        authors.add(p.toString());

                        try{
                        publisher = jsonObject.getJsonObject("volumeInfo").getJsonString("publisher").toString();}
                        catch(NullPointerException e){publisher = "";}

                        try{
                        publishDate = jsonObject.getJsonObject("volumeInfo").getJsonString("publishedDate").toString();}
                        catch(NullPointerException e){publishDate="";}

                        try{
                        pageCount = jsonObject.getJsonObject("volumeInfo").getJsonNumber("pageCount").intValue();}
                        catch (NullPointerException e) { pageCount = 0;}

                        StringBuilder authorsString = new StringBuilder();

                        for (String author : authors) {
                            authorsString.append(author.replace("\"", "")).append(",");
                        }

                        Book newBook = new Book(Long.parseLong(isbn.replace("\"", "")), title, authorsString.toString().substring(0,
                                authorsString.length() - 1), publisher, publishDate, pageCount);
                        googleBooks.add(newBook);
                    }
                }
            }
            return googleBooks;
    }
}
