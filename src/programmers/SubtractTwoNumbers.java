package programmers;

import java.util.Scanner;

public class SubtractTwoNumbers {
    public static void main(String[] args) {
        SubtractTwoNumbers obj = new SubtractTwoNumbers();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(obj.solution(a,b));
    }
    public int solution(int num1, int num2) {
        int answer = 0;
        answer = num1 - num2;
        return answer;
    }
}
