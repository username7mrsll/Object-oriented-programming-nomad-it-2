import java.util.Scanner;

public class Turtle {

    private static char[][] board = new char[5][5];

    private static final int UP = 0;
    private static final int RIGHT = 1;
    private static final int DOWN = 2;
    private static final int LEFT = 3;

    private static int direction = UP;
    private static int xCoord = 0;
    private static int yCoord = 0;

    public static void main(String[] args) {
        Scanner inp = new Scanner(System.in);

        initialize();
        printBoard();

        System.out.println("Введите команду (move, turn left, turn right, quit):");

        while (inp.hasNextLine()) {
            String command = inp.nextLine().toLowerCase().trim();

            boolean actionDone = false;

            switch (command) {
                case "move":
                    move();
                    actionDone = true;
                    break;
                case "turn left":
                    turnLeft();
                    actionDone = true;
                    break;
                case "turn right":
                    turnRight();
                    actionDone = true;
                    break;
                case "print":
                    printBoard();
                    break;
                case "quit":
                    System.out.println("Программа завершена.");
                    return;
                default:
                    System.out.println("Неизвестная команда: " + command);
            }

            if (actionDone) {
                printBoard();
            }
        }
    }

    private static void updateBoard() {
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                board[i][j] = '.';
            }
        }

        char robotChar;
        switch (direction) {
            case UP:    robotChar = '^'; break;
            case DOWN:  robotChar = 'v'; break;
            case LEFT:  robotChar = '<'; break;
            case RIGHT: robotChar = '>'; break;
            default:    robotChar = '?';
        }

        board[yCoord][xCoord] = robotChar;
    }

    private static void move() {
        int nextX = xCoord;
        int nextY = yCoord;

        if (direction == UP) nextY--;
        else if (direction == DOWN) nextY++;
        else if (direction == LEFT) nextX--;
        else if (direction == RIGHT) nextX++;

        if (nextX >= 0 && nextX < 5 && nextY >= 0 && nextY < 5) {
            xCoord = nextX;
            yCoord = nextY;
            updateBoard();
        } else {
            System.out.println("Ошибка: Впереди стена!");
        }
    }

    private static void turnRight() {
        direction = (direction + 1) % 4;
        updateBoard();
    }

    private static void turnLeft() {
        direction = (direction + 3) % 4;
        updateBoard();
    }

    private static void initialize() {
        xCoord = (int) (Math.random() * 5);
        yCoord = (int) (Math.random() * 5);
        direction = UP;
        updateBoard();
    }

    private static void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }
}
