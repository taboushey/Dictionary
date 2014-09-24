package dictionary;

/*
 * @author Tabetha Boushey and Kelsey O'Keefe
 * @version 4/2/2012
 * Out Lab 5
 */
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Collections;

public class Interface extends JFrame {

    JTextField wordTextBox, definitionTextBox;
    JButton insertButton, printTreeButton, searchButton, quitButton;
    final static BinaryTree newTree = new BinaryTree();
    final static MyStack stack = new MyStack();
    static TreeNode root = null;
    Collection c = new ArrayList();
    ArrayList<String> words = new ArrayList<String>();
    ArrayList<TreeNode> input = new ArrayList<TreeNode>();

    public static void main(String[] args) {

        JFrame iFrame = new Interface();
        iFrame.setVisible(true);
        iFrame.setSize(400, 300);
        iFrame.setLocation(200, 100);
    }

    public Interface() {

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        String fileName = "C:/Users/Tabetha/Desktop/Dictonary/dictonary.txt";
        stack.push(null);
        int j = 0;
        try {
            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()) {
                words.add(scanner.nextLine());
                j++;
            }
            //j /= 2;
        } catch (Exception e) {
        }
        try {

            Scanner scanner = new Scanner(new FileReader(fileName));
            while (scanner.hasNextLine()) {
//            while (j != 0) {
//                stack.push(scanner.nextLine());
//                j--;
//            }
//            //Collections.shuffle(words);
//            for(int i = 0; i < words.size(); i++) {
//
////                String data = scanner.nextLine();
////                String[] dataArray = data.split("");
////                String word = "";
////                String definition = "";
//                
//                String[] blah = words.get(i).split(" ");
//                String definition = "";
//                    
//                for(int x = 1; x < blah.length; x++)
//                {
//                    
//                    definition += blah[x]+ " ";
//                }

                String word = scanner.next();
                String definition = scanner.nextLine();
                TreeNode temp = new TreeNode(word, definition);
                input.add(temp);
                // insert(temp, root);
                // PrintTree2.printTree(root);
            }
            while (input.size() > 0) {
                int place = (int) (Math.random() * input.size());
                insert(input.remove(place), root);
            }
            PrintTree2.printTree(root);
//                int i = 0;
//                for (int k = 0; k < dataArray.length; k++) {
//                    if (i == 0) {
//                        if (dataArray[k].equalsIgnoreCase(" ")) {
//                            i = 1;
//                            if (dataArray[k + 1].equalsIgnoreCase("a")) {
//                                k += 5;
//                            }
//                            k += 3;
//                        } else {
//                            word += dataArray[k];
//                        }
//                    } else {
//                        definition += dataArray[k];
//                    }
//                }
//                TreeNode node = new TreeNode(word, definition);
//                newTree.insert(node);
//            }
//            while (stack.peek() != null) {
//                String data = stack.pop();
//                String[] dataArray = data.split("");
//                String word = "";
//                String definition = "";
//                int i = 0;
//                for (int k = 0; k < dataArray.length; k++) {
//                    if (i == 0) {
//                        if (dataArray[k].equalsIgnoreCase(" ")) {
//                            i = 1;
//                            k += 3;
//                        } else {
//                            word += dataArray[k];
//                        }
//                    } else {
//                        definition += dataArray[k];
//                    }
//                }
//                TreeNode node = new TreeNode(word, definition);
//                newTree.insert(node);
//            }
//            PrintTree2.printTree(newTree);
        } catch (Exception e) {
            System.out.println("No words to add");
        }

        setTitle("Dictionary");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 0;
        c.gridy = 0;
        add(new JLabel("Enter word here:"), c);

        wordTextBox = new JTextField(15);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 1;
        c.gridy = 0;
        add(wordTextBox, c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 0;
        c.gridy = 1;
        add(new JLabel("Enter definition here:"), c);

        definitionTextBox = new JTextField(15);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 1;
        c.gridy = 1;
        add(definitionTextBox, c);

        insertButton = new JButton("Insert");
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String word = wordTextBox.getText();
                String definition = definitionTextBox.getText();
                System.out.println("'" + word + "'" + " with definition " + "'" + definition + "'");
                TreeNode node = new TreeNode(word, definition);
                insert(node, root);
                System.out.println(wordTextBox.getText() + " was added");
                wordTextBox.setText(null);
                definitionTextBox.setText(null);
                //PrintTree2.printTree(newTree);
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 0;
        c.gridy = 2;
        add(insertButton, c);

        printTreeButton = new JButton("Print Tree");
        printTreeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Printing tree ");
                PrintTree2.printTree(root);
                wordTextBox.setText(null);
                definitionTextBox.setText(null);                
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 1;
        c.gridy = 2;
        add(printTreeButton, c);

        searchButton = new JButton("Search");
        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String search = wordTextBox.getText();
                System.out.println("Searching for: " + search + "...");
                wordTextBox.setText(null);
                definitionTextBox.setText(null);
                try {
                    search(root, new TreeNode(search, ""));

                } catch (Exception err) {
                    System.out.println("This word is not in the dictonary.");
                }
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 0;
        c.gridy = 3;
        add(searchButton, c);

        quitButton = new JButton("Quit");
        quitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 30; //Puts the button in the desired location.
        c.gridx = 1;
        c.gridy = 3;
        add(quitButton, c);
    }

    public boolean search(TreeNode current, TreeNode find) {
        if (current.getData().compareTo(find.getData()) == 0) {
            System.out.println("Definition: " + current.getDefinition());
            return true;
        } else if (current.getData().compareTo(find.getData()) > 0) {
            if (current.getLeft() == null) {
                return false;

            } else {
                search(current.getLeft(), find);
            }
        } else if (current.getData().compareTo(find.getData()) < 0) {
            if (current.getRight() == null) {
                return false;
            } else {
                search(current.getRight(), find);
            }
        }
        return false;
    }
        public void insert(TreeNode temp, TreeNode current) {
        if (root == null) {
            root = temp;

        } else if (current.getData().compareTo(temp.getData()) > 0) {
            if (current.getLeft() == null) {
                current.setLeft(temp);

            } else {
                insert(temp, current.getLeft());

            }
        } else if (current.getData().compareTo(temp.getData()) < 0) {
            if (current.getRight() == null) {
                current.setRight(temp);

            } else {
                insert(temp, current.getRight());

            }
        } else {
            System.out.println("The word has already been enter dumbass");
        }

    }
}
