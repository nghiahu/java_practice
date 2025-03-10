package baitap;

import java.util.Scanner;

public class BaiLuyenTap2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số hàng n: ");
        int n = scanner.nextInt();
        System.out.print("Nhập số cột m: ");
        int m = scanner.nextInt();
        int[][] arr = new int[n][m];

        do {
            System.out.println("************************MENU**************************");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sử dụng thuật toán chèn sắp xếp các phần tử trên đường chéo chính của mảng giảm dần");
            System.out.println("8. Chèn mảng 1 chiều vào mảng 2 chiều");
            System.out.println("9. Thoát");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Nhập các phần tử của mảng: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("arr[%d][%d] = ", i, j);
                            arr[i][j] = scanner.nextInt();
                        }
                    }
                    break;
                case 2:
                    System.out.println("Ma trận: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%5d", arr[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    int count = 0;
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (arr[i][j] % 2 == 0 && arr[i][j] % 3 == 0) {
                                count++;
                            }
                        }
                    }
                    System.out.println("Số lượng phần tử chia hết cho 2 và 3: " + count);
                    break;
                case 4:
                    int sum = 0;
                    System.out.print("Các phần tử trên đường biên: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                                System.out.printf("%5d", arr[i][j]);
                                sum += arr[i][j];
                            }
                        }
                    }
                    System.out.println("\nTổng các phần tử trên đường biên: " + sum);
                    sum = 0;
                    System.out.print("Các phần tử trên đường chéo chính: ");
                    for (int i = 0; i < Math.min(n, m); i++) {
                        System.out.printf("%5d", arr[i][i]);
                        sum += arr[i][i];
                    }
                    System.out.println("\nTổng các phần tử trên đường chéo chính: " + sum);
                    sum = 0;
                    System.out.print("Các phần tử trên đường chéo phụ: ");
                    for (int i = 0; i < Math.min(n, m); i++) {
                        System.out.printf("%5d", arr[i][m - i - 1]);
                        sum += arr[i][m - i - 1];
                    }
                    System.out.println("\nTổng các phần tử trên đường chéo phụ: " + sum);
                    break;
                case 5:
                    for (int j = 0; j < m; j++) {
                        for (int i = 0; i < n - 1; i++) {
                            int minIndex = i;
                            for (int k = i + 1; k < n; k++) {
                                if (arr[k][j] < arr[minIndex][j]) {
                                    minIndex = k;
                                }
                            }
                            int temp = arr[i][j];
                            arr[i][j] = arr[minIndex][j];
                            arr[minIndex][j] = temp;
                        }
                    }
                    System.out.println("Ma trận sau khi sắp xếp tăng dần theo cột: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%5d", arr[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 6:
                    System.out.print("Các phần tử là số nguyên tố: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            boolean isPrime = true;
                            if (arr[i][j] <= 1) {
                                isPrime = false;
                            } else {
                                for (int k = 2; k <= Math.sqrt(arr[i][j]); k++) {
                                    if (arr[i][j] % k == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                            }
                            if (isPrime) {
                                System.out.printf("%5d", arr[i][j]);
                            }
                        }
                    }
                    System.out.println();
                    break;
                case 7:
                    int[] diagonal = new int[Math.min(n, m)];
                    for (int i = 0; i < Math.min(n, m); i++) {
                        diagonal[i] = arr[i][i];
                    }
                    for (int i = 1; i < diagonal.length; i++) {
                        int key = diagonal[i];
                        int j = i - 1;
                        while (j >= 0 && diagonal[j] < key) {
                            diagonal[j + 1] = diagonal[j];
                            j--;
                        }
                        diagonal[j + 1] = key;
                    }
                    for (int i = 0; i < Math.min(n, m); i++) {
                        arr[i][i] = diagonal[i];
                    }

                    System.out.println("Mảng sau khi sắp xếp các phần tử trên đường chéo chính giảm dần:");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            System.out.printf("%5d", arr[i][j]);
                        }
                        System.out.println();
                    }
                    break;

                case 8:
                    System.out.print("Nhập kích thước của mảng 1 chiều: ");
                    int size = scanner.nextInt();
                    int[] oneDArray = new int[size];
                    System.out.println("Nhập các phần tử của mảng 1 chiều: ");
                    for (int i = 0; i < size; i++) {
                        System.out.printf("oneDArray[%d] = ", i);
                        oneDArray[i] = scanner.nextInt();
                    }

                    System.out.print("Nhập vị trí hàng (0 đến " + (n - 1) + ") để chèn mảng 1 chiều: ");
                    int row = scanner.nextInt();
                    System.out.print("Nhập vị trí cột (0 đến " + (m - 1) + ") để chèn mảng 1 chiều: ");
                    int col = scanner.nextInt();
                    if (row < 0 || row >= n || col < 0 || col >= m) {
                        System.out.println("Vị trí không hợp lệ!");
                    } else {
                        for (int i = 0; i < size && col + i < m; i++) {
                            arr[row][col + i] = oneDArray[i];
                        }
                        System.out.println("Mảng sau khi chèn mảng 1 chiều:");
                        for (int i = 0; i < n; i++) {
                            for (int j = 0; j < m; j++) {
                                System.out.printf("%5d", arr[i][j]);
                            }
                            System.out.println();
                        }
                    }
                    break;
                case 9:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại!");
                    break;
            }
        } while (true);
    }
}
