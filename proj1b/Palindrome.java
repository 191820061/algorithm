public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        LinkedListDeque<Character> deque = new LinkedListDeque<>();
        for (int i = 0; i < word.length(); i++) {
            deque.addLast(word.charAt(i));
        }
        return deque;
    }

    public boolean isPalindrome(String word) {
        Deque<Character> deque = wordToDeque(word);
        return isPalindrome(deque);
    }

    private boolean isPalindrome(Deque<Character> deque) {
        if (deque.size()==1||deque.size()==0){
            return true;
        }
        if (deque.removeFirst()!=deque.removeLast()){
            return false;
        }
        return isPalindrome(deque);
    }
}
