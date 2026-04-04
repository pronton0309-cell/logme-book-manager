package ログミー;
import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[]args){

        Scanner scanner = new Scanner(System.in,"MS932");
        ArrayList<Book>books = new ArrayList<>();

        while(true){
            System.out.println("=== ログミー ===");
            System.out.println("1.本を登録");
            System.out.println("2.本を削除");
            System.out.println("3.一覧表示");
            System.out.println("4.タイトル検索");
            System.out.println("5.終了");
            System.out.println("メニュー番号を入力してください");

            int menu = scanner.nextInt();
            scanner.nextLine();

            if(menu == 1){
                Book book = new Book();

                System.out.println("タイトル：");
                book.title = scanner.nextLine();

                System.out.println("著者：");
                book.author = scanner.nextLine();

                System.out.println("おすすめ度(1～5)：");
                book.rating = scanner.nextInt();
                scanner.nextLine();

                System.out.println("感想：");
                book.review = scanner.nextLine();

                System.out.println("読書状態（未購入/未読/読了）:");
                book.status = scanner.nextLine();

                books.add(book);
                System.out.println("本を登録しました！");
                
            }else if (menu == 2){
                System.out.println("--現在登録中の本--");
                for (int i = 0; i < books.size(); i++) {
                     Book book = books.get(i);
                     System.out.println((i + 1) + " : " + book.title);
                }
                System.out.println("削除する本の番号を入力してください");
                int input = scanner.nextInt();
                int index = input - 1;

                if(index >= 0 && index < books.size()){
                    books.remove(index);
                    System.out.println("削除しました");
                }else {
                    System.out.println("その番号の本はありません");
                }

            }else if (menu == 3){
                if(books.size() == 0){
                    System.out.println("まだ本が登録されていません。");
                }else{
                    for (int i = 0; i < books.size(); i++){
                        Book book = books.get(i);
                        System.out.println("----" + (i + 1) + "冊目 ----");
                        System.out.println("タイトル：" + book.title);
                        System.out.println("著者：" + book.author);
                        System.out.println("おすすめ度：" + book.rating);
                        System.out.println("感想：" + book.review);
                        System.out.println("読書状態：" + book.status);
                    }
                }
            }else if (menu == 4){
                System.out.println("検索したいタイトルを入力してください");
                String keyword = scanner.nextLine();

                boolean found = false;

                for (int i = 0; i < books.size(); i++){
                     Book book = books.get(i);

                     if (book.title.contains(keyword)){
                        System.out.println("本が見つかりました！");
                        System.out.println("タイトル:"+ book.title);
                        System.out.println("著者:"+ book.author);
                        System.out.println("おすすめ度:" + book.rating);
                        System.out.println("感想:" + book.review);
                        System.out.println("読書状態:" + book.status);
                     found = true;
                    }
                }
                if ( found == false){
                    System.out.println("そのタイトルの本は見つかりませんでした。");
                }
                    
                                }else if (menu == 5){
                System.out.println("ログミーを終了します。");
                break;

            }else {
                System.out.println("1~4を入力して下さい。");
            }
            System.out.println();
        }
            scanner.close();
        }
    }
