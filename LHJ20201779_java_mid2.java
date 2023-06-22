package ch01;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class LHJ20201779_java_mid2 {
    public static void main(String[] args) {
        Random random = new Random();
        random.setSeed(System.currentTimeMillis());

        List<Integer> myRandomNumbers = new ArrayList<>();
        List<Integer> comRandomNumbers = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        String[] choices = {"가위", "바위", "보"};

        System.out.println("가위바위보 게임을 시작합니다.");

        boolean playAgain = true;

        while (playAgain) {
            System.out.println("가위, 바위, 보 중 하나를 선택하세요.");
            System.out.print("무엇을 내시겠습니까? ");
            String myChoice = scanner.nextLine();
            int computerChoice = random.nextInt(3);

            System.out.println("나: " + myChoice);
            System.out.println("컴퓨터: " + choices[computerChoice]);

            if (myChoice.equals(choices[computerChoice])) {
                System.out.println("비겼습니다!");
            } else {
                switch (myChoice) {
                    case "가위":
                        if (choices[computerChoice].equals("바위")) {
                            System.out.println("졌습니다!");
                            comRandomNumbers.add(random.nextInt(5) + 1);
                            System.out.println("상대방 랜덤 숫자 리스트: " +comRandomNumbers);
                        } else {
                            System.out.println("이겼습니다!");
                            myRandomNumbers.add(random.nextInt(5) + 1);
                            System.out.println("랜덤 숫자 리스트: " + myRandomNumbers);
                        }
                        break;

                    case "바위":
                        if (choices[computerChoice].equals("보")) {
                            System.out.println("졌습니다!");
                            comRandomNumbers.add(random.nextInt(5) + 1);
                            System.out.println("상대방 랜덤 숫자 리스트: " + comRandomNumbers);
                        } else {
                            System.out.println("이겼습니다!");
                            myRandomNumbers.add(random.nextInt(5) + 1);
                            System.out.println("랜덤 숫자 리스트: " + myRandomNumbers);
                        }
                        break;

                    case "보":
                        if (choices[computerChoice].equals("가위")) {
                            System.out.println("졌습니다!");
                            comRandomNumbers.add(random.nextInt(5) + 1);
                            System.out.println("상대방 랜덤 숫자 리스트: " + comRandomNumbers);
                        } else {
                            System.out.println("이겼습니다!");
                            myRandomNumbers.add(random.nextInt(5) + 1);
                            System.out.println("랜덤 숫자 리스트: " + myRandomNumbers);
                        }
                        break;

                    default:
                        System.out.println("잘못된 입력입니다.");
                        String retryInput;
                        do {
                            System.out.println("게임을 더 하시겠습니까? (네/아니오)");
                            retryInput = scanner.nextLine();
                        } while (!retryInput.equals("네") && !retryInput.equals("아니오"));

                        if (retryInput.equals("네")) {
                            continue;
                        } else {
                            playAgain = false;
                            break;
                        }
                }
            }

            if (checkNumbers(myRandomNumbers)) {
                System.out.println("승리했습니다!");
                playAgain = false;
                break;
            }

            
            if (checkNumbers(comRandomNumbers)) {
                System.out.println("상대방이 승리했습니다!");
                playAgain = false;
                break;
            }

        
        }

        System.out.println("게임을 종료합니다.");
    }

    private static boolean checkNumbers(List<Integer> randomNumbers) {
        Set<Integer> numberSet = new HashSet<>(randomNumbers);
        return numberSet.size() < randomNumbers.size();
    }
}
