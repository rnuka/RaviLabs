package practice.coding.games;

import java.util.ArrayList;
import java.util.NavigableSet;
import java.util.List;
import java.util.TreeSet;

public final class Boggle {

    private static final NavigableSet<String> dictionary;
   // private final Map<Character, List<Character>> graph = new HashMap<Character, List<Character>>();


    static {
        dictionary = new TreeSet<String>();
        
        dictionary.add("ant");
        dictionary.add("tank");
        dictionary.add("pig");
        dictionary.add("gun");
        dictionary.add("tic");
        dictionary.add("bank");
        dictionary.add("pea");
        dictionary.add("pit");
        dictionary.add("azure");
        dictionary.add("dazzle");
        /*try {
            FileReader fr = new FileReader("/Users/ameya.patil/Desktop/text.txt");
            BufferedReader br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                dictionary.add(line.split(":")[0]);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while reading dictionary");
        }*/
    }

    private Boggle() {}

    public static List<String> boggleSolver(char[][] board) {
        if (board == null) {
            throw new NullPointerException("The matrix cannot be null");
        }
        final List<String> validWords = new ArrayList<String>();
        int rows = board.length;
        int columns = board[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                solve(board, i, j, board[i][j] + "", validWords);
            }
        }
        return validWords;
    }

    private static void solve(char[][] m, int i, int j, String prefix, List<String> validWords) {
        assert m != null;
        assert validWords != null;

        for (int i1 = Math.max(0, i - 1); i1 < Math.min(m.length, i + 2); i1++) {
            for (int j1 = Math.max(0, j - 1); j1 < Math.min(m[0].length, j + 2); j1++) {
                if (i1 != i || j1 != j) {
                    String word = prefix+ m[i1][j1];

                    if (dictionary.contains(word)) {
                        validWords.add(word);
                    }

                    if (dictionary.subSet(word, word + Character.MAX_VALUE).size() > 0) {
                        solve(m, i1, j1, word, validWords);
                    }
                }
            }
        } 
    }

    public static void main (String[] args) {
          char[][] board  ={{'a','b','c','d'},
                              {'n','t','i','p'},
                              {'k','n','g','e'},
                              {'o','s','u','a'}
                              };

          List<String> list = Boggle.boggleSolver(board);
          for (String str :  list) {
              System.out.println(str);
          }
    }
}