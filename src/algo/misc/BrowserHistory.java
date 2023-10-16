package algo.misc;

import ds.linkedlist.Node;

/**
 * https://leetcode.com/problems/design-browser-history/
 */
public class BrowserHistory {
    Node head;
    Node tail;

    public BrowserHistory(String homepage) {
        Node node = new Node(homepage);
        head = node;
        tail = node;
    }

    public void visit(String url) {
        Node node = new Node(url);
        tail.right = node;
        node.left = tail;
        tail = node;
    }

    public String back(int steps) {
        while (steps > 0 && tail.left != null){
            tail = tail.left;
            steps--;
        }
        return tail.stringData;
    }

    public String forward(int steps) {
        while (steps > 0 && tail.right != null){
            tail = tail.right;
            steps--;
        }
        return tail.stringData;
    }


    public static void main(String[] args) {
        BrowserHistory bH = new BrowserHistory("leetcode.com");
        bH.visit("google.com");               // You are in "leetcode.com". Visit "google.com"
        bH.visit("facebook.com");             // You are in "google.com". Visit "facebook.com"
        bH.visit("youtube.com");              // You are in "facebook.com". Visit "youtube.com"
        System.out.println(bH.back(1));     // You are in "youtube.com", move back to "facebook.com" return "facebook.com"
        System.out.println(bH.back(1));     // You are in "facebook.com", move back to "google.com" return "google.com"
        System.out.println(bH.forward(1));  // You are in "google.com", move forward to "facebook.com" return "facebook.com"
        bH.visit("linkedin.com");             // You are in "facebook.com". Visit "linkedin.com"
        System.out.println(bH.forward(2));  // You are in "linkedin.com", you cannot move forward any steps.
        System.out.println(bH.back(2));     // You are in "linkedin.com", move back two steps to "facebook.com" then to "google.com". return "google.com"
        System.out.println(bH.back(7));     // You are in "google.com", you can move back only one step to "leetcode.com". return "leetcode.com"
    }
}
